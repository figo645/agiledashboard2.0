#!/bin/bash

# 颜色定义
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

# 配置变量
CONTAINER_NAME="sprint-db"
DB_NAME="sprint_dashboard"
DB_PASSWORD="your_password"
DB_PORT="5432"
VOLUME_NAME="sprint-db-data"
BACKUP_DIR="./backups"
DATA_DIR="./data"
LOG_FILE="setup.log"
DOCKER_DMG="Docker.dmg"
DOCKER_URL="https://desktop.docker.com/mac/main/amd64/Docker.dmg"

# 记录日志
log() {
    echo -e "$(date '+%Y-%m-%d %H:%M:%S') - $1" | tee -a $LOG_FILE
}

# 安装 Docker
install_docker() {
    log "${BLUE}开始安装 Docker...${NC}"
    
    # 下载 Docker Desktop
    log "正在下载 Docker Desktop..."
    if ! curl -L $DOCKER_URL -o $DOCKER_DMG; then
        log "${RED}下载 Docker Desktop 失败${NC}"
        log "请手动访问 https://www.docker.com/products/docker-desktop 下载并安装"
        exit 1
    fi
    
    # 挂载 DMG 文件
    log "正在挂载 Docker Desktop 安装包..."
    hdiutil attach $DOCKER_DMG
    
    # 复制应用程序到 Applications 目录
    log "正在安装 Docker Desktop..."
    cp -R "/Volumes/Docker/Docker.app" /Applications/
    
    # 卸载 DMG 文件
    log "正在卸载安装包..."
    hdiutil detach "/Volumes/Docker"
    
    # 删除下载的 DMG 文件
    rm $DOCKER_DMG
    
    log "${GREEN}Docker Desktop 安装完成${NC}"
    log "请启动 Docker Desktop 应用程序，然后重新运行此脚本"
    open /Applications/Docker.app
    exit 0
}

# 检查 Docker
check_docker() {
    log "${BLUE}检查 Docker 安装...${NC}"
    if ! command -v docker &> /dev/null; then
        log "${RED}错误: Docker 未安装${NC}"
        read -p "是否要自动安装 Docker？(y/n): " choice
        case "$choice" in 
            y|Y ) install_docker;;
            * ) 
                log "请访问 https://www.docker.com/products/docker-desktop 下载并安装 Docker Desktop"
                log "安装完成后，请重新运行此脚本"
                exit 1
                ;;
        esac
    fi
    
    # 检查 Docker 是否正在运行
    if ! docker info &> /dev/null; then
        log "${RED}错误: Docker 未运行${NC}"
        log "正在启动 Docker Desktop..."
        open /Applications/Docker.app
        log "请等待 Docker 启动完成（约30秒），然后按回车继续..."
        read
    fi
    
    log "${GREEN}Docker 已安装并正在运行${NC}"
}

# 检查 Python 依赖
check_python_deps() {
    log "${BLUE}检查 Python 依赖...${NC}"
    if ! command -v pip3 &> /dev/null; then
        log "${RED}错误: pip3 未安装${NC}"
        log "正在安装 pip3..."
        curl https://bootstrap.pypa.io/get-pip.py -o get-pip.py
        python3 get-pip.py
        rm get-pip.py
    fi
    
    log "安装必要的 Python 包..."
    pip3 install psycopg2-binary pandas >> $LOG_FILE 2>&1
    log "${GREEN}Python 依赖已安装${NC}"
}

# 创建目录结构
create_directories() {
    log "${BLUE}创建目录结构...${NC}"
    mkdir -p $BACKUP_DIR
    mkdir -p $DATA_DIR
    log "${GREEN}目录结构已创建${NC}"
}

