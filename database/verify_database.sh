#!/bin/bash

# 颜色定义
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

# 配置变量
CONTAINER_NAME="sprint-db"      # Docker 容器名称
DB_NAME="sprint_dashboard"
DB_USER="postgres"
DB_PASSWORD="your_password"
DB_HOST="localhost"
DB_PORT="5432"
LOG_FILE="verify.log"

# 记录日志
log() {
    echo -e "$(date '+%Y-%m-%d %H:%M:%S') - $1" | tee -a $LOG_FILE
}

# 检查 Docker 容器状态
check_docker_container() {
    log "${BLUE}检查 Docker 容器状态...${NC}"
    if ! docker ps | grep -q "$CONTAINER_NAME"; then
        log "${RED}PostgreSQL 容器未运行${NC}"
        log "请确保已经运行了 setup-postgres.sh 脚本"
        log "或者手动启动容器：docker start $CONTAINER_NAME"
        exit 1
    fi
    log "${GREEN}PostgreSQL 容器正在运行${NC}"
}

# 检查端口是否开放
check_port() {
    log "${BLUE}检查端口 $DB_PORT 是否开放...${NC}"
    if ! nc -z $DB_HOST $DB_PORT; then
        log "${RED}端口 $DB_PORT 未开放${NC}"
        log "请检查："
        log "1. PostgreSQL 容器是否正常运行"
        log "2. 端口映射是否正确配置"
        log "3. 防火墙设置"
        exit 1
    fi
    log "${GREEN}端口 $DB_PORT 已开放${NC}"
}

# 检查数据库连接
check_connection() {
    log "${BLUE}检查数据库连接...${NC}"
    
    # 首先检查 Docker 容器
    check_docker_container
    
    # 检查端口
    check_port
    
    # 尝试连接数据库
    log "尝试连接数据库..."
    if ! PGPASSWORD=$DB_PASSWORD psql -h $DB_HOST -p $DB_PORT -U $DB_USER -d $DB_NAME -c "SELECT 1" > /dev/null 2>&1; then
        log "${RED}无法连接到数据库${NC}"
        log "请检查以下配置："
        log "1. 数据库配置："
        log "   - 主机: $DB_HOST"
        log "   - 端口: $DB_PORT"
        log "   - 用户名: $DB_USER"
        log "   - 数据库: $DB_NAME"
        log "   - 密码: $DB_PASSWORD"
        log ""
        log "2. 可能的问题："
        log "   - 密码是否正确"
        log "   - 数据库是否已创建"
        log "   - 用户权限是否正确"
        log ""
        log "3. 诊断步骤："
        log "   a. 检查容器日志：docker logs $CONTAINER_NAME"
        log "   b. 进入容器检查：docker exec -it $CONTAINER_NAME psql -U postgres"
        log "   c. 检查数据库列表：docker exec -it $CONTAINER_NAME psql -U postgres -l"
        exit 1
    fi
    log "${GREEN}数据库连接成功${NC}"
}

# 检查表结构
check_tables() {
    log "${BLUE}检查表结构...${NC}"
    
    # 创建临时SQL文件
    cat > temp/check_tables.sql << 'EOL'
\o temp/table_check.txt
\pset format unaligned
\pset tuples_only on

-- 检查表是否存在
SELECT table_name 
FROM information_schema.tables 
WHERE table_schema = 'public' 
AND table_name IN ('sprint_planning', 'iteration_completion', 'bug', 'change', 'testing');

-- 检查每个表的行数
SELECT 'sprint_planning' as table_name, COUNT(*) as row_count FROM sprint_planning;
SELECT 'iteration_completion' as table_name, COUNT(*) as row_count FROM iteration_completion;
SELECT 'bug' as table_name, COUNT(*) as row_count FROM bug;
SELECT 'change' as table_name, COUNT(*) as row_count FROM change;
SELECT 'testing' as table_name, COUNT(*) as row_count FROM testing;

-- 检查表结构
\o temp/table_structure.txt
\pset format aligned
\pset tuples_only off

\d sprint_planning
\d iteration_completion
\d bug
\d change
\d testing
EOL

    # 执行SQL检查
    PGPASSWORD=$DB_PASSWORD psql -h $DB_HOST -p $DB_PORT -U $DB_USER -d $DB_NAME -f temp/check_tables.sql >> $LOG_FILE 2>&1
    
    # 分析结果
    if grep -q "0 rows" temp/table_check.txt; then
        log "${RED}发现空表${NC}"
        grep "0 rows" temp/table_check.txt >> $LOG_FILE
    fi
    
    # 显示表结构
    log "${BLUE}表结构详情：${NC}"
    cat temp/table_structure.txt >> $LOG_FILE
    
    # 清理临时文件
    rm -rf temp
}

# 检查数据完整性
check_data_integrity() {
    log "${BLUE}检查数据完整性...${NC}"
    
    # 创建临时Python脚本
    cat > temp/check_data.py << 'EOL'
import psycopg2
import pandas as pd
import logging

# 配置日志
logging.basicConfig(
    level=logging.INFO,
    format='%(asctime)s - %(levelname)s - %(message)s',
    filename='data_check.log'
)
logger = logging.getLogger(__name__)

# 数据库连接配置
DB_CONFIG = {
    'dbname': 'sprint_dashboard',
    'user': 'postgres',
    'password': 'your_password',
    'host': 'localhost',
    'port': '5432'
}

def check_data_quality():
    try:
        # 连接数据库
        conn = psycopg2.connect(**DB_CONFIG)
        
        # 检查每个表的数据质量
        tables = ['sprint_planning', 'iteration_completion', 'bug', 'change', 'testing']
        for table in tables:
            logger.info(f"\n检查表 {table} 的数据质量:")
            
            # 读取数据到DataFrame
            df = pd.read_sql(f"SELECT * FROM {table}", conn)
            
            # 基本统计信息
            logger.info(f"总行数: {len(df)}")
            logger.info(f"列数: {len(df.columns)}")
            
            # 检查空值
            null_counts = df.isnull().sum()
            if null_counts.any():
                logger.info("空值统计:")
                for col, count in null_counts[null_counts > 0].items():
                    logger.info(f"  {col}: {count} 个空值")
            
            # 检查数据类型
            logger.info("数据类型:")
            for col, dtype in df.dtypes.items():
                logger.info(f"  {col}: {dtype}")
            
            # 数值列的统计信息
            numeric_cols = df.select_dtypes(include=['number']).columns
            if not numeric_cols.empty:
                logger.info("数值列统计:")
                stats = df[numeric_cols].describe()
                logger.info(stats.to_string())
        
    except Exception as e:
        logger.error(f"数据质量检查过程中发生错误: {str(e)}")
    finally:
        if conn:
            conn.close()

if __name__ == "__main__":
    check_data_quality()
EOL

    # 修改数据库配置
    sed -i '' "s/'password': 'your_password'/'password': '$DB_PASSWORD'/" temp/check_data.py
    
    # 执行数据检查
    log "执行数据质量检查..."
    python3 temp/check_data.py
    
    # 清理临时文件
    rm -rf temp
}

# 主函数
main() {
    log "${BLUE}开始数据库验证...${NC}"
    
    # 创建临时目录
    mkdir -p temp
    
    # 执行验证步骤
    check_connection
    check_tables
    check_data_integrity
    
    log "${GREEN}验证完成！${NC}"
    log "详细结果请查看以下文件："
    log "- 主要日志: $LOG_FILE"
    log "- 数据质量检查: data_check.log"
}

# 执行主函数
main 