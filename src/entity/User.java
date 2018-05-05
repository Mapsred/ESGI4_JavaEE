package entity;

public class User {
    private String email;
    private String password;
    private String status;
    private int enabled;

    public User() {

    }

    public User(String email, String password, String status) {
        this.email = email;
        this.password = password;
        this.status = status;
        this.enabled = 1;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public int getEnabled() {
        return enabled;
    }

    public String getStatus() {
        return status;
    }
}
