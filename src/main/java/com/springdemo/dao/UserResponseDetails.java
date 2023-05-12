package com.springdemo.dao;

public class UserResponseDetails {
    private Long id;

    private String groupName;

    private String username;

    public UserResponseDetails(Long id, String groupName, String username){
        this.id = id;
        this.groupName = groupName;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
