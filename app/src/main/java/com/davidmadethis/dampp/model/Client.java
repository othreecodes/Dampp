package com.davidmadethis.dampp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by root on 6/20/17.
 */

public class Client implements Parcelable {

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


    protected Client(Parcel in) {
        username = in.readString();
        password = in.readString();
        isVerified = in.readByte() != 0;
        isActive = in.readByte() != 0;
        fullName = in.readString();
        photoUrl = in.readString();
        sex = in.readString();
    }

    public static final Creator<Client> CREATOR = new Creator<Client>() {
        @Override
        public Client createFromParcel(Parcel in) {
            return new Client(in);
        }

        @Override
        public Client[] newArray(int size) {
            return new Client[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(username);
        parcel.writeString(password);
        parcel.writeByte((byte) (isVerified ? 1 : 0));
        parcel.writeByte((byte) (isActive ? 1 : 0));
        parcel.writeString(fullName);
        parcel.writeString(photoUrl);
        parcel.writeString(sex);
    }
}
