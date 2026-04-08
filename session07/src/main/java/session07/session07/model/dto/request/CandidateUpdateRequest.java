package session07.session07.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CandidateUpdateRequest {
    @NotBlank
    private String address;
    
    @Size(min = 10, max = 200)
    private String bio;
}
