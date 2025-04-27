# PostgreSQL 一键部署脚本使用说明

这是一个自动化脚本，用于在 macOS 上快速部署 PostgreSQL 数据库并导入初始数据。

## 功能特点

- 自动检查并安装 Docker（如果未安装）
- 自动安装必要的 Python 依赖
- 自动创建数据库和表结构
- 自动导入 CSV 数据文件
- 自动创建初始备份
- 详细的日志记录
- 彩色输出提示

## 前置条件

- macOS 操作系统
- 管理员权限
- 网络连接（用于下载依赖）

## 使用方法

1. 准备脚本：
   - 确保 `setup-postgres.sh` 文件在项目根目录下
   - 确保脚本有执行权限（如果没有，执行：`chmod +x setup-postgres.sh`）

2. 准备数据文件：
   - 在项目根目录下创建 `data` 目录
   - 将以下 CSV 文件放入 `data` 目录：
     - `sprint_planning.csv`
     - `iteration_completion.csv`
     - `bug.csv`
     - `change.csv`
     - `testing.csv`

3. 运行脚本：
   - 在终端中进入项目根目录
   - 执行：`./setup-postgres.sh`

## 配置说明

脚本开头的配置变量可以根据需要修改：

```bash
CONTAINER_NAME="sprint-db"      # 容器名称
DB_NAME="sprint_dashboard"      # 数据库名称
DB_PASSWORD="your_password"     # 数据库密码
DB_PORT="5432"                 # 数据库端口
VOLUME_NAME="sprint-db-data"   # 数据卷名称
BACKUP_DIR="./backups"         # 备份目录
DATA_DIR="./data"             # 数据文件目录
LOG_FILE="setup.log"          # 日志文件
```

## 目录结构

脚本会自动创建以下目录结构：

```
.
├── data/              # 数据文件目录
│   ├── sprint_planning.csv
│   ├── iteration_completion.csv
│   ├── bug.csv
│   ├── change.csv
│   └── testing.csv
├── backups/           # 备份文件目录
├── database/          # 数据库脚本目录
│   └── migrations/   # 数据库迁移脚本
├── setup-postgres.sh  # 部署脚本
└── setup.log         # 日志文件
```

## 数据导入说明

脚本会自动导入以下 CSV 文件到对应的数据库表：

| CSV 文件 | 数据库表 | 说明 |
|---------|---------|------|
| sprint_planning.csv | sprint_planning | Sprint 计划数据 |
| iteration_completion.csv | iteration_completion | 迭代完成数据 |
| bug.csv | bug | Bug 数据 |
| change.csv | change | 变更数据 |
| testing.csv | testing | 测试数据 |

## 日志记录

脚本执行过程中的所有操作都会记录到 `setup.log` 文件中，包括：
- 安装步骤
- 错误信息
- 数据导入状态
- 备份创建信息

## 故障排除

1. Docker 安装问题：
   - 确保有管理员权限
   - 检查网络连接
   - 查看 Docker Desktop 是否正常运行

2. 数据导入问题：
   - 检查 CSV 文件格式是否正确
   - 查看 `import.log` 文件了解详细错误信息
   - 确保数据库表结构正确

3. 备份问题：
   - 确保有足够的磁盘空间
   - 检查备份目录的写入权限

## 维护说明

1. 定期备份：
   - 建议定期执行备份操作
   - 备份文件保存在 `backups` 目录

2. 数据更新：
   - 更新 CSV 文件后重新运行导入脚本
   - 确保 CSV 文件格式与表结构匹配

3. 日志管理：
   - 定期清理日志文件
   - 重要操作前备份日志

## 注意事项

1. 首次使用前请修改默认密码
2. 确保有足够的磁盘空间
3. 建议在稳定的网络环境下运行
4. 重要数据请定期备份
5. 生产环境请使用更安全的密码策略

## 技术支持

如有问题，请查看日志文件或联系技术支持。

## 验证安装

安装完成后，脚本会自动执行数据库验证，验证内容包括：

1. 表结构验证：
   - 检查所有必要的表是否已创建
   - 验证每个表的列结构是否正确

2. 数据验证：
   - 检查每个表的数据行数
   - 验证数据是否正确导入

验证结果会记录在 `verify.log` 文件中，包含以下信息：
- 每个表的存在状态
- 每个表的数据行数
- 每个表的列结构详情
- 任何验证过程中发现的错误

### 手动验证

如果需要手动验证数据库，可以使用以下方法：

1. 使用 psql 命令行工具：
```bash
# 连接到数据库
psql -h localhost -p 5432 -U postgres -d sprint_dashboard

# 查看表列表
\dt

# 查看表结构
\d table_name

# 查看数据行数
SELECT COUNT(*) FROM table_name;
```

2. 使用 pgAdmin 图形界面工具：
   - 下载并安装 pgAdmin
   - 连接到数据库
   - 浏览表结构和数据

### 常见验证问题

1. 表不存在：
   - 检查数据库连接是否正确
   - 确认表创建脚本是否执行成功

2. 数据行数为 0：
   - 检查 CSV 文件是否正确
   - 确认数据导入脚本是否执行成功

3. 列结构不匹配：
   - 检查表创建脚本
   - 确认 CSV 文件格式是否正确 