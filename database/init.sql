-- 创建数据库
CREATE DATABASE sprint_dashboard;

-- 连接到新创建的数据库
\c sprint_dashboard;

-- 设置搜索路径
SET search_path TO public;

-- 创建扩展（如果需要）
CREATE EXTENSION IF NOT EXISTS "uuid-ossp"; 