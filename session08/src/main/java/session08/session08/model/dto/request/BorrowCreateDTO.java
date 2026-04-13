package session08.session08.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import session08.session08.validator.annotation.ExistingBookId;

@Data
public class BorrowCreateDTO {
    @NotBlank
    private String username;
    @ExistingBookId
    private Long bookId;
}
