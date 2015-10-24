package com.deepakbaliga.instasdk.entity.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by deezdroid on 24/10/15.
 */
public class LikesEntity {
    private int count;

    @SerializedName("data")
    private List<User> likedUsers;

    public void setCount(int count) {
        this.count = count;
    }

    public void setLikedUsers(List<User> likedUsers) {
        this.likedUsers = likedUsers;
    }

    public int getCount() {
        return count;
    }

    public List<User> getLikedUsers() {
        return likedUsers;
    }


}