# 启动 PostgreSQL
start_postgres() {
    log "${BLUE}启动 PostgreSQL...${NC}"
    
    # 检查容器是否已存在
    if docker ps -a | grep -q $CONTAINER_NAME; then
        log "${YELLOW}容器已存在，正在停止并删除...${NC}"
        docker stop $CONTAINER_NAME >> $LOG_FILE 2>&1
        docker rm $CONTAINER_NAME >> $LOG_FILE 2>&1
    fi
    
    # 检查数据卷是否已存在
    if docker volume ls | grep -q $VOLUME_NAME; then
        log "${YELLOW}数据卷已存在，正在删除...${NC}"
        docker volume rm $VOLUME_NAME >> $LOG_FILE 2>&1
    fi
    
    # 创建数据卷
    log "创建数据卷..."
    docker volume create $VOLUME_NAME >> $LOG_FILE 2>&1
    
    # 启动容器
    log "启动 PostgreSQL 容器..."
    docker run --name $CONTAINER_NAME \
        -e POSTGRES_PASSWORD=$DB_PASSWORD \
        -e POSTGRES_DB=$DB_NAME \
        -p $DB_PORT:5432 \
        -v $VOLUME_NAME:/var/lib/postgresql/data \
        -d postgres:14 >> $LOG_FILE 2>&1
    
    # 等待容器启动
    log "等待容器启动..."
    sleep 10
    
    if docker ps | grep -q $CONTAINER_NAME; then
        log "${GREEN}PostgreSQL 已成功启动${NC}"
    else
        log "${RED}PostgreSQL 启动失败${NC}"
        exit 1
    fi
}

