package myApplication;

import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class FileService {

    private static final Path filePath = Path.of("users.txt");

    public void saveUser(User user) throws IOException {
        // Create the file if it doesn't exist
        if (!Files.exists(filePath)) {
            Files.createFile(filePath);
        }

        try (FileWriter fw = new FileWriter(filePath.toFile(), true)) {
            fw.write(user.getUsername() + "," + user.getPassword() + "," +
                    user.getName() + "," + user.getNumber() + "," +
                    user.getEmail() + "\n");
        }
    }

    public static List<String> readAllUsers() throws IOException {
        if (!Files.exists(filePath)) {
            Files.createFile(filePath);
        }
        return Files.readAllLines(filePath);
    }
}
