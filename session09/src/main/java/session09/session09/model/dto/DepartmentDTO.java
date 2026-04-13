package session09.session09.model.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {
    @NotBlank(message = "Tên phòng ban không được để trống!")
    @Size(min = 5, max = 50, message = "Độ dài tên phòng ban phải từ 5-50 ký tự!")
    private String name;

    @Nullable
    @Size(max = 100, message = "Mô tả phòng ban không được quá 100 ký tự!")
    private String description;
}
