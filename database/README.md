# Sprint Dashboard Database

This directory contains all database-related scripts and configurations for the Sprint Dashboard application.

## Directory Structure

```
database/
├── init.sql              # Database initialization script
├── migrations/           # Database migration scripts
│   ├── 001_create_tables.sql
│   ├── 002_create_indexes.sql
│   └── 003_create_triggers.sql
├── functions/            # Database functions
│   └── update_timestamp.sql
├── views/               # Database views
│   └── metrics_views.sql
└── scripts/             # Utility scripts
    └── import_data.py
```

## Database Setup

1. Create the database:
   ```bash
   psql -U postgres -f database/init.sql
   ```

2. Run migrations in order:
   ```bash
   psql -U postgres -d sprint_dashboard -f database/migrations/001_create_tables.sql
   psql -U postgres -d sprint_dashboard -f database/migrations/002_create_indexes.sql
   psql -U postgres -d sprint_dashboard -f database/functions/update_timestamp.sql
   psql -U postgres -d sprint_dashboard -f database/migrations/003_create_triggers.sql
   ```

3. Create views:
   ```bash
   psql -U postgres -d sprint_dashboard -f database/views/metrics_views.sql
   ```

## Data Import

To import data from CSV files:

1. Install required Python packages:
   ```bash
   pip install psycopg2-binary pandas
   ```

2. Update the database configuration in `database/scripts/import_data.py`

3. Run the import script:
   ```bash
   python database/scripts/import_data.py
   ```

## Database Schema

### Tables

1. `sprint_planning`
   - Tracks sprint planning metrics
   - Includes team performance indicators

2. `iteration_completion`
   - Records iteration completion data
   - Tracks issue status and points

3. `bug`
   - Stores bug-related information
   - Tracks bug status and severity

4. `change`
   - Manages change requests
   - Tracks change status and impact

5. `testing`
   - Records testing activities
   - Tracks test coverage and results

### Views

1. `daily_metrics`
   - Daily performance metrics
   - Aggregated by team and date

2. `weekly_metrics`
   - Weekly performance metrics
   - Aggregated by team and week

3. `biweekly_metrics`
   - Bi-weekly performance metrics
   - Aggregated by team and bi-week period

4. `monthly_metrics`
   - Monthly performance metrics
   - Aggregated by team and month

## Maintenance

- Regular backups should be performed
- Indexes should be maintained periodically
- Views should be updated as business requirements change

## Version Control

All database changes should be:
1. Documented in this README
2. Added to the appropriate migration script
3. Tested in a development environment
4. Applied to production following the change management process 