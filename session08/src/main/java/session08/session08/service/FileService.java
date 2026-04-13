package session08.session08.service;

import java.io.IOException;
import java.nio.file.*;

import org.springframework.web.multipart.MultipartFile;

public class FileService {
    public static String saveFile(MultipartFile file) throws IOException {
        String uploadDir = "uploads/";

        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();

        Path filePath = uploadPath.resolve(fileName);

        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        return filePath.toString();
    }
}
