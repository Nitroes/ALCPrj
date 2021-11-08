package top.aliceproject.alcprj.entity;


import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID=1L;
    private String userId;
    private String name;
    private String password;

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
