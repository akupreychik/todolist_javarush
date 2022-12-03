package com.javarush.hibernate_project.command;

import com.javarush.hibernate_project.command.abstracts.AbstractCommand;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserCommand extends AbstractCommand {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;

}
