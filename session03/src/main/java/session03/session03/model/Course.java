package session03.session03.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import session03.session03.utils.CourseStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Course {
    private String id;
    private String title;
    private CourseStatus status;
    private String instructorId;
}
