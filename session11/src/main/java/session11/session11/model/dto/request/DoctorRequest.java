package session11.session11.model.dto.request;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import session11.session11.utils.enums.DoctorStatusEnum;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DoctorRequest {
    @Size(min = 5, max = 50, message = "Tên bắt buộc phải chứa 5-50 kí tự!")
    private String fullName;

    @NotBlank(message = "Email không được để trống!")
    @Email(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", message = "Email không đúng định dạng!")
    private String email;

    @Past(message = "Ngày sinh phải ở trong quá khứ!")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dob;

    @Pattern(regexp = "^(0|\\+84)(3|5|7|8|9)[0-9]{8}$", message = "Số điện thoại không đúng định dạng!")
    @NotBlank(message = "Số điện thoại không được để trống!")
    private String phone;

    @PositiveOrZero(message = "Số năm kinh nghiệm không thể âm!")
    private int yearsOfExperience;

    private DoctorStatusEnum status;
}
