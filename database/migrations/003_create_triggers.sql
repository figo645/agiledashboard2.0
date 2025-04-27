-- 为每个表创建触发器
CREATE TRIGGER update_sprint_planning_updated_at
    BEFORE UPDATE ON sprint_planning
    FOR EACH ROW
    EXECUTE FUNCTION update_updated_at_column();

CREATE TRIGGER update_iteration_completion_updated_at
    BEFORE UPDATE ON iteration_completion
    FOR EACH ROW
    EXECUTE FUNCTION update_updated_at_column();

CREATE TRIGGER update_bug_updated_at
    BEFORE UPDATE ON bug
    FOR EACH ROW
    EXECUTE FUNCTION update_updated_at_column();

CREATE TRIGGER update_change_updated_at
    BEFORE UPDATE ON change
    FOR EACH ROW
    EXECUTE FUNCTION update_updated_at_column();

CREATE TRIGGER update_testing_updated_at
    BEFORE UPDATE ON testing
    FOR EACH ROW
    EXECUTE FUNCTION update_updated_at_column(); 