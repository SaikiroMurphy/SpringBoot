package session02.session02.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import session02.session02.utils.Role;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class User {
    private int id;
    private String username;
    private String email;
    private Role role;
}
