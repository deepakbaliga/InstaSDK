package com.deepakbaliga.instasdk.entity.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by deezdroid on 24/10/15.
 */
public class Counts {

    @SerializedName("media")
    private int mediaCount;
    @SerializedName("followed_by")
    private int followedByCount;
    @SerializedName("follows")
    private int followsCount;

    public void setMediaCount(int mediaCount) {
        this.mediaCount = mediaCount;
    }

    public void setFollowedByCount(int followedByCount) {
        this.followedByCount = followedByCount;
    }

    public void setFollowsCount(int followsCount) {
        this.followsCount = followsCount;
    }

    public int getMediaCount() {
        return mediaCount;
    }

    public int getFollowedByCount() {
        return followedByCount;
    }

    public int getFollowsCount() {
        return followsCount;
    }
}