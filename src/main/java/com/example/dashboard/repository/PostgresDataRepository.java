package com.example.dashboard.repository;

import com.example.dashboard.entity.TeamData;
import com.example.dashboard.entity.IterationCompletion;
import com.example.dashboard.entity.Bug;
import com.example.dashboard.entity.Change;
import com.example.dashboard.entity.Testing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@Qualifier("postgresDataRepository")
public class PostgresDataRepository implements DataRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<TeamData> getSprintPlanningData() {
        String sql = "SELECT * FROM sprint_planning";
        return jdbcTemplate.query(sql, new TeamDataRowMapper());
    }

    @Override
    public List<IterationCompletion> getIterationCompletionData() {
        String sql = "SELECT * FROM iteration_completion";
        return jdbcTemplate.query(sql, new IterationCompletionRowMapper());
    }

    @Override
    public List<Bug> getBugData() {
        String sql = "SELECT * FROM bug";
        return jdbcTemplate.query(sql, new BugRowMapper());
    }

    @Override
    public List<Change> getChangeData() {
        String sql = "SELECT * FROM change";
        return jdbcTemplate.query(sql, new ChangeRowMapper());
    }

    @Override
    public List<Testing> getTestingData() {
        String sql = "SELECT * FROM testing";
        return jdbcTemplate.query(sql, new TestingRowMapper());
    }

    private static class TeamDataRowMapper implements RowMapper<TeamData> {
        @Override
        public TeamData mapRow(ResultSet rs, int rowNum) throws SQLException {
            TeamData team = new TeamData();
            team.setId(rs.getString("id"));
            team.setProgramName(rs.getString("program_name"));
            team.setTeamName(rs.getString("team_name"));
            team.setPlannedCount(rs.getDouble("planned_count"));
            team.setCompletedCount(rs.getDouble("completed_count"));
            team.setStorypointPlanned(rs.getDouble("storypoint_planned"));
            team.setStorypointCompleted(rs.getDouble("storypoint_completed"));
            team.setTestPoints(rs.getDouble("test_points"));
            team.setUserStoryPoints(rs.getDouble("user_story_points"));
            team.setUserStoryRatio(rs.getDouble("user_story_ratio"));
            team.setEnablerPoints(rs.getDouble("enabler_points"));
            team.setEnablerRatio(rs.getDouble("enabler_ratio"));
            team.setStoryThroughput(rs.getDouble("story_throughput"));
            team.setCvValue(rs.getDouble("cv_value"));
            team.setStoryGranularity(rs.getDouble("story_granularity"));
            return team;
        }
    }

    private static class IterationCompletionRowMapper implements RowMapper<IterationCompletion> {
        @Override
        public IterationCompletion mapRow(ResultSet rs, int rowNum) throws SQLException {
            IterationCompletion completion = new IterationCompletion();
            completion.setId(rs.getString("id"));
            completion.setProgramName(rs.getString("program_name"));
            completion.setTeamName(rs.getString("team_name"));
            completion.setPlannedProgress(rs.getDouble("planned_progress"));
            completion.setActualProgress(rs.getDouble("actual_progress"));
            completion.setStorypointPlanned(rs.getDouble("storypoint_planned"));
            completion.setStorypointCompleted(rs.getDouble("storypoint_completed"));
            return completion;
        }
    }

    private static class BugRowMapper implements RowMapper<Bug> {
        @Override
        public Bug mapRow(ResultSet rs, int rowNum) throws SQLException {
            Bug bug = new Bug();
            bug.setId(rs.getString("id"));
            bug.setProgramName(rs.getString("program_name"));
            bug.setTeamName(rs.getString("team_name"));
            bug.setTotalBugs(rs.getInt("total_bugs"));
            bug.setPreFixed(rs.getInt("pre_fixed"));
            bug.setUatFixed(rs.getInt("uat_fixed"));
            bug.setPrePending(rs.getInt("pre_pending"));
            bug.setUatPending(rs.getInt("uat_pending"));
            bug.setPreFixedRatio(rs.getDouble("pre_fixed_ratio"));
            bug.setUatFixedRatio(rs.getDouble("uat_fixed_ratio"));
            return bug;
        }
    }

    private static class ChangeRowMapper implements RowMapper<Change> {
        @Override
        public Change mapRow(ResultSet rs, int rowNum) throws SQLException {
            Change change = new Change();
            change.setId(rs.getString("id"));
            change.setTeamName(rs.getString("team_name"));
            change.setIssueKey(rs.getString("issue_key"));
            change.setSummary(rs.getString("summary"));
            change.setStatus(rs.getString("status"));
            change.setChangeType(rs.getString("change_type"));
            change.setAssignee(rs.getString("assignee"));
            change.setCreatedDate(rs.getString("created_date"));
            change.setResolvedDate(rs.getString("resolved_date"));
            change.setStoryPoints(rs.getDouble("story_points"));
            change.setChangeTasks(rs.getInt("change_tasks"));
            change.setChangePoints(rs.getInt("change_points"));
            return change;
        }
    }

    private static class TestingRowMapper implements RowMapper<Testing> {
        @Override
        public Testing mapRow(ResultSet rs, int rowNum) throws SQLException {
            Testing testing = new Testing();
            testing.setId(rs.getString("id"));
            testing.setTeamName(rs.getString("team_name"));
            testing.setTotalTestCases(rs.getInt("total_test_cases"));
            testing.setCompletedTestCases(rs.getInt("completed_test_cases"));
            testing.setFailedTestCases(rs.getInt("failed_test_cases"));
            testing.setBlockedTestCases(rs.getInt("blocked_test_cases"));
            return testing;
        }
    }
} 