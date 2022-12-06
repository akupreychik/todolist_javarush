package com.javarush.hibernate_project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class TaskCommentDTO {
    private Long id;
    private String comment;
    private Timestamp created;
    private String username;
}
