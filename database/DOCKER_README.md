# Docker PostgreSQL 安装和使用指南

本文档提供了使用 Docker 安装和运行 PostgreSQL 的详细说明，包括数据持久化配置。

## 目录
- [安装 Docker](#安装-docker)
- [初始设置](#初始设置)
- [日常使用](#日常使用)
- [数据备份和恢复](#数据备份和恢复)
- [故障排除](#故障排除)

## 安装 Docker

1. 安装 Docker Desktop for Mac：
```bash
brew install --cask docker
```

2. 启动 Docker Desktop 应用

3. 验证安装：
```bash
docker --version
```

## 初始设置

1. 创建数据卷：
```bash
docker volume create sprint-db-data
```

2. 启动 PostgreSQL 容器：
```bash
docker run --name sprint-db \
  -e POSTGRES_PASSWORD=your_password \
  -e POSTGRES_DB=sprint_dashboard \
  -p 5432:5432 \
  -v sprint-db-data:/var/lib/postgresql/data \
  -d postgres:14
```

参数说明：
- `--name sprint-db`: 容器名称
- `-e POSTGRES_PASSWORD`: 数据库密码
- `-e POSTGRES_DB`: 数据库名称
- `-p 5432:5432`: 端口映射
- `-v sprint-db-data:/var/lib/postgresql/data`: 数据持久化卷
- `-d`: 后台运行
- `postgres:14`: PostgreSQL 14 版本

3. 验证容器运行状态：
```bash
docker ps
```

## 日常使用

### 启动和停止

```bash
# 启动容器
docker start sprint-db

# 停止容器
docker stop sprint-db

# 重启容器
docker restart sprint-db
```

### 连接到数据库

```bash
# 使用 psql 命令行工具连接
docker exec -it sprint-db psql -U postgres -d sprint_dashboard

# 使用外部工具连接
# 主机: localhost
# 端口: 5432
# 用户名: postgres
# 密码: your_password
# 数据库: sprint_dashboard
```

### 查看日志

```bash
docker logs sprint-db
```

## 数据备份和恢复

### 备份数据

```bash
# 创建备份
docker run --rm -v sprint-db-data:/source -v $(pwd):/backup alpine tar -czf /backup/backup.tar.gz -C /source .
```

### 恢复数据

```bash
# 停止容器
docker stop sprint-db

# 恢复备份
docker run --rm -v sprint-db-data:/target -v $(pwd):/backup alpine sh -c "rm -rf /target/* && tar -xzf /backup/backup.tar.gz -C /target"

# 启动容器
docker start sprint-db
```

## 故障排除

### 常见问题

1. 容器无法启动
```bash
# 查看容器日志
docker logs sprint-db

# 检查卷状态
docker volume inspect sprint-db-data
```

2. 数据访问问题
```bash
# 检查容器状态
docker ps -a

# 检查卷挂载
docker inspect sprint-db
```

3. 端口冲突
```bash
# 检查端口占用
lsof -i :5432

# 修改端口映射（例如改为5433）
docker run --name sprint-db \
  -e POSTGRES_PASSWORD=your_password \
  -e POSTGRES_DB=sprint_dashboard \
  -p 5433:5432 \
  -v sprint-db-data:/var/lib/postgresql/data \
  -d postgres:14
```

### 重置数据库

如果需要完全重置数据库：

```bash
# 停止并删除容器
docker stop sprint-db
docker rm sprint-db

# 删除数据卷（会丢失所有数据）
docker volume rm sprint-db-data

# 重新创建卷和容器
docker volume create sprint-db-data
docker run --name sprint-db \
  -e POSTGRES_PASSWORD=your_password \
  -e POSTGRES_DB=sprint_dashboard \
  -p 5432:5432 \
  -v sprint-db-data:/var/lib/postgresql/data \
  -d postgres:14
```

## 注意事项

1. 定期备份数据
2. 不要在生产环境中使用默认密码
3. 考虑使用环境变量文件管理敏感信息
4. 监控容器资源使用情况
5. 定期更新 PostgreSQL 镜像

## 推荐工具

1. DBeaver（数据库管理工具）：
```bash
brew install --cask dbeaver-community
```

2. pgAdmin（PostgreSQL 管理工具）：
```bash
brew install --cask pgadmin4
```

## 参考资源

- [Docker 官方文档](https://docs.docker.com/)
- [PostgreSQL 官方文档](https://www.postgresql.org/docs/)
- [Docker Hub PostgreSQL](https://hub.docker.com/_/postgres) 