package com.example.dashboard.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "change")
public class Change {
    @Id
    private String id;
    private String teamName;
    private String issueKey;
    private String summary;
    private String status;
    private String changeType;
    private String assignee;
    private String createdDate;
    private String resolvedDate;
    private double storyPoints;
    private int changeTasks;
    private int changePoints;
} 