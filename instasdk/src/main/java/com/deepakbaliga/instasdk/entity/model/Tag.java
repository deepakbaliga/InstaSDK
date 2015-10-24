package com.deepakbaliga.instasdk.entity.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by deezdroid on 24/10/15.
 */

public class Tag {
    @SerializedName("media_count")
    private int mediaCount;
    private String name;

    public void setMediaCount(int mediaCount) {
        this.mediaCount = mediaCount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMediaCount() {
        return mediaCount;
    }

    public String getName() {
        return name;
    }
}