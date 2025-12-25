package myApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private FileService fileService;

    public void register(User user) throws IOException {
        fileService.saveUser(user);
    }

    public static boolean authenticate(String username, String password) throws IOException {
        List<String> users = FileService.readAllUsers();
        for (String line : users) {
            String[] parts = line.split(",");
            if (parts.length >= 2) {
                String savedUsername = parts[0];
                String savedPassword = parts[1];

                if (savedUsername.equals(username) && savedPassword.equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }
}
