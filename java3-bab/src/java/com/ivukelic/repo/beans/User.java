package com.ivukelic.repo.beans;

public class User {
    
    private String email;
    private String password;
    private String fullName;
    private String fullAddress;
    private int userType;

    public User(String email, String password, String fullName, String fullAddress, int userType) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.fullAddress = fullAddress;
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }
    
    
    
}
