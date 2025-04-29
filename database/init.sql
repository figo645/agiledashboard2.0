-- 创建数据库
CREATE DATABASE sprint_dashboard;

-- 连接到新创建的数据库
\c sprint_dashboard;

-- 设置搜索路径
SET search_path TO public;

-- 创建扩展（如果需要）
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- 清理现有表（如果存在）
DROP TABLE IF EXISTS testing_progress;
DROP TABLE IF EXISTS change_tracking;
DROP TABLE IF EXISTS bug_progress;
DROP TABLE IF EXISTS iteration_completion;
DROP TABLE IF EXISTS sprint_planning;

-- 1. Sprint Planning 表
CREATE TABLE sprint_planning (
    id SERIAL PRIMARY KEY,
    program_name VARCHAR(255) NOT NULL,
    team_name VARCHAR(255) NOT NULL,
    planned_count INTEGER NOT NULL,
    completed_count INTEGER NOT NULL,
    storypoint_planned DECIMAL(10,2) NOT NULL,
    storypoint_completed DECIMAL(10,2) NOT NULL,
    test_points DECIMAL(10,2) NOT NULL,
    user_story_points DECIMAL(10,2) NOT NULL,
    user_story_ratio DECIMAL(10,2) NOT NULL,
    enabler_points DECIMAL(10,2) NOT NULL,
    enabler_ratio DECIMAL(10,2) NOT NULL,
    story_throughput DECIMAL(10,2) NOT NULL,
    cv_value DECIMAL(10,2) NOT NULL,
    story_granularity DECIMAL(10,2) NOT NULL,
    data_date DATE NOT NULL,
    data_month VARCHAR(7) NOT NULL,
    data_quarter VARCHAR(7) NOT NULL
);

-- 2. Iteration Completion 表
CREATE TABLE iteration_completion (
    id SERIAL PRIMARY KEY,
    program_name VARCHAR(255) NOT NULL,
    team_name VARCHAR(255) NOT NULL,
    planned_progress DECIMAL(10,2) NOT NULL,
    actual_progress DECIMAL(10,2) NOT NULL,
    storypoint_planned DECIMAL(10,2) NOT NULL,
    storypoint_completed DECIMAL(10,2) NOT NULL,
    data_date DATE NOT NULL,
    data_month VARCHAR(7) NOT NULL,
    data_quarter VARCHAR(7) NOT NULL
);

-- 3. Bug Progress 表
CREATE TABLE bug_progress (
    id SERIAL PRIMARY KEY,
    program_name VARCHAR(255) NOT NULL,
    team_name VARCHAR(255) NOT NULL,
    total_bugs INTEGER NOT NULL,
    pre_fixed INTEGER NOT NULL,
    uat_fixed INTEGER NOT NULL,
    pre_pending INTEGER NOT NULL,
    uat_pending INTEGER NOT NULL,
    pre_fixed_ratio DECIMAL(10,2) NOT NULL,
    uat_fixed_ratio DECIMAL(10,2) NOT NULL,
    data_date DATE NOT NULL,
    data_month VARCHAR(7) NOT NULL,
    data_quarter VARCHAR(7) NOT NULL
);

-- 4. Change Tracking 表
CREATE TABLE change_tracking (
    id SERIAL PRIMARY KEY,
    team_name VARCHAR(255) NOT NULL,
    change_tasks INTEGER NOT NULL,
    change_points INTEGER NOT NULL,
    data_date DATE NOT NULL,
    data_month VARCHAR(7) NOT NULL,
    data_quarter VARCHAR(7) NOT NULL
);

-- 5. Testing Progress 表
CREATE TABLE testing_progress (
    id SERIAL PRIMARY KEY,
    team_name VARCHAR(255) NOT NULL,
    total_test_cases INTEGER NOT NULL,
    completed_test_cases INTEGER NOT NULL,
    failed_test_cases INTEGER NOT NULL,
    blocked_test_cases INTEGER NOT NULL,
    data_date DATE NOT NULL,
    data_month VARCHAR(7) NOT NULL,
    data_quarter VARCHAR(7) NOT NULL
); 