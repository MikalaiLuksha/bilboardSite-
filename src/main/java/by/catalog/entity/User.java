package by.catalog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private long id;
    private String firstName;
    private String lastName;
    private String password;
    private String login;
    private String role;
}
