package com.example.dashboard.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "bug")
public class Bug {
    @Id
    private String id;
    private String programName;
    private String teamName;
    private int totalBugs;
    private int preFixed;
    private int uatFixed;
    private int prePending;
    private int uatPending;
    private double preFixedRatio;
    private double uatFixedRatio;
} 