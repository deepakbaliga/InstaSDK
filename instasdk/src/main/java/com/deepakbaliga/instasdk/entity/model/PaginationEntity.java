package com.deepakbaliga.instasdk.entity.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by deezdroid on 24/10/15.
 */
public class PaginationEntity {
    @SerializedName("next_url")
    private String nextUrl;
    @SerializedName("next_max_id")
    private String nextMaxId;

    @SerializedName("next_cursor")
    private String nextCursor;

    public void setNextUrl(String nextUrl) {
        this.nextUrl = nextUrl;
    }

    public void setNextMaxId(String nextMaxId) {
        this.nextMaxId = nextMaxId;
    }

    public String getNextUrl() {
        return nextUrl;
    }

    public String getNextMaxId() {
        return nextMaxId;
    }

    public String getNextCursor() {
        return nextCursor;
    }

    public void setNextCursor(String nextCursor) {
        this.nextCursor = nextCursor;
    }
}