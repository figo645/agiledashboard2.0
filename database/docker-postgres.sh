#!/bin/bash

# 颜色定义
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

# 配置变量
CONTAINER_NAME="sprint-db"
DB_NAME="sprint_dashboard"
DB_PASSWORD="your_password"
DB_PORT="5432"
VOLUME_NAME="sprint-db-data"
BACKUP_DIR="./backups"

# 显示帮助信息
show_help() {
    echo -e "${GREEN}Docker PostgreSQL 管理脚本${NC}"
    echo "用法: $0 [命令]"
    echo ""
    echo "命令:"
    echo "  install     - 安装并启动 PostgreSQL 容器"
    echo "  start       - 启动容器"
    echo "  stop        - 停止容器"
    echo "  restart     - 重启容器"
    echo "  status      - 查看容器状态"
    echo "  backup      - 备份数据"
    echo "  restore     - 恢复数据"
    echo "  reset       - 重置数据库"
    echo "  logs        - 查看容器日志"
    echo "  connect     - 连接到数据库"
    echo "  help        - 显示帮助信息"
}

# 检查 Docker 是否安装
check_docker() {
    if ! command -v docker &> /dev/null; then
        echo -e "${RED}错误: Docker 未安装${NC}"
        echo "请先安装 Docker: https://docs.docker.com/get-docker/"
        exit 1
    fi
}

# 安装并启动容器
install() {
    check_docker
    
    echo -e "${YELLOW}正在创建数据卷...${NC}"
    docker volume create $VOLUME_NAME
    
    echo -e "${YELLOW}正在启动 PostgreSQL 容器...${NC}"
    docker run --name $CONTAINER_NAME \
        -e POSTGRES_PASSWORD=$DB_PASSWORD \
        -e POSTGRES_DB=$DB_NAME \
        -p $DB_PORT:5432 \
        -v $VOLUME_NAME:/var/lib/postgresql/data \
        -d postgres:14
    
    if [ $? -eq 0 ]; then
        echo -e "${GREEN}PostgreSQL 容器已成功启动${NC}"
        echo "连接信息:"
        echo "主机: localhost"
        echo "端口: $DB_PORT"
        echo "用户名: postgres"
        echo "密码: $DB_PASSWORD"
        echo "数据库: $DB_NAME"
    else
        echo -e "${RED}启动容器失败${NC}"
        exit 1
    fi
}

# 启动容器
start() {
    docker start $CONTAINER_NAME
    echo -e "${GREEN}容器已启动${NC}"
}

# 停止容器
stop() {
    docker stop $CONTAINER_NAME
    echo -e "${GREEN}容器已停止${NC}"
}

# 重启容器
restart() {
    docker restart $CONTAINER_NAME
    echo -e "${GREEN}容器已重启${NC}"
}

# 查看容器状态
status() {
    docker ps -a | grep $CONTAINER_NAME
}

# 备份数据
backup() {
    mkdir -p $BACKUP_DIR
    TIMESTAMP=$(date +%Y%m%d_%H%M%S)
    BACKUP_FILE="$BACKUP_DIR/backup_$TIMESTAMP.tar.gz"
    
    echo -e "${YELLOW}正在创建备份...${NC}"
    docker run --rm -v $VOLUME_NAME:/source -v $(pwd)/$BACKUP_DIR:/backup alpine tar -czf /backup/backup_$TIMESTAMP.tar.gz -C /source .
    
    if [ $? -eq 0 ]; then
        echo -e "${GREEN}备份已创建: $BACKUP_FILE${NC}"
    else
        echo -e "${RED}备份失败${NC}"
        exit 1
    fi
}

# 恢复数据
restore() {
    if [ -z "$1" ]; then
        echo -e "${RED}请指定备份文件${NC}"
        echo "用法: $0 restore <备份文件>"
        exit 1
    fi
    
    BACKUP_FILE=$1
    if [ ! -f "$BACKUP_FILE" ]; then
        echo -e "${RED}备份文件不存在: $BACKUP_FILE${NC}"
        exit 1
    fi
    
    echo -e "${YELLOW}正在恢复数据...${NC}"
    stop
    docker run --rm -v $VOLUME_NAME:/target -v $(pwd):/backup alpine sh -c "rm -rf /target/* && tar -xzf /backup/$BACKUP_FILE -C /target"
    start
    
    echo -e "${GREEN}数据已恢复${NC}"
}

# 重置数据库
reset() {
    read -p "确定要重置数据库吗？所有数据将被删除！(y/n): " confirm
    if [ "$confirm" != "y" ]; then
        echo "操作已取消"
        exit 0
    fi
    
    stop
    docker rm $CONTAINER_NAME
    docker volume rm $VOLUME_NAME
    install
}

# 查看容器日志
logs() {
    docker logs $CONTAINER_NAME
}

# 连接到数据库
connect() {
    docker exec -it $CONTAINER_NAME psql -U postgres -d $DB_NAME
}

# 主程序
case "$1" in
    install)
        install
        ;;
    start)
        start
        ;;
    stop)
        stop
        ;;
    restart)
        restart
        ;;
    status)
        status
        ;;
    backup)
        backup
        ;;
    restore)
        restore "$2"
        ;;
    reset)
        reset
        ;;
    logs)
        logs
        ;;
    connect)
        connect
        ;;
    help|*)
        show_help
        ;;
esac 