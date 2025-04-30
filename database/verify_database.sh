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
DB_USER="postgres"
DB_PASSWORD="your_password"
DB_PORT="5432"

# 记录日志
log() {
    echo -e "$(date '+%Y-%m-%d %H:%M:%S') - $1"
}

# 检查 Docker 容器状态
check_container() {
    log "${BLUE}检查 Docker 容器状态...${NC}"
    
    if ! docker ps | grep -q $CONTAINER_NAME; then
        log "${RED}错误: PostgreSQL 容器未运行${NC}"
        log "请运行 ./docker-postgres.sh start 启动容器"
        exit 1
    fi
    
    log "${GREEN}PostgreSQL 容器正在运行${NC}"
}

# 检查数据库连接
check_connection() {
    log "${BLUE}检查数据库连接...${NC}"
    
    if ! docker exec $CONTAINER_NAME pg_isready -U $DB_USER -d $DB_NAME; then
        log "${RED}错误: 无法连接到数据库${NC}"
        exit 1
    fi
    
    log "${GREEN}数据库连接正常${NC}"
}

# 检查表结构
check_tables() {
    log "${BLUE}检查表结构...${NC}"
    
    # 定义预期的表结构
    declare -A expected_tables=(
        ["sprint_planning"]="id,program_name,team_name,planned_count,completed_count,storypoint_planned,storypoint_completed,test_points,user_story_points,user_story_ratio,enabler_points,enabler_ratio,story_throughput,cv_value,story_granularity,date"
        ["iteration_completion"]="id,team_name,planned_progress,actual_progress,date"
        ["change_tracking"]="id,team_name,change_tasks,change_points,date"
        ["testing_progress"]="id,team_name,total_test_cases,completed_test_cases,date"
        ["bug_progress"]="id,team_name,pre_fixed,pre_pending,uat_fixed,uat_pending,date"
    )
    
    # 检查每个表
    for table in "${!expected_tables[@]}"; do
        log "检查表: $table"
        
        # 检查表是否存在
        if ! docker exec $CONTAINER_NAME psql -U $DB_USER -d $DB_NAME -t -c "SELECT EXISTS (SELECT FROM information_schema.tables WHERE table_name = '$table');" | grep -q t; then
            log "${RED}错误: 表 $table 不存在${NC}"
            exit 1
        fi
        
        # 获取实际列名
        actual_columns=$(docker exec $CONTAINER_NAME psql -U $DB_USER -d $DB_NAME -t -c "SELECT string_agg(column_name, ',') FROM information_schema.columns WHERE table_name = '$table';" | tr -d ' ')
        
        # 比较列名
        if [ "$actual_columns" != "${expected_tables[$table]}" ]; then
            log "${RED}错误: 表 $table 的列结构不匹配${NC}"
            log "预期: ${expected_tables[$table]}"
            log "实际: $actual_columns"
            exit 1
        fi
        
        # 检查非空约束
        non_null_columns=$(docker exec $CONTAINER_NAME psql -U $DB_USER -d $DB_NAME -t -c "SELECT string_agg(column_name, ',') FROM information_schema.columns WHERE table_name = '$table' AND is_nullable = 'NO';" | tr -d ' ')
        
        if [ "$non_null_columns" != "${expected_tables[$table]}" ]; then
            log "${RED}错误: 表 $table 的非空约束不匹配${NC}"
            log "预期所有列都应该是非空的"
            log "实际非空列: $non_null_columns"
            exit 1
        fi
        
        log "${GREEN}表 $table 结构正确${NC}"
    done
}

# 检查索引
check_indexes() {
    log "${BLUE}检查索引...${NC}"
    
    # 定义预期的索引
    declare -a expected_indexes=(
        "idx_sprint_planning_date"
        "idx_iteration_completion_date"
        "idx_change_tracking_date"
        "idx_testing_progress_date"
        "idx_bug_progress_date"
    )
    
    # 检查每个索引
    for index in "${expected_indexes[@]}"; do
        if ! docker exec $CONTAINER_NAME psql -U $DB_USER -d $DB_NAME -t -c "SELECT EXISTS (SELECT 1 FROM pg_indexes WHERE indexname = '$index');" | grep -q t; then
            log "${RED}错误: 索引 $index 不存在${NC}"
            exit 1
        fi
        log "${GREEN}索引 $index 存在${NC}"
    done
}

# 检查视图
check_views() {
    log "${BLUE}检查视图...${NC}"
    
    if ! docker exec $CONTAINER_NAME psql -U $DB_USER -d $DB_NAME -t -c "SELECT EXISTS (SELECT 1 FROM pg_views WHERE viewname = 'sprint_metrics');" | grep -q t; then
        log "${RED}错误: 视图 sprint_metrics 不存在${NC}"
        exit 1
    fi
    
    log "${GREEN}视图 sprint_metrics 存在${NC}"
}

# 主程序
main() {
    log "${BLUE}开始验证数据库...${NC}"
    
    # 检查容器状态
    check_container
    
    # 检查数据库连接
    check_connection
    
    # 检查表结构
    check_tables
    
    # 检查索引
    check_indexes
    
    # 检查视图
    check_views
    
    log "${GREEN}数据库验证完成，所有检查都通过！${NC}"
}

# 执行主程序
main 