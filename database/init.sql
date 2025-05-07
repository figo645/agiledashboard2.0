-- 创建数据库
CREATE DATABASE sprint_dashboard;

-- 连接到新创建的数据库
\c sprint_dashboard;

-- 设置搜索路径
SET search_path TO public;

-- 创建扩展（如果需要）
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- 清理现有表和视图（如果存在）
DROP VIEW IF EXISTS sprint_metrics;
DROP TABLE IF EXISTS testing_progress;
DROP TABLE IF EXISTS change_tracking;
DROP TABLE IF EXISTS bug_progress;
DROP TABLE IF EXISTS iteration_completion;
DROP TABLE IF EXISTS sprint_planning;

-- 创建表
CREATE TABLE sprint_planning (
    id VARCHAR(36) PRIMARY KEY DEFAULT uuid_generate_v4()::text,
    program_name VARCHAR(100) NOT NULL,
    team_name VARCHAR(100) NOT NULL,
    planned_count DECIMAL(10,2) NOT NULL,
    completed_count DECIMAL(10,2) NOT NULL,
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

CREATE TABLE iteration_completion (
    id VARCHAR(36) PRIMARY KEY DEFAULT uuid_generate_v4()::text,
    program_name VARCHAR(100) NOT NULL,
    team_name VARCHAR(100) NOT NULL,
    planned_progress DECIMAL(10,2) NOT NULL,
    actual_progress DECIMAL(10,2) NOT NULL,
    storypoint_planned DECIMAL(10,2) NOT NULL,
    storypoint_completed DECIMAL(10,2) NOT NULL,
    data_date DATE NOT NULL,
    data_month VARCHAR(7) NOT NULL,
    data_quarter VARCHAR(7) NOT NULL
);

CREATE TABLE bug_progress (
    id VARCHAR(36) PRIMARY KEY DEFAULT uuid_generate_v4()::text,
    program_name VARCHAR(100) NOT NULL,
    team_name VARCHAR(100) NOT NULL,
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

CREATE TABLE change_tracking (
    id VARCHAR(36) PRIMARY KEY DEFAULT uuid_generate_v4()::text,
    team_name VARCHAR(100) NOT NULL,
    change_tasks INTEGER NOT NULL,
    change_points INTEGER NOT NULL,
    data_date DATE NOT NULL,
    data_month VARCHAR(7) NOT NULL,
    data_quarter VARCHAR(7) NOT NULL
);

CREATE TABLE testing_progress (
    id VARCHAR(36) PRIMARY KEY DEFAULT uuid_generate_v4()::text,
    team_name VARCHAR(100) NOT NULL,
    total_test_cases INTEGER NOT NULL,
    completed_test_cases INTEGER NOT NULL,
    failed_test_cases INTEGER NOT NULL,
    blocked_test_cases INTEGER NOT NULL,
    data_date DATE NOT NULL,
    data_month VARCHAR(7) NOT NULL,
    data_quarter VARCHAR(7) NOT NULL
);

-- 创建索引
CREATE INDEX idx_sprint_planning_date ON sprint_planning(data_date);
CREATE INDEX idx_sprint_planning_month ON sprint_planning(data_month);
CREATE INDEX idx_sprint_planning_quarter ON sprint_planning(data_quarter);

CREATE INDEX idx_iteration_completion_date ON iteration_completion(data_date);
CREATE INDEX idx_iteration_completion_month ON iteration_completion(data_month);
CREATE INDEX idx_iteration_completion_quarter ON iteration_completion(data_quarter);

CREATE INDEX idx_bug_progress_date ON bug_progress(data_date);
CREATE INDEX idx_bug_progress_month ON bug_progress(data_month);
CREATE INDEX idx_bug_progress_quarter ON bug_progress(data_quarter);

CREATE INDEX idx_change_tracking_date ON change_tracking(data_date);
CREATE INDEX idx_change_tracking_month ON change_tracking(data_month);
CREATE INDEX idx_change_tracking_quarter ON change_tracking(data_quarter);

CREATE INDEX idx_testing_progress_date ON testing_progress(data_date);
CREATE INDEX idx_testing_progress_month ON testing_progress(data_month);
CREATE INDEX idx_testing_progress_quarter ON testing_progress(data_quarter);

-- 创建视图
CREATE OR REPLACE VIEW sprint_metrics AS
SELECT 
    sp.data_date,
    sp.data_month,
    sp.data_quarter,
    sp.program_name,
    sp.team_name,
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
    ic.storypoint_planned as iteration_storypoint_planned,
    ic.storypoint_completed as iteration_storypoint_completed,
    bp.total_bugs,
    bp.pre_fixed,
    bp.uat_fixed,
    bp.pre_pending,
    bp.uat_pending,
    bp.pre_fixed_ratio,
    bp.uat_fixed_ratio,
    ct.change_tasks,
    ct.change_points,
    tp.total_test_cases,
    tp.completed_test_cases,
    tp.failed_test_cases,
    tp.blocked_test_cases
FROM sprint_planning sp
LEFT JOIN iteration_completion ic ON sp.team_name = ic.team_name AND sp.data_date = ic.data_date
LEFT JOIN bug_progress bp ON sp.team_name = bp.team_name AND sp.data_date = bp.data_date
LEFT JOIN change_tracking ct ON sp.team_name = ct.team_name AND sp.data_date = ct.data_date
LEFT JOIN testing_progress tp ON sp.team_name = tp.team_name AND sp.data_date = tp.data_date; 