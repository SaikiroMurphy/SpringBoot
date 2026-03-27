package session02.session02.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import session02.session02.utils.Priority;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Task {
    private int id;
    private String title;
    private String description;
    private Priority priority;
    private int assignedTo;
}
