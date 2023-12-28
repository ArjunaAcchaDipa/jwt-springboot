package com.example.testapi.model;

import java.util.Objects;

public class UserModel {
    public Long id;
    public String username;
    public String password;

    public UserModel() {

    }

    public UserModel(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id" + id +
                ",username='" + username + "\'" +
                ",password='" + password + "\'" +
                "}";
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return  true;
        if(!(obj instanceof UserModel)) return false;
        UserModel userModel = (UserModel) obj;
        return Objects.equals(id, userModel.id) && Objects.equals(username, userModel.username) &&
                Objects.equals(password, userModel.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password);
    }
}
