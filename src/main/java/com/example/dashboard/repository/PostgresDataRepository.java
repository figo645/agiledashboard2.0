package com.example.dashboard.repository;

import com.example.dashboard.entity.TeamData;
import com.example.dashboard.entity.IterationCompletion;
import com.example.dashboard.entity.BugProgress;
import com.example.dashboard.entity.ChangeTracking;
import com.example.dashboard.entity.TestingProgress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 * PostgreSQL 数据仓库实现类。
 * 从 PostgreSQL 数据库读取数据的实现。
 */
@Repository
@Qualifier("postgresDataRepository")
public class PostgresDataRepository implements DataRepository {
    private final JdbcTemplate jdbcTemplate;

    /**
     * 构造函数，注入 JdbcTemplate 依赖。
     *
     * @param jdbcTemplate JdbcTemplate 实例
     */
    @Autowired
    public PostgresDataRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 获取指定日期的冲刺计划数据。
     *
     * @param date 查询日期
     * @return 团队数据列表
     */
    @Override
    public List<TeamData> getSprintPlanningData(LocalDate date) {
        String sql = date != null 
            ? "SELECT * FROM sprint_planning WHERE data_date = ? ORDER BY data_date DESC"
            : "SELECT * FROM sprint_planning ORDER BY data_date DESC";
        return date != null
            ? jdbcTemplate.query(sql, new TeamDataRowMapper(), date)
            : jdbcTemplate.query(sql, new TeamDataRowMapper());
    }

    /**
     * 获取指定日期的迭代完成数据。
     *
     * @param date 查询日期
     * @return 迭代完成数据列表
     */
    @Override
    public List<IterationCompletion> getIterationCompletionData(LocalDate date) {
        String sql = date != null 
            ? "SELECT * FROM iteration_completion WHERE data_date = ? ORDER BY data_date DESC"
            : "SELECT * FROM iteration_completion ORDER BY data_date DESC";
        return date != null
            ? jdbcTemplate.query(sql, new IterationCompletionRowMapper(), date)
            : jdbcTemplate.query(sql, new IterationCompletionRowMapper());
    }

    /**
     * 获取指定日期的缺陷进度数据。
     *
     * @param date 查询日期
     * @return 缺陷进度数据列表
     */
    @Override
    public List<BugProgress> getBugProgressData(LocalDate date) {
        String sql = date != null 
            ? "SELECT * FROM bug_progress WHERE data_date = ? ORDER BY data_date DESC"
            : "SELECT * FROM bug_progress ORDER BY data_date DESC";
        return date != null
            ? jdbcTemplate.query(sql, new BugProgressRowMapper(), date)
            : jdbcTemplate.query(sql, new BugProgressRowMapper());
    }

    /**
     * 获取指定日期的变更跟踪数据。
     *
     * @param date 查询日期
     * @return 变更跟踪数据列表
     */
    @Override
    public List<ChangeTracking> getChangeTrackingData(LocalDate date) {
        String sql = date != null 
            ? "SELECT * FROM change_tracking WHERE data_date = ? ORDER BY data_date DESC"
            : "SELECT * FROM change_tracking ORDER BY data_date DESC";
        return date != null
            ? jdbcTemplate.query(sql, new ChangeTrackingRowMapper(), date)
            : jdbcTemplate.query(sql, new ChangeTrackingRowMapper());
    }

    /**
     * 获取指定日期的测试进度数据。
     *
     * @param date 查询日期
     * @return 测试进度数据列表
     */
    @Override
    public List<TestingProgress> getTestingProgressData(LocalDate date) {
        String sql = date != null 
            ? "SELECT * FROM testing_progress WHERE data_date = ? ORDER BY data_date DESC"
            : "SELECT * FROM testing_progress ORDER BY data_date DESC";
        return date != null
            ? jdbcTemplate.query(sql, new TestingProgressRowMapper(), date)
            : jdbcTemplate.query(sql, new TestingProgressRowMapper());
    }

    /**
     * TeamData 行映射器。
     */
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
            team.setDataDate(rs.getDate("data_date").toLocalDate());
            team.setDataMonth(rs.getString("data_month"));
            team.setDataQuarter(rs.getString("data_quarter"));
            return team;
        }
    }

    /**
     * IterationCompletion 行映射器。
     */
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
            completion.setDataDate(rs.getDate("data_date").toLocalDate());
            completion.setDataMonth(rs.getString("data_month"));
            completion.setDataQuarter(rs.getString("data_quarter"));
            return completion;
        }
    }

    /**
     * BugProgress 行映射器。
     */
    private static class BugProgressRowMapper implements RowMapper<BugProgress> {
        @Override
        public BugProgress mapRow(ResultSet rs, int rowNum) throws SQLException {
            BugProgress bugProgress = new BugProgress();
            bugProgress.setId(rs.getString("id"));
            bugProgress.setProgramName(rs.getString("program_name"));
            bugProgress.setTeamName(rs.getString("team_name"));
            bugProgress.setTotalBugs(rs.getInt("total_bugs"));
            bugProgress.setPreFixed(rs.getInt("pre_fixed"));
            bugProgress.setUatFixed(rs.getInt("uat_fixed"));
            bugProgress.setPrePending(rs.getInt("pre_pending"));
            bugProgress.setUatPending(rs.getInt("uat_pending"));
            bugProgress.setPreFixedRatio(rs.getDouble("pre_fixed_ratio"));
            bugProgress.setUatFixedRatio(rs.getDouble("uat_fixed_ratio"));
            bugProgress.setDataDate(rs.getDate("data_date").toLocalDate());
            bugProgress.setDataMonth(rs.getString("data_month"));
            bugProgress.setDataQuarter(rs.getString("data_quarter"));
            return bugProgress;
        }
    }

    /**
     * ChangeTracking 行映射器。
     */
    private static class ChangeTrackingRowMapper implements RowMapper<ChangeTracking> {
        @Override
        public ChangeTracking mapRow(ResultSet rs, int rowNum) throws SQLException {
            ChangeTracking changeTracking = new ChangeTracking();
            changeTracking.setId(rs.getString("id"));
            changeTracking.setTeamName(rs.getString("team_name"));
            changeTracking.setChangeTasks(rs.getInt("change_tasks"));
            changeTracking.setChangePoints(rs.getInt("change_points"));
            changeTracking.setDataDate(rs.getDate("data_date").toLocalDate());
            changeTracking.setDataMonth(rs.getString("data_month"));
            changeTracking.setDataQuarter(rs.getString("data_quarter"));
            return changeTracking;
        }
    }

    /**
     * TestingProgress 行映射器。
     */
    private static class TestingProgressRowMapper implements RowMapper<TestingProgress> {
        @Override
        public TestingProgress mapRow(ResultSet rs, int rowNum) throws SQLException {
            TestingProgress testingProgress = new TestingProgress();
            testingProgress.setId(rs.getString("id"));
            testingProgress.setTeamName(rs.getString("team_name"));
            testingProgress.setTotalTestCases(rs.getInt("total_test_cases"));
            testingProgress.setCompletedTestCases(rs.getInt("completed_test_cases"));
            testingProgress.setFailedTestCases(rs.getInt("failed_test_cases"));
            testingProgress.setBlockedTestCases(rs.getInt("blocked_test_cases"));
            testingProgress.setDataDate(rs.getDate("data_date").toLocalDate());
            testingProgress.setDataMonth(rs.getString("data_month"));
            testingProgress.setDataQuarter(rs.getString("data_quarter"));
            return testingProgress;
        }
    }
} 