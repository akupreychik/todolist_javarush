package com.javarush.hibernate_project.command;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TagCommand implements Command {
    private String name;
    private String color;
}
