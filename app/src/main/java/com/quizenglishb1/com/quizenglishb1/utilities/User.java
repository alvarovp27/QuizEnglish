package com.quizenglishb1.com.quizenglishb1.utilities;

/**
 * Created by Alvaro on 24/08/2015.
 */
public class User {

    private String name;
    private String password;
    private String token;

    public User(String name, String password, String token) {
        this.password = password;
        this.name = name;
        this.token = token;
    }

    public String getName(){
        return name;
    }

    public String getPassword(){
        return password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String t) {
        this.token=t;
    }
}
