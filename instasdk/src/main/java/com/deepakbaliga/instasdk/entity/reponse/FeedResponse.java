package com.deepakbaliga.instasdk.entity.reponse;

import com.deepakbaliga.instasdk.entity.model.Feed;
import com.deepakbaliga.instasdk.entity.model.PaginationEntity;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by deezdroid on 24/10/15.
 */
public class FeedResponse {

    private PaginationEntity pagination;

    private MetaEntity meta;


    @SerializedName("data")
    private List<Feed> feeds;

    public void setPagination(PaginationEntity pagination) {
        this.pagination = pagination;
    }

    public void setMeta(MetaEntity meta) {
        this.meta = meta;
    }

    public void setFeeds(List<Feed> feeds) {
        this.feeds = feeds;
    }

    public PaginationEntity getPagination() {
        return pagination;
    }

    public MetaEntity getMeta() {
        return meta;
    }

    public List<Feed> getFeeds() {
        return feeds;
    }


    public static class MetaEntity {
        private int code;

        public void setCode(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }
    }


}
