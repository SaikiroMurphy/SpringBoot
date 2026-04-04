package session05.session05.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentEnrollmentRequest {
    private Long studentId;
    private Long courseId;
}
