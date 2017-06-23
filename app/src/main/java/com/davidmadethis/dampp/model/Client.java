package com.davidmadethis.dampp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by root on 6/20/17.
 */

public class Client {

    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;
    @SerializedName("is_verified")
    private boolean isVerified;
    @SerializedName("is_active")
    private boolean isActive;
    @SerializedName("full_name")
    private String fullName;
    @SerializedName("photo_url")
    private String photoUrl;
    @SerializedName("sex")
    private String sex;


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

    public String getSex() {
        return sex;
    }

    public Client setSex(String sex) {
        this.sex = sex;
        return this;
    }
}
