package com.deepakbaliga.instasdk.entity.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by deezdroid on 24/10/15.
 */
public class CommentEntity {
    private int count;


    @SerializedName("data")
    private List<Comment> comments;

    public void setCount(int count) {
        this.count = count;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public int getCount() {
        return count;
    }

    public List<Comment> getComments() {
        return comments;
    }


}