/**
 *   Class User :
 *
 *   Variables:
 *
 *   Constructors:
 *
 *
 *   Methods:
 *
 *
 */

public abstract class User {
    private String userId;
    private String password;

    public User(String userName, String password) {
        this.userId = userName;
        this.password = password;
    }

    public String getUserName() {
        return userId;
    }

    public void setUserName(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
