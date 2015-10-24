package com.deepakbaliga.instasdk.entity.model;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by deezdroid on 24/10/15.
 */
public class Feed {


    private Object attribution;
    private String type;
    private Object location;

    @SerializedName("comments")
    private CommentEntity comment;
    private String filter;
    @SerializedName("created_time")
    private String createdTime;
    private String link;


    private LikesEntity likes;

    @Nullable
    @SerializedName("images")
    private Image image;

    @Nullable
    @SerializedName("videos")
    private Video video;


    @Nullable
    private Caption caption;
    @SerializedName("user_has_liked")
    private boolean hasUserLiked;
    private String id;

    @SerializedName("user")
    private User owner;
    private List<String> tags;
    @SerializedName("users_in_photo")
    private List<User> usersInPhoto;


    public void setVideo(Video video) {
        this.video = video;
    }

    public void setAttribution(Object attribution) {
        this.attribution = attribution;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLocation(Object location) {
        this.location = location;
    }

    public void setComment(CommentEntity comment) {
        this.comment = comment;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setLikes(LikesEntity likes) {
        this.likes = likes;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setCaption(Caption caption) {
        this.caption = caption;
    }

    public void setHasUserLiked(boolean hasUserLiked) {
        this.hasUserLiked = hasUserLiked;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public void setUsersInPhoto(List<User> usersInPhoto) {
        this.usersInPhoto = usersInPhoto;
    }


    public Video getVideo() {
        return video;
    }

    public Object getAttribution() {
        return attribution;
    }

    public String getType() {
        return type;
    }

    public Object getLocation() {
        return location;
    }

    public CommentEntity getComment() {
        return comment;
    }

    public String getFilter() {
        return filter;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public String getLink() {
        return link;
    }

    public LikesEntity getLikes() {
        return likes;
    }

    public Image getImage() {
        return image;
    }

    public Caption getCaption() {
        return caption;
    }

    public boolean isHasUserLiked() {
        return hasUserLiked;
    }

    public String getId() {
        return id;
    }

    public User getOwner() {
        return owner;
    }

    public List<String> getTags() {
        return tags;
    }

    public List<User> getUsersInPhoto() {
        return usersInPhoto;
    }


}