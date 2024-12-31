package com.task.mc_comment.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table (name = "Comments")
@Data
public class Comment {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "Task_Id")
    private Long taskId;
    @Column (name = "User_Id")
    private Long userId;
    @Column (name = "Text_Comment")
    private String text;
    @Column (name =  "CreateDate")
    private LocalDateTime createDate;
}
