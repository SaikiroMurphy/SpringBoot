package session05.session05.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import session05.session05.utils.CourseStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CourseResponseV2 {
    private Long id;
    private String title;
    private CourseStatus status;
}
