package session08.session08.model.dto.request;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookCreateDTO {
    private String title;
    private String author;
    private int stock;
    private MultipartFile coverImage;

}
