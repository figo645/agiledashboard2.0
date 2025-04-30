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
    program_name VARCHAR(100) NOT NULL,
    team_name VARCHAR(100) NOT NULL,
    planned_count INTEGER NOT NULL,
    completed_count INTEGER NOT NULL,
    storypoint_planned INTEGER NOT NULL,
    storypoint_completed INTEGER NOT NULL,
    test_points INTEGER NOT NULL,
    user_story_points INTEGER NOT NULL,
    user_story_ratio DECIMAL(5,2) NOT NULL,
    enabler_points INTEGER NOT NULL,
    enabler_ratio DECIMAL(5,2) NOT NULL,
    story_throughput DECIMAL(10,2) NOT NULL,
    cv_value DECIMAL(10,2) NOT NULL,
    story_granularity DECIMAL(10,2) NOT NULL,
    date DATE NOT NULL
);

-- 2. Iteration Completion 表
CREATE TABLE iteration_completion (
    id SERIAL PRIMARY KEY,
    team_name VARCHAR(100) NOT NULL,
    planned_progress DECIMAL(5,2) NOT NULL,
    actual_progress DECIMAL(5,2) NOT NULL,
    date DATE NOT NULL
);

-- 3. Bug Progress 表
CREATE TABLE bug_progress (
    id SERIAL PRIMARY KEY,
    team_name VARCHAR(100) NOT NULL,
    pre_fixed INTEGER NOT NULL,
    pre_pending INTEGER NOT NULL,
    uat_fixed INTEGER NOT NULL,
    uat_pending INTEGER NOT NULL,
    date DATE NOT NULL
);

-- 4. Change Tracking 表
CREATE TABLE change_tracking (
    id SERIAL PRIMARY KEY,
    team_name VARCHAR(100) NOT NULL,
    change_tasks INTEGER NOT NULL,
    change_points INTEGER NOT NULL,
    date DATE NOT NULL
);

-- 5. Testing Progress 表
CREATE TABLE testing_progress (
    id SERIAL PRIMARY KEY,
    team_name VARCHAR(100) NOT NULL,
    total_test_cases INTEGER NOT NULL,
    completed_test_cases INTEGER NOT NULL,
    date DATE NOT NULL
);

-- 添加非空约束
ALTER TABLE sprint_planning 
    ALTER COLUMN program_name SET NOT NULL,
    ALTER COLUMN team_name SET NOT NULL,
    ALTER COLUMN planned_count SET NOT NULL,
    ALTER COLUMN completed_count SET NOT NULL,
    ALTER COLUMN storypoint_planned SET NOT NULL,
    ALTER COLUMN storypoint_completed SET NOT NULL,
    ALTER COLUMN test_points SET NOT NULL,
    ALTER COLUMN user_story_points SET NOT NULL,
    ALTER COLUMN user_story_ratio SET NOT NULL,
    ALTER COLUMN enabler_points SET NOT NULL,
    ALTER COLUMN enabler_ratio SET NOT NULL,
    ALTER COLUMN story_throughput SET NOT NULL,
    ALTER COLUMN cv_value SET NOT NULL,
    ALTER COLUMN story_granularity SET NOT NULL,
    ALTER COLUMN date SET NOT NULL;

ALTER TABLE iteration_completion 
    ALTER COLUMN team_name SET NOT NULL,
    ALTER COLUMN planned_progress SET NOT NULL,
    ALTER COLUMN actual_progress SET NOT NULL,
    ALTER COLUMN date SET NOT NULL;

ALTER TABLE change_tracking 
    ALTER COLUMN team_name SET NOT NULL,
    ALTER COLUMN change_tasks SET NOT NULL,
    ALTER COLUMN change_points SET NOT NULL,
    ALTER COLUMN date SET NOT NULL;

ALTER TABLE testing_progress 
    ALTER COLUMN team_name SET NOT NULL,
    ALTER COLUMN total_test_cases SET NOT NULL,
    ALTER COLUMN completed_test_cases SET NOT NULL,
    ALTER COLUMN date SET NOT NULL;

ALTER TABLE bug_progress 
    ALTER COLUMN team_name SET NOT NULL,
    ALTER COLUMN pre_fixed SET NOT NULL,
    ALTER COLUMN pre_pending SET NOT NULL,
    ALTER COLUMN uat_fixed SET NOT NULL,
    ALTER COLUMN uat_pending SET NOT NULL,
    ALTER COLUMN date SET NOT NULL;

-- 创建索引
CREATE INDEX idx_sprint_planning_date ON sprint_planning(date);
CREATE INDEX idx_iteration_completion_date ON iteration_completion(date);
CREATE INDEX idx_change_tracking_date ON change_tracking(date);
CREATE INDEX idx_testing_progress_date ON testing_progress(date);
CREATE INDEX idx_bug_progress_date ON bug_progress(date);

-- 创建视图
CREATE VIEW sprint_metrics AS
SELECT 
    sp.date,
    sp.team_name,
    sp.program_name,
    sp.planned_count,
    sp.completed_count,
    sp.storypoint_planned,
    sp.storypoint_completed,
    sp.test_points,
    sp.user_story_points,
    sp.user_story_ratio,
    sp.enabler_points,
    sp.enabler_ratio,
    sp.story_throughput,
    sp.cv_value,
    sp.story_granularity,
    ic.planned_progress,
    ic.actual_progress,
    ct.change_tasks,
    ct.change_points,
    tp.total_test_cases,
    tp.completed_test_cases,
    bp.pre_fixed,
    bp.pre_pending,
    bp.uat_fixed,
    bp.uat_pending
FROM 
    sprint_planning sp
    LEFT JOIN iteration_completion ic ON sp.team_name = ic.team_name AND sp.date = ic.date
    LEFT JOIN change_tracking ct ON sp.team_name = ct.team_name AND sp.date = ct.date
    LEFT JOIN testing_progress tp ON sp.team_name = tp.team_name AND sp.date = tp.date
    LEFT JOIN bug_progress bp ON sp.team_name = bp.team_name AND sp.date = bp.date; 