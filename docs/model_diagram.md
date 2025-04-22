classDiagram
    %% === Sprint Planning ===
    class SprintPlanningData {
        +List<TeamData> teams
    }
    
    class TeamData {
        +String teamName
        +int teamSize
        +int totalPoints
        +int pointsPerPerson
        +int storyPercentage
        +int technicalTaskPercentage
        +int optimizationPercentage
        +int testingPercentage
        +int firstWeekTestingRate
        +int devDelayCards
        +int testDelayCards
    }

    SprintPlanningData "1" *-- "*" TeamData


    %% === Iteration Completion ===
    class IterationCompletionData {
        +List<String> labels
        +List<Integer> planned
        +List<Integer> actual
        +List<TeamProgress> teams
    }

    class TeamProgress {
        +String teamName
        +List<Integer> actual
    }

    IterationCompletionData "1" *-- "*" TeamProgress


    %% === Change Tracking ===
    class ChangeTrackingData {
        +List<String> labels
        +List<Integer> newTasks
        +List<Integer> modifiedTasks
        +List<Integer> removedTasks
        +List<TeamChanges> teams
    }

    class TeamChanges {
        +String teamName
        +List<Integer> newTasks
        +List<Integer> modifiedTasks
        +List<Integer> removedTasks
    }

    ChangeTrackingData "1" *-- "*" TeamChanges


    %% === Testing Progress ===
    class TestingProgressData {
        +List<String> labels
        +List<Integer> plannedTesting
        +List<Integer> actualTesting
        +TestCaseStats testCaseStats
        +List<TeamTestingProgress> teams
    }

    class TestCaseStats {
        +int total
        +int completed
        +int passed
        +int failed
    }

    class TeamTestingProgress {
        +String teamName
        +List<Integer> actualTesting
        +TestCaseStats testCaseStats
    }

    TestingProgressData "1" *-- "1" TestCaseStats
    TestingProgressData "1" *-- "*" TeamTestingProgress
    TeamTestingProgress "1" *-- "1" TestCaseStats


    %% === Bug Progress ===
    class BugProgressData {
        +List<String> labels
        +List<Integer> newBugs
        +List<Integer> fixedBugs
        +List<Integer> remainingBugs
        +BugSeverity bugSeverity
        +List<TeamBugProgress> teams
    }

    class BugSeverity {
        +int critical
        +int high
        +int medium
        +int low
    }

    class TeamBugProgress {
        +String teamName
        +List<Integer> newBugs
        +List<Integer> fixedBugs
        +List<Integer> remainingBugs
        +BugSeverity bugSeverity
    }

    BugProgressData "1" *-- "1" BugSeverity
    BugProgressData "1" *-- "*" TeamBugProgress
    TeamBugProgress "1" *-- "1" BugSeverity