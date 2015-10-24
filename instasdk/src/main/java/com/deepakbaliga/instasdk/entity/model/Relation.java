package com.deepakbaliga.instasdk.entity.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by deezdroid on 24/10/15.
 */

public class Relation {


    @SerializedName("outgoing_status")
    private String outgoingStatus;
    @SerializedName("target_user_is_private")
    private boolean userPrivate;
    @SerializedName("incoming_status")
    private String incomingStatus;

    public void setOutgoingStatus(String outgoingStatus) {
        this.outgoingStatus = outgoingStatus;
    }

    public void setUserPrivate(boolean userPrivate) {
        this.userPrivate = userPrivate;
    }

    public void setIncomingStatus(String incomingStatus) {
        this.incomingStatus = incomingStatus;
    }

    public String getOutgoingStatus() {
        return outgoingStatus;
    }

    public boolean isUserPrivate() {
        return userPrivate;
    }

    public String getIncomingStatus() {
        return incomingStatus;
    }

    public static class OUTGOING {
        public static String follows = "follows";
        public static String requested = "requested";
        public static String none = "none";
    }

    public static class INCOMING {
        public static String followed_by = "followed_by";
        public static String requested_by = "requested_by";
        public static String blocked_by_you = "blocked_by_you";
        public static String none = "none";
    }
}