# Sprint Dashboard 数据库

这个目录包含了 Sprint Dashboard 项目的数据库相关配置和脚本。

## 目录结构

```
database/
├── README.md                 # 数据库文档
├── init.sql                  # 数据库初始化脚本
├── docker-postgres.sh        # Docker PostgreSQL 管理脚本
├── setup-postgres.sh         # 本地 PostgreSQL 设置脚本
└── verify_database.sh        # 数据库验证脚本
```

## 数据库配置

- 数据库名称：sprint_dashboard
- 用户名：postgres
- 密码：your_password
- 端口：5432

## 数据库表结构

### 1. sprint_planning
- 存储 Sprint 计划相关数据
- 包含团队、计划需求数、完成数、故事点等信息

### 2. iteration_completion
- 存储迭代完成进度数据
- 包含团队、计划进度、实际进度等信息

### 3. change_tracking
- 存储变更跟踪数据
- 包含团队、变更任务数、变更点数等信息

### 4. testing_progress
- 存储测试进度数据
- 包含团队、总测试用例数、已完成测试用例数等信息

### 5. bug_progress
- 存储 Bug 处理进度数据
- 包含团队、Pre环境、UAT环境的 Bug 状态等信息

## 使用说明

### 1. 使用 Docker 部署

1. 启动 PostgreSQL 容器：
```bash
./docker-postgres.sh install
```

2. 管理容器：
```bash
# 启动容器
./docker-postgres.sh start

# 停止容器
./docker-postgres.sh stop

# 重启容器
./docker-postgres.sh restart

# 查看容器状态
./docker-postgres.sh status

# 查看容器日志
./docker-postgres.sh logs

# 连接到数据库
./docker-postgres.sh connect
```

### 2. 使用本地 PostgreSQL

1. 设置本地数据库：
```bash
./setup-postgres.sh
```

### 3. 验证数据库

验证数据库结构和配置：
```bash
./verify_database.sh
```

## 数据库维护

### 备份和恢复

1. 创建备份：
```bash
./docker-postgres.sh backup
```

2. 恢复备份：
```bash
./docker-postgres.sh restore <备份文件>
```

### 重置数据库

重置数据库（会删除所有数据）：
```bash
./docker-postgres.sh reset
```

## 注意事项

1. 确保 Docker 已安装并运行（如果使用 Docker 部署）
2. 确保 PostgreSQL 已安装（如果使用本地部署）
3. 所有脚本都需要执行权限，可以使用 `chmod +x *.sh` 添加权限
4. 数据库密码在脚本中硬编码为 "your_password"，生产环境请修改
5. 定期备份重要数据

## 故障排除

1. 如果容器无法启动：
   - 检查 Docker 是否运行
   - 检查端口 5432 是否被占用
   - 查看容器日志：`docker logs sprint-db`

2. 如果数据库连接失败：
   - 检查容器状态
   - 验证连接信息（主机、端口、用户名、密码）
   - 检查防火墙设置

3. 如果验证脚本失败：
   - 检查数据库结构是否与 init.sql 一致
   - 检查表、索引、视图是否存在
   - 检查非空约束是否正确

## 开发建议

1. 修改数据库结构时：
   - 更新 init.sql 文件
   - 更新 verify_database.sh 中的验证逻辑
   - 测试数据库重置和验证流程

2. 数据迁移时：
   - 创建备份
   - 使用事务确保数据一致性
   - 验证迁移后的数据

3. 性能优化：
   - 使用适当的索引
   - 定期维护数据库
   - 监控数据库性能 