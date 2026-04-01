package session04.session04.model.dto;

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
