package session09.session09.model.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeCreateDTO {
    @NotBlank(message = "Tên nhân viên không được để trống!")
    private String fullName;

    @Email(message = "Email không đúng đinh dạng!")
    @NotBlank(message = "Email không được để trống!")
    private String email;

    @Pattern(regexp = "^(03|05|07|08|09)[0-9]{8}$", message = "Số điện thoại không hợp lệ!")
    private String phone;

    @Min(value =  5000000, message = "Lương tối thiểu phải là 5.000.000!")
    private int salary;

    @NotNull(message = "Không được để trống phòng ban!")
    private Long departmentId;
}
