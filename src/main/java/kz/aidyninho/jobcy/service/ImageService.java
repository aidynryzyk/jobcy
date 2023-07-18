package kz.aidyninho.jobcy.service;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Optional;

@Service
public class ImageService {

    @Value("${app.image.bucket}")
    private String bucket;

    @SneakyThrows
    public void upload(String imagePath, InputStream content) {
        Path fullPath = Path.of(bucket, imagePath);

        try (content) {
            Files.createDirectories(fullPath.getParent());
            Files.write(fullPath, content.readAllBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        }
    }

    @SneakyThrows
    public Optional<byte[]> get(String imagePath) {
        Path fullPath = Path.of(bucket, imagePath);
        return Files.exists(fullPath) ? Optional.of(Files.readAllBytes(fullPath)) : Optional.empty();
    }
}
