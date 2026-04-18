package session11.session11.model.entity;

import jakarta.persistence.*;
import lombok.*;
import session11.session11.utils.RoleEnum;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoleEnum name;
}
