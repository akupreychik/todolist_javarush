package com.javarush.hibernate_project.command;

import com.javarush.hibernate_project.dto.TagDTO;
import com.javarush.hibernate_project.enums.TaskPriority;
import com.javarush.hibernate_project.enums.TaskStatus;
import lombok.*;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskCommand implements Command {
    private String title;
    private String description;
    private TaskStatus status;
    private TaskPriority priority;
    private Integer hours;
    private String text;
    private Set<TagDTO> tags;
    private Long userId;
}
