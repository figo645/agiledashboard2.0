# Sprint Dashboard API 文档

## 概述

本文档提供了 Sprint Dashboard 项目的 API 接口说明和使用指南。

## API 文档生成

### 环境要求

- Java 17 或更高版本
- Maven 3.6 或更高版本
- 操作系统：Windows/Linux/macOS

### 生成文档

1. 确保您已经安装了所需的环境
2. 在项目根目录下执行：
   ```bash
   chmod +x docs/generate-javadoc.sh
   ./docs/generate-javadoc.sh
   ```
3. 生成的文档位于 `docs/api` 目录下
4. 使用浏览器打开 `docs/api/index.html` 查看文档

## API 接口说明

### 1. Sprint 计划接口

#### 1.1 获取所有 Sprint 计划
- **URL**: `/api/sprint-plannings`
- **方法**: GET
- **描述**: 获取所有团队的 Sprint 计划数据
- **参数**: 
  - `page`: 页码（可选）
  - `size`: 每页大小（可选）
  - `sort`: 排序字段（可选）
- **返回**: Sprint 计划列表

#### 1.2 创建 Sprint 计划
- **URL**: `/api/sprint-plannings`
- **方法**: POST
- **描述**: 创建新的 Sprint 计划
- **请求体**: SprintPlanning 对象
- **返回**: 创建的 Sprint 计划

### 2. 迭代完成度接口

#### 2.1 获取迭代完成度
- **URL**: `/api/iteration-completions`
- **方法**: GET
- **描述**: 获取所有团队的迭代完成度数据
- **参数**: 
  - `page`: 页码（可选）
  - `size`: 每页大小（可选）
  - `sort`: 排序字段（可选）
- **返回**: 迭代完成度列表

#### 2.2 更新迭代完成度
- **URL**: `/api/iteration-completions/{id}`
- **方法**: PUT
- **描述**: 更新指定的迭代完成度数据
- **请求体**: IterationCompletion 对象
- **返回**: 更新后的迭代完成度

### 3. 变更跟踪接口

#### 3.1 获取变更记录
- **URL**: `/api/change-trackings`
- **方法**: GET
- **描述**: 获取所有团队的变更跟踪数据
- **参数**: 
  - `page`: 页码（可选）
  - `size`: 每页大小（可选）
  - `sort`: 排序字段（可选）
- **返回**: 变更记录列表

#### 3.2 删除变更记录
- **URL**: `/api/change-trackings/{id}`
- **方法**: DELETE
- **描述**: 删除指定的变更记录
- **返回**: 无

### 4. 测试进度接口

#### 4.1 获取测试进度
- **URL**: `/api/testing-progress`
- **方法**: GET
- **描述**: 获取所有团队的测试进度数据
- **参数**: 
  - `page`: 页码（可选）
  - `size`: 每页大小（可选）
  - `sort`: 排序字段（可选）
- **返回**: 测试进度列表

#### 4.2 更新测试进度
- **URL**: `/api/testing-progress/{id}`
- **方法**: PUT
- **描述**: 更新指定的测试进度数据
- **请求体**: TestingProgress 对象
- **返回**: 更新后的测试进度

### 5. Bug 跟踪接口

#### 5.1 获取 Bug 进度
- **URL**: `/api/bug-progress`
- **方法**: GET
- **描述**: 获取所有团队的 Bug 处理进度数据
- **参数**: 
  - `page`: 页码（可选）
  - `size`: 每页大小（可选）
  - `sort`: 排序字段（可选）
- **返回**: Bug 进度列表

#### 5.2 更新 Bug 进度
- **URL**: `/api/bug-progress/{id}`
- **方法**: PUT
- **描述**: 更新指定的 Bug 处理进度数据
- **请求体**: BugProgress 对象
- **返回**: 更新后的 Bug 进度

## 数据模型

### SprintPlanning

```json
{
  "id": "long",
  "programName": "string",
  "teamName": "string",
  "plannedCount": "integer",
  "completedCount": "integer",
  "storypointPlanned": "decimal",
  "storypointCompleted": "decimal",
  "testPoints": "decimal",
  "userStoryPoints": "decimal",
  "userStoryRatio": "decimal",
  "enablerPoints": "decimal",
  "enablerRatio": "decimal",
  "storyThroughput": "decimal",
  "cvValue": "decimal",
  "storyGranularity": "decimal",
  "date": "date"
}
```

### IterationCompletion

```json
{
  "id": "long",
  "teamName": "string",
  "plannedProgress": "decimal",
  "actualProgress": "decimal",
  "date": "date"
}
```

### ChangeTracking

```json
{
  "id": "long",
  "teamName": "string",
  "changeTasks": "integer",
  "changePoints": "decimal",
  "date": "date"
}
```

### TestingProgress

```json
{
  "id": "long",
  "teamName": "string",
  "totalTestCases": "integer",
  "completedTestCases": "integer",
  "date": "date"
}
```

### BugProgress

```json
{
  "id": "long",
  "teamName": "string",
  "preFixed": "integer",
  "prePending": "integer",
  "uatFixed": "integer",
  "uatPending": "integer",
  "date": "date"
}
```

## 错误码说明

| 错误码 | 描述 | 解决方案 |
|--------|------|----------|
| 400 | 请求参数错误 | 检查请求参数是否符合要求 |
| 401 | 未授权 | 检查认证信息是否正确 |
| 403 | 禁止访问 | 检查是否有相应的访问权限 |
| 404 | 资源不存在 | 检查请求的资源是否存在 |
| 500 | 服务器内部错误 | 联系系统管理员 |

## 注意事项

1. 所有请求都需要包含认证信息
2. 日期格式统一使用 ISO 8601 标准：YYYY-MM-DD
3. 分页参数 page 从 0 开始计数
4. 所有金额/比率类型使用 decimal 类型，保留 2 位小数
5. 请求体使用 JSON 格式

## 最佳实践

1. 使用分页查询避免数据量过大
2. 合理使用排序参数优化数据展示
3. 正确处理错误响应
4. 在生产环境中使用 HTTPS
5. 实现请求重试机制

## 更新日志

### v1.0.0 (2024-03-20)
- 初始版本发布
- 实现基础的 CRUD 操作
- 添加分页和排序功能
- 实现基本的数据验证 