#!/bin/bash

# 设置环境变量
export PGPASSWORD=postgres

# 检查PostgreSQL是否正在运行
if ! pg_isready -h localhost -p 5432 -U postgres; then
    echo "PostgreSQL is not running. Please start PostgreSQL and try again."
    exit 1
fi

# 检查数据库是否存在
if psql -h localhost -p 5432 -U postgres -lqt | cut -d \| -f 1 | grep -qw sprint_dashboard; then
    echo "Database sprint_dashboard already exists. Dropping it..."
    psql -h localhost -p 5432 -U postgres -c "DROP DATABASE IF EXISTS sprint_dashboard;"
fi

# 创建数据库
echo "Creating database sprint_dashboard..."
psql -h localhost -p 5432 -U postgres -c "CREATE DATABASE sprint_dashboard;"

# 执行初始化脚本
echo "Executing initialization script..."
psql -h localhost -p 5432 -U postgres -d sprint_dashboard -f init.sql

echo "Database setup completed successfully!" 