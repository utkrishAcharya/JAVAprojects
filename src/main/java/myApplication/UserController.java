package myApplication;

import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/signup")
    public String signupInfo() {
        return "Use POST with JSON at /user/signup";
    }

    @GetMapping("/login")
    public String loginInfo() {
        return "Use POST with JSON at /user/login";
    }

    // Accept JSON for signup
    @PostMapping("/signup")
    public String signup(@RequestBody User user) throws IOException {
        new FileService().saveUser(user);
        return "Signup successful!";
    }

    // Accept JSON for login
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) throws IOException {
        boolean success = UserService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
        return success ? "Login successful!" : "Invalid username or password!";
    }

    // DTO class for login data
    static class LoginRequest {
        private String username;
        private String password;
        public String getUsername() { return username; }
        public void setUsername(String username) { this.username = username; }
        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
    }
}
