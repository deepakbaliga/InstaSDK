package com.deepakbaliga.instasdk.entity.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by deezdroid on 24/10/15.
 */
public class Comment {
    private String created_time;
    private String text;

    private User from;
    @SerializedName("id")
    private String commentId;

    public void setCreated_time(String created_time) {
        this.created_time = created_time;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setFrom(User from) {
        this.from = from;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getCreated_time() {
        return created_time;
    }

    public String getText() {
        return text;
    }

    public User getFrom() {
        return from;
    }

    public String getCommentId() {
        return commentId;
    }


}