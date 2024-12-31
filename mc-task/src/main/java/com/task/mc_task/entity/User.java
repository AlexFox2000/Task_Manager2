package com.task.mc_task.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Table (name = "Users")
@Data
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "username")
    private String username;
    @Column (name = "email")
    private String email;
    @Column (name = "password")
    private String password;
    @Column (name = "role")
    private List<Role>  role;
}

