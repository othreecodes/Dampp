package com.davidmadethis.dampp.model;

/**
 * Created by root on 6/20/17.
 */

public class Client {

    private String username;
    private String password;
    private boolean isVerified;
    private boolean isActive;
    private String fullName;
    private String photoUrl;

    public String getUsername() {
        return username;
    }

    public Client setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Client setPassword(String password) {
        this.password = password;
        return this;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public Client setVerified(boolean verified) {
        isVerified = verified;
        return this;
    }

    public boolean isActive() {
        return isActive;
    }

    public Client setActive(boolean active) {
        isActive = active;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public Client setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public Client setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
        return this;
    }
}
