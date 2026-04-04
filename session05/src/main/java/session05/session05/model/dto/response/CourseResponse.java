package session05.session05.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import session05.session05.utils.CourseStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseResponse {
    private Long id;
    private String title;
    private CourseStatus status;
    private CourseInstructorResponse instructor;
}
