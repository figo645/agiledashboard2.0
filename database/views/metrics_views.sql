-- 创建日视图
CREATE OR REPLACE VIEW daily_metrics AS
SELECT 
    team_name,
    data_date,
    SUM(planned_count) as total_planned,
    SUM(completed_count) as total_completed,
    SUM(storypoint_planned) as total_storypoints_planned,
    SUM(storypoint_completed) as total_storypoints_completed
FROM sprint_planning
GROUP BY team_name, data_date;

-- 创建周视图
CREATE OR REPLACE VIEW weekly_metrics AS
SELECT 
    team_name,
    DATE_TRUNC('week', data_date) as week_start,
    SUM(planned_count) as total_planned,
    SUM(completed_count) as total_completed,
    SUM(storypoint_planned) as total_storypoints_planned,
    SUM(storypoint_completed) as total_storypoints_completed
FROM sprint_planning
GROUP BY team_name, DATE_TRUNC('week', data_date);

-- 创建双周视图
CREATE OR REPLACE VIEW biweekly_metrics AS
SELECT 
    team_name,
    DATE_TRUNC('week', data_date) as biweek_start,
    SUM(planned_count) as total_planned,
    SUM(completed_count) as total_completed,
    SUM(storypoint_planned) as total_storypoints_planned,
    SUM(storypoint_completed) as total_storypoints_completed
FROM sprint_planning
GROUP BY team_name, DATE_TRUNC('week', data_date);

-- 创建月视图
CREATE OR REPLACE VIEW monthly_metrics AS
SELECT 
    team_name,
    DATE_TRUNC('month', data_date) as month_start,
    SUM(planned_count) as total_planned,
    SUM(completed_count) as total_completed,
    SUM(storypoint_planned) as total_storypoints_planned,
    SUM(storypoint_completed) as total_storypoints_completed
FROM sprint_planning
GROUP BY team_name, DATE_TRUNC('month', data_date); 