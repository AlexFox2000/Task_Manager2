package com.task.mc_task.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table (name = "Tasks")
@Data
public class Task {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "Title")
    private String title;
    @Column (name = "Description")
    private String description;
    @Column (name = "Assignee")
    private User assignee;
    @Column (name = "Status")
    private Status status;
    @Column (name = "Created_Date")
    private LocalDateTime createdDate;
    @Column (name = "Updated_Date")
    private LocalDateTime updatedDate;

}
