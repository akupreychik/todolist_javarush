package com.javarush.hibernate_project.command;

import com.javarush.hibernate_project.command.abstracts.AbstractCommand;
import com.javarush.hibernate_project.enums.TaskPriority;
import com.javarush.hibernate_project.enums.TaskStatus;
import lombok.*;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TaskCommand extends AbstractCommand {
    private String title;
    private String description;
    private TaskStatus status;
    private TaskPriority priority;
    private Integer hours;
    private String text;
    private Set<TagCommand> tags;
    private Long userId;
}
