package session05.session05.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import session05.session05.utils.CourseStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseUpdateRequest {
    private String title;
    private CourseStatus status;
    private Long instructorId;
}
