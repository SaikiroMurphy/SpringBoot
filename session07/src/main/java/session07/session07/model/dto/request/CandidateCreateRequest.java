package session07.session07.model.dto.request;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CandidateCreateRequest {
    @NotBlank(message = "Tên không được để trống")
    @Length(min = 5, max = 50, message = "Tên phải có độ dài từ 5-50 ký tự!")
    private String fullName;

    @NotBlank(message = "Email không được để trống!")
    @Email(message = "Email không đúng định dạng!")
    private String email;

    @Min(value = 18, message = "Độ tuổi phải từ 18 trở lên!")
    private int age;

    @PositiveOrZero(message = "Số năm kinh nghiệm không được âm!")
    private int yearsOfExperience;

    @NotBlank(message = "Số điện thoại không được để trống")
    @Pattern(regexp = "^(0)[3|5|7|8|9][0-9]{8}$", message = "Số điện thoại không hợp lệ")
    private String phone;
}
