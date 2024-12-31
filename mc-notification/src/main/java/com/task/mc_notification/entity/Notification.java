package com.task.mc_notification.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table (name = "Notification")
@Data
public class Notification {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "User_Id")
    private Long userId;
    @Column (name = "Message")
    private String message;
    @Column (name = "Type_Message")
    private String type;
    @Column (name = "Read")
    private Boolean read = false;
    @Column (name = "Create_Date")
    private LocalDateTime create;
}
