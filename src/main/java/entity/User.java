package entity;

public class User {
    private Long id;
    private String login;
    private String password;
    public final static String USER_SEPRATOR = "#";


    public User (Long id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return id + USER_SEPRATOR + login + USER_SEPRATOR + password;
    }
}
