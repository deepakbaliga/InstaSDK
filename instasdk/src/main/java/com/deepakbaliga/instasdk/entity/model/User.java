package com.deepakbaliga.instasdk.entity.model;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by deezdroid on 24/10/15.
 */
public class User {
    private String username;
    private String bio;
    private String website;
    @SerializedName("profile_picture")
    private String profilePicture;
    @SerializedName("full_name")
    private String fullName;


    @Nullable
    private Counts counts;
    @SerializedName("id")
    private String userId;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setCounts(Counts counts) {
        this.counts = counts;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public String getBio() {
        return bio;
    }

    public String getWebsite() {
        return website;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public String getFullName() {
        return fullName;
    }

    public Counts getCounts() {
        return counts;
    }

    public String getUserId() {
        return userId;
    }


}