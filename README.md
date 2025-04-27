# 我的敏捷迭代看板系统

## 1. 我的设计理念

本项目是一个敏捷迭代看板系统，旨在为团队提供直观、实时的项目进度可视化工具。系统设计遵循以下核心理念：

- **实时性**：通过自动数据同步，确保看板数据始终反映最新状态
- **可视化**：采用图表和表格等多种形式展示数据，便于快速理解项目状态
- **灵活性**：支持自定义布局和拖拽调整，适应不同团队的需求
- **易用性**：简洁直观的界面设计，降低使用门槛
- **可扩展性**：模块化设计，便于后续功能扩展

## 2. 程序设计

### 2.1 技术栈

- **前端**：
  - HTML5 + CSS3
  - JavaScript (原生)
  - Chart.js (数据可视化)
  - HTML5 Drag and Drop API (拖拽功能)

- **后端**：
  - Spring Boot
  - Spring Data JPA
  - RESTful API

### 2.2 系统架构

系统采用前后端分离架构：

```
├── 前端 (Frontend)
│   ├── 静态资源 (HTML/CSS/JS)
│   ├── 数据可视化组件
│   └── 交互控制逻辑
│
└── 后端 (Backend)
    ├── 控制器层 (Controller)
    ├── 服务层 (Service)
    ├── 数据访问层 (Repository)
    └── 实体层 (Entity)
```

### 2.3 核心功能模块

1. **Sprint计划分析**
   - 计划需求数与实际完成数对比
   - 故事点完成情况统计
   - 用户故事与技术需求占比分析

2. **迭代完成进度**
   - 可视化展示各团队迭代完成情况
   - 支持数据缩放和筛选

3. **变更情况追踪**
   - 变更任务数和变更点数统计
   - 团队间变更情况对比

4. **测试进度监控**
   - 测试用例完成情况
   - 测试覆盖率分析

5. **Bug处理进度**
   - Pre环境和UAT环境Bug状态
   - Bug修复进度追踪

## 3. 核心流程

### 3.1 数据同步流程

1. 系统启动时加载初始数据
2. 定时从数据源同步最新数据
3. 数据更新后自动刷新看板显示

### 3.2 用户交互流程

1. 页面加载
   - 初始化看板布局
   - 加载本地存储的面板顺序
   - 获取最新数据并渲染

2. 数据展示
   - 表格形式展示详细数据
   - 图表形式展示趋势和对比
   - 支持数据筛选和排序

3. 布局调整
   - 拖拽面板调整位置
   - 自动调整面板宽度
   - 保存布局配置

4. 数据查看
   - 支持图表最大化查看
   - 表格数据分页显示
   - 数据导出功能

## 4. 数据表设计

### 4.1 TeamData（团队数据）

```java
@Entity
public class TeamData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String programName;        // 项目组名称
    private String teamName;           // 团队名称
    private double plannedCount;       // 计划需求数
    private double completedCount;     // 实际完成数
    private double storypointPlanned;  // 计划故事点
    private double storypointCompleted;// 完成故事点
    private double testPoints;         // 测试故事点
    private double userStoryPoints;    // 用户故事点
    private double userStoryRatio;     // 用户故事占比
    private double enablerPoints;      // 技术需求数
    private double enablerRatio;       // 技术需求占比
    private double storyThroughput;    // 百人天故事吞吐量
}
```

### 4.2 IterationCompletion（迭代完成情况）

```java
@Entity
public class IterationCompletion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String teamName;           // 团队名称
    private String issueType;          // 问题类型
    private String issueKey;           // 问题编号
    private String summary;            // 问题摘要
    private String status;             // 状态
    private double points;             // 点数
}
```

## 5. 安全设计

### 5.1 数据安全

- 数据加密存储
- 敏感信息脱敏处理
- 定期数据备份
- 数据访问权限控制

### 5.2 接口安全

- RESTful API 认证
- 请求参数验证
- 防SQL注入
- 防XSS攻击

### 5.3 前端安全

- 输入数据验证
- XSS防护
- CSRF防护
- 敏感操作确认

### 5.4 部署安全

- HTTPS加密传输
- 防火墙配置
- 定期安全扫描
- 漏洞及时修复

## 使用说明

1. 克隆项目到本地
2. 配置数据库连接
3. 启动Spring Boot应用
4. 访问 `http://localhost:8080` 查看看板

## 开发环境要求

- JDK 1.8+
- Maven 3.6+
- MySQL 5.7+
- 现代浏览器（Chrome、Firefox、Safari等）

## 贡献指南

1. Fork 项目
2. 创建特性分支
3. 提交更改
4. 推送到分支
5. 创建 Pull Request

## 许可证

MIT License 