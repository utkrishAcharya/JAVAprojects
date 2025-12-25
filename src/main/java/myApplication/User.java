package myApplication;

public class User {
    private String name;
    private String number;
    private String email;
    private String username;
    private String password;

    // Default no-argument constructor (important for some frameworks)
    public User() {}

    // Full constructor
    public User(String name, String number, String email, String username, String password) {
        this.name = name;
        this.number = number;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    // GETTERS
    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // SETTERS (optional)
    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
