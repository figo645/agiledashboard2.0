#!/bin/bash

# 确保脚本在错误时退出
set -e

echo "开始部署敏捷迭代看板..."

# 检查Docker是否安装
if ! command -v docker &> /dev/null; then
    echo "错误: Docker未安装"
    exit 1
fi

# 检查Docker Compose是否安装
if ! command -v docker-compose &> /dev/null; then
    echo "错误: Docker Compose未安装"
    exit 1
fi

# 停止并删除旧容器（如果存在）
echo "清理旧容器..."
docker-compose down

# 构建新镜像
echo "构建新镜像..."
docker-compose build --no-cache

# 启动新容器
echo "启动新容器..."
docker-compose up -d

# 检查容器是否成功启动
echo "检查容器状态..."
if [ $(docker-compose ps -q | wc -l) -eq 1 ]; then
    echo "部署成功！"
    echo "应用已启动在 http://localhost:8082"
else
    echo "部署失败，请检查日志"
    docker-compose logs
    exit 1
fi 