package com.esiea.core;

public class User {
    private String username;
    private String password;
    private UserData userData;
    
    public User(String id, String password) 
    {
        this.username = id;
        this.password = password;
        this.userData= new UserData();
    }

    public String getUsername() 
    {
        return username;
    }

    public void setUsername(String id) 
    {
        this.username = id;
    }

    public String getPassword() 
    {
        return password;
    }

    public void setPassword(String password) 
    {
        this.password = password;
    }

    public UserData getUserData() 
    {
        return userData;
    }

    public void setUserData(UserData userData) 
    {
        this.userData = userData;
    }

}
