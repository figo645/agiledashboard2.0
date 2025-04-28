package com.example.dashboard.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "change_tracking")
public class ChangeTracking {
    @Id
    private String id;
    private String teamName;
    private int changeTasks;
    private int changePoints;
    private LocalDate dataDate;
    private String dataMonth;
    private String dataQuarter;
} 