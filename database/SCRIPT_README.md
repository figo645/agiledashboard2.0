# Docker PostgreSQL 管理脚本使用说明

这是一个用于管理 Docker PostgreSQL 容器的 bash 脚本，提供了简单的命令行界面来执行常见的数据库管理任务。

## 安装

1. 下载脚本：
```bash
curl -O https://raw.githubusercontent.com/your-repo/database/docker-postgres.sh
```

2. 添加执行权限：
```bash
chmod +x docker-postgres.sh
```

## 使用方法

### 基本命令

```bash
# 显示帮助信息
./docker-postgres.sh help

# 安装并启动 PostgreSQL
./docker-postgres.sh install

# 启动容器
./docker-postgres.sh start

# 停止容器
./docker-postgres.sh stop

# 重启容器
./docker-postgres.sh restart

# 查看容器状态
./docker-postgres.sh status

# 连接到数据库
./docker-postgres.sh connect

# 查看容器日志
./docker-postgres.sh logs
```

### 数据管理

```bash
# 备份数据
./docker-postgres.sh backup

# 恢复数据
./docker-postgres.sh restore backups/backup_20230101_120000.tar.gz

# 重置数据库（会删除所有数据）
./docker-postgres.sh reset
```

## 配置修改

您可以通过编辑脚本开头的配置变量来修改默认设置：

```bash
# 配置变量
CONTAINER_NAME="sprint-db"      # 容器名称
DB_NAME="sprint_dashboard"      # 数据库名称
DB_PASSWORD="your_password"     # 数据库密码
DB_PORT="5432"                 # 数据库端口
VOLUME_NAME="sprint-db-data"   # 数据卷名称
BACKUP_DIR="./backups"         # 备份目录
```

## 注意事项

1. 首次使用前请修改默认密码
2. 定期执行备份操作
3. 重置操作会删除所有数据，请谨慎使用
4. 确保有足够的磁盘空间用于备份
5. 建议将备份文件保存在安全的位置

## 故障排除

1. 如果脚本无法执行，请检查：
   - 文件权限是否正确
   - Docker 是否已安装并运行
   - 是否有足够的系统权限

2. 如果容器无法启动，请检查：
   - 端口是否被占用
   - 数据卷是否已存在
   - 系统资源是否充足

3. 如果备份/恢复失败，请检查：
   - 备份目录是否有写入权限
   - 磁盘空间是否充足
   - 备份文件是否完整

## 示例

### 完整的工作流程

```bash
# 1. 安装并启动数据库
./docker-postgres.sh install

# 2. 检查状态
./docker-postgres.sh status

# 3. 连接到数据库
./docker-postgres.sh connect

# 4. 创建备份
./docker-postgres.sh backup

# 5. 停止数据库
./docker-postgres.sh stop

# 6. 恢复数据
./docker-postgres.sh restore backups/backup_20230101_120000.tar.gz
```

## 贡献

欢迎提交问题和改进建议。请确保在提交更改前测试所有功能。 