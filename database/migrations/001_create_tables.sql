-- 创建sprint_planning表
CREATE TABLE IF NOT EXISTS sprint_planning (
    id SERIAL PRIMARY KEY,
    team_name VARCHAR(255) NOT NULL,
    program_name VARCHAR(255) NOT NULL,
    planned_count DOUBLE PRECISION,
    completed_count DOUBLE PRECISION,
    storypoint_planned DOUBLE PRECISION,
    storypoint_completed DOUBLE PRECISION,
    test_points DOUBLE PRECISION,
    user_story_points DOUBLE PRECISION,
    enabler_points DOUBLE PRECISION,
    user_story_ratio DOUBLE PRECISION,
    enabler_ratio DOUBLE PRECISION,
    story_throughput DOUBLE PRECISION,
    data_date DATE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 创建iteration_completion表
CREATE TABLE IF NOT EXISTS iteration_completion (
    id SERIAL PRIMARY KEY,
    team_name VARCHAR(255) NOT NULL,
    issue_type VARCHAR(50) NOT NULL,
    issue_key VARCHAR(50) NOT NULL,
    summary TEXT,
    status VARCHAR(50),
    points DOUBLE PRECISION,
    data_date DATE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 创建bug表
CREATE TABLE IF NOT EXISTS bug (
    id SERIAL PRIMARY KEY,
    team_name VARCHAR(255) NOT NULL,
    issue_type VARCHAR(50) NOT NULL,
    issue_key VARCHAR(50) NOT NULL,
    summary TEXT,
    status VARCHAR(50),
    points DOUBLE PRECISION,
    data_date DATE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 创建change表
CREATE TABLE IF NOT EXISTS change (
    id SERIAL PRIMARY KEY,
    team_name VARCHAR(255) NOT NULL,
    issue_type VARCHAR(50) NOT NULL,
    issue_key VARCHAR(50) NOT NULL,
    summary TEXT,
    status VARCHAR(50),
    points DOUBLE PRECISION,
    data_date DATE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 创建testing表
CREATE TABLE IF NOT EXISTS testing (
    id SERIAL PRIMARY KEY,
    team_name VARCHAR(255) NOT NULL,
    issue_type VARCHAR(50) NOT NULL,
    issue_key VARCHAR(50) NOT NULL,
    summary TEXT,
    status VARCHAR(50),
    points DOUBLE PRECISION,
    data_date DATE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
); 