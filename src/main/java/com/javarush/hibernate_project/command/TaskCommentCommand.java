package com.javarush.hibernate_project.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskCommentCommand implements Command{
    private String comment;
    private Long taskId;
    private Long userId;
}
