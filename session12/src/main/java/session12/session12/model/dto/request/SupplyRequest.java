package session12.session12.model.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = false)
public class SupplyRequest {
    @NotBlank(message = "Tên vật tư không được để trống!")
    private String name;

    @NotBlank(message = "Đơn vị không được để trống!")
    private String unit;

    @NotBlank(message = "Nhà cung cấp không được để trống!")
    private String provider;
}
