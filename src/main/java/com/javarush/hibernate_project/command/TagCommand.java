package com.javarush.hibernate_project.command;

import com.javarush.hibernate_project.command.abstracts.AbstractCommand;
import com.javarush.hibernate_project.enums.TagColor;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TagCommand extends AbstractCommand {
    private String name;
    private TagColor color;
}
