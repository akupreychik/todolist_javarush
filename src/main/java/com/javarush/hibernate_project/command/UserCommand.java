package com.javarush.hibernate_project.command;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCommand implements Command {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;

}
