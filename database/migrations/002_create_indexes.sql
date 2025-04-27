-- 创建索引以优化查询性能
CREATE INDEX IF NOT EXISTS idx_sprint_planning_team_date ON sprint_planning(team_name, data_date);
CREATE INDEX IF NOT EXISTS idx_iteration_completion_team_date ON iteration_completion(team_name, data_date);
CREATE INDEX IF NOT EXISTS idx_bug_team_date ON bug(team_name, data_date);
CREATE INDEX IF NOT EXISTS idx_change_team_date ON change(team_name, data_date);
CREATE INDEX IF NOT EXISTS idx_testing_team_date ON testing(team_name, data_date);

-- 创建复合索引以支持更复杂的查询
CREATE INDEX IF NOT EXISTS idx_sprint_planning_program_date ON sprint_planning(program_name, data_date);
CREATE INDEX IF NOT EXISTS idx_iteration_completion_type_date ON iteration_completion(issue_type, data_date); 