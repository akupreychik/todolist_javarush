package com.javarush.hibernate_project.dto;

import lombok.Data;

import java.util.List;

@Data
public class TaskDTO {
    private Long id;
    private String title;
    private String description;
    private String status;
    private String priority;
    private Integer hours;
    private List<TagDTO> tags;
}
