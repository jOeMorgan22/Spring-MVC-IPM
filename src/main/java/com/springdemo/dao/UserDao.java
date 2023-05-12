package com.springdemo.dao;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserDao {
    @NotNull(message ="Username must be provided")
    @NotBlank(message ="Username must not be blank")
    private String username;
    @NotNull(message ="Password must be provided")
    @NotBlank(message ="Password must not be blank")
    private String password;

    public UserDao(){

    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return this.username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }
}
