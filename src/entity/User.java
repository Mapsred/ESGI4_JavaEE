package entity;

public class User {
    private String username;
    private String password;
    private int enabled;

    public User() {

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.enabled = 1;
    }

    public String getUsername() {

        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
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

    public User setEnabled(int enabled) {
        this.enabled = enabled;
        return this;
    }
}
