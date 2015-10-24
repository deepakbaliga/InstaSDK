package com.deepakbaliga.instasdk.entity.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by deezdroid on 24/10/15.
 */
public class Caption {
    @SerializedName("created_time")
    private String createdTime;
    private String text;


    private User from;
    private String id;


    public void setText(String text) {
        this.text = text;
    }

    public void setFrom(User from) {
        this.from = from;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getText() {
        return text;
    }

    public User getFrom() {
        return from;
    }

    public String getId() {
        return id;
    }

}