package com.task.mc_report.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table (name = "Report")
@Data
public class Report {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "User_Id")
    private Long userId;
    @Column (name = "Total_Tasks")
    private Integer totalTasks;
    @Column (name = "Completed_Tasks")
    private Integer completedTasks;
    @Column (name = "Total_Time_Spent")
    private Long totalTimeSpent;
}