# 创建数据库表
create_tables() {
    log "${BLUE}创建数据库表...${NC}"
    
    # 等待数据库完全启动
    sleep 5
    
    # 执行 SQL 脚本
    for sql_file in database/migrations/*.sql; do
        log "执行 $sql_file..."
        docker exec -i $CONTAINER_NAME psql -U postgres -d $DB_NAME < $sql_file >> $LOG_FILE 2>&1
    done
    
    log "${GREEN}数据库表已创建${NC}"
}

# 导入数据
import_data() {
    log "${BLUE}导入数据...${NC}"
    
    # 创建临时目录用于导入脚本
    mkdir -p temp
    cat > temp/import_data.py << 'EOL'
import psycopg2
import pandas as pd
from datetime import datetime
import os
import logging

# 配置日志
logging.basicConfig(
    level=logging.INFO,
    format='%(asctime)s - %(levelname)s - %(message)s',
    filename='import.log'
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

def import_csv_to_postgres(csv_file, table_name, data_date):
    try:
        # 读取CSV文件
        logger.info(f"Reading CSV file: {csv_file}")
        df = pd.read_csv(csv_file)
        
        # 添加数据日期列
        df['data_date'] = data_date
        
        # 连接数据库
        logger.info("Connecting to database")
        conn = psycopg2.connect(**DB_CONFIG)
        cursor = conn.cursor()
        
        # 准备插入语句
        columns = ', '.join(df.columns)
        values = ', '.join(['%s'] * len(df.columns))
        insert_query = f"INSERT INTO {table_name} ({columns}) VALUES ({values})"
        
        # 执行批量插入
        logger.info(f"Importing data into {table_name}")
        cursor.executemany(insert_query, df.values.tolist())
        
        # 提交事务
        conn.commit()
        logger.info(f"Successfully imported {len(df)} rows into {table_name}")
        
    except Exception as e:
        logger.error(f"Error importing {csv_file}: {str(e)}")
        if conn:
            conn.rollback()
    finally:
        if conn:
            cursor.close()
            conn.close()

def main():
    # 设置数据日期
    data_date = datetime.now().date()
    
    # CSV文件路径
    csv_files = {
        'sprint_planning': 'data/sprint_planning.csv',
        'iteration_completion': 'data/iteration_completion.csv',
        'bug': 'data/bug.csv',
        'change': 'data/change.csv',
        'testing': 'data/testing.csv'
    }
    
    # 导入每个CSV文件
    for table_name, csv_file in csv_files.items():
        if os.path.exists(csv_file):
            import_csv_to_postgres(csv_file, table_name, data_date)
        else:
            logger.warning(f"CSV file not found: {csv_file}")

if __name__ == "__main__":
    main()
EOL

    # 修改数据库配置
    sed -i '' "s/'password': 'your_password'/'password': '$DB_PASSWORD'/" temp/import_data.py
    
    # 执行导入脚本
    log "执行数据导入..."
    python3 temp/import_data.py
    
    # 清理临时文件
    rm -rf temp
    
    log "${GREEN}数据导入完成${NC}"
}

# 验证数据库
verify_database() {
    log "${BLUE}验证数据库...${NC}"
    
    # 创建验证脚本
    cat > temp/verify_db.py << 'EOL'
import psycopg2
import logging

# 配置日志
logging.basicConfig(
    level=logging.INFO,
    format='%(asctime)s - %(levelname)s - %(message)s',
    filename='verify.log'
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

def verify_tables():
    try:
        # 连接数据库
        conn = psycopg2.connect(**DB_CONFIG)
        cursor = conn.cursor()
        
        # 检查表是否存在
        tables = ['sprint_planning', 'iteration_completion', 'bug', 'change', 'testing']
        for table in tables:
            cursor.execute(f"SELECT EXISTS (SELECT FROM information_schema.tables WHERE table_name = '{table}')")
            exists = cursor.fetchone()[0]
            if exists:
                logger.info(f"表 {table} 存在")
                # 检查数据行数
                cursor.execute(f"SELECT COUNT(*) FROM {table}")
                count = cursor.fetchone()[0]
                logger.info(f"表 {table} 包含 {count} 条记录")
            else:
                logger.error(f"表 {table} 不存在")
        
        # 检查表结构
        for table in tables:
            cursor.execute(f"""
                SELECT column_name, data_type 
                FROM information_schema.columns 
                WHERE table_name = '{table}'
            """)
            columns = cursor.fetchall()
            logger.info(f"表 {table} 的列结构:")
            for col in columns:
                logger.info(f"  - {col[0]}: {col[1]}")
        
    except Exception as e:
        logger.error(f"验证过程中发生错误: {str(e)}")
    finally:
        if conn:
            cursor.close()
            conn.close()

if __name__ == "__main__":
    verify_tables()
EOL

    # 修改数据库配置
    sed -i '' "s/'password': 'your_password'/'password': '$DB_PASSWORD'/" temp/verify_db.py
    
    # 执行验证脚本
    log "执行数据库验证..."
    python3 temp/verify_db.py
    
    # 显示验证结果
    log "验证结果已记录到 verify.log 文件"
    log "请查看 verify.log 文件了解详细信息"
    
    # 清理临时文件
    rm -rf temp
}

# 创建备份
create_backup() {
    log "${BLUE}创建初始备份...${NC}"
    mkdir -p $BACKUP_DIR
    TIMESTAMP=$(date +%Y%m%d_%H%M%S)
    BACKUP_FILE="$BACKUP_DIR/initial_backup_$TIMESTAMP.tar.gz"
    
    docker run --rm -v $VOLUME_NAME:/source -v $(pwd)/$BACKUP_DIR:/backup alpine tar -czf /backup/initial_backup_$TIMESTAMP.tar.gz -C /source . >> $LOG_FILE 2>&1
    
    log "${GREEN}初始备份已创建: $BACKUP_FILE${NC}"
}

# 显示连接信息
show_connection_info() {
    log "${GREEN}安装完成！${NC}"
    echo -e "\n${BLUE}连接信息：${NC}"
    echo "主机: localhost"
    echo "端口: $DB_PORT"
    echo "用户名: postgres"
    echo "密码: $DB_PASSWORD"
    echo "数据库: $DB_NAME"
    echo -e "\n${BLUE}管理命令：${NC}"
    echo "启动: docker start $CONTAINER_NAME"
    echo "停止: docker stop $CONTAINER_NAME"
    echo "重启: docker restart $CONTAINER_NAME"
    echo "查看日志: docker logs $CONTAINER_NAME"
}

# 主程序
main() {
    log "${BLUE}开始安装 PostgreSQL...${NC}"
    
    # 检查依赖
    check_docker
    check_python_deps
    
    # 创建目录
    create_directories
    
    # 启动 PostgreSQL
    start_postgres
    
    # 创建表
    create_tables
    
    # 导入数据
    import_data
    
    # 验证数据库
    verify_database
    
    # 创建备份
    create_backup
    
    # 显示连接信息
    show_connection_info
    
    log "${GREEN}安装完成！${NC}"
}

# 执行主程序
main 