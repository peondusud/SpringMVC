package com.esiea.core;

public class User {
    private String userName;
    private String password;
    private UserData userData;

    public String getId() {
        return userName;
    }

    public void setId(String id) {
        this.userName = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public User(String id, String password) {
        this.userName = id;
        this.password = password;
    }
    
}
