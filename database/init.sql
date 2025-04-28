-- 创建数据库
CREATE DATABASE sprint_dashboard;

-- 连接到新创建的数据库
\c sprint_dashboard;

-- 设置搜索路径
SET search_path TO public;

-- 创建扩展（如果需要）
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- 1. Sprint Planning 表
CREATE TABLE sprint_planning (
    id SERIAL PRIMARY KEY,
    program_name VARCHAR(255),
    team_name VARCHAR(255),
    planned_progress DECIMAL(10,2),
    actual_progress DECIMAL(10,2),
    storypoint_planned DECIMAL(10,2),
    storypoint_completed DECIMAL(10,2),
    test_points DECIMAL(10,2),
    user_story_points DECIMAL(10,2),
    user_story_ratio DECIMAL(10,2),
    enabler_points DECIMAL(10,2),
    enabler_ratio DECIMAL(10,2),
    story_throughput DECIMAL(10,2),
    cv_value DECIMAL(10,2),
    story_granularity DECIMAL(10,2),
    data_date DATE,
    data_month VARCHAR(7),
    data_quarter VARCHAR(7)
);

-- 2. Iteration Completion 表
CREATE TABLE iteration_completion (
    id SERIAL PRIMARY KEY,
    program_name VARCHAR(255),
    team_name VARCHAR(255),
    planned_progress DECIMAL(10,2),
    actual_progress DECIMAL(10,2),
    storypoint_planned DECIMAL(10,2),
    storypoint_completed DECIMAL(10,2),
    data_date DATE,
    data_month VARCHAR(7),
    data_quarter VARCHAR(7)
);

-- 3. Bug Progress 表
CREATE TABLE bug_progress (
    id SERIAL PRIMARY KEY,
    program_name VARCHAR(255),
    team_name VARCHAR(255),
    total_bugs INTEGER,
    pre_fixed INTEGER,
    uat_fixed INTEGER,
    pre_pending INTEGER,
    uat_pending INTEGER,
    pre_fixed_ratio DECIMAL(10,2),
    uat_fixed_ratio DECIMAL(10,2),
    data_date DATE,
    data_month VARCHAR(7),
    data_quarter VARCHAR(7)
);

-- 4. Change Tracking 表
CREATE TABLE change_tracking (
    id SERIAL PRIMARY KEY,
    team_name VARCHAR(255),
    change_tasks INTEGER,
    change_points INTEGER,
    data_date DATE,
    data_month VARCHAR(7),
    data_quarter VARCHAR(7)
);

-- 5. Testing Progress 表
CREATE TABLE testing_progress (
    id SERIAL PRIMARY KEY,
    team_name VARCHAR(255),
    total_test_cases INTEGER,
    completed_test_cases INTEGER,
    failed_test_cases INTEGER,
    blocked_test_cases INTEGER,
    data_date DATE,
    data_month VARCHAR(7),
    data_quarter VARCHAR(7)
); 