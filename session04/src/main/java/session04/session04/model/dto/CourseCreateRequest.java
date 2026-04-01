package session04.session04.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import session04.session04.utils.CourseStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseCreateRequest {
    private String title;
    private CourseStatus status;
    private Long instructorId;
}
