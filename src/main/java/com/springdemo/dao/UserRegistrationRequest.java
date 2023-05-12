package com.springdemo.dao;

import validation.Password;
import validation.Username;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserRegistrationRequest {


    @Username
    private String username;
    @NotBlank
    @NotBlank
    @Email
    private String email;

    private String usdaZone;

    @Password
    private String password;

    private String role;

    public UserRegistrationRequest(){
    }

    public UserRegistrationRequest(String username, String email, String usdaZone,
                                   String password, String role){
        this.username = username;
        this.email = email;
        this.usdaZone = usdaZone;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsdaZone() {
        return usdaZone;
    }

    public void setUsdaZone(String usdaZone) {
        this.usdaZone = usdaZone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
