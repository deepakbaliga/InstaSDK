package com.deepakbaliga.instasdk.entity.reponse;

import com.deepakbaliga.instasdk.entity.model.Feed;
import com.google.gson.annotations.SerializedName;

/**
 * Created by deezdroid on 24/10/15.
 */
public class MediaReponse {


    private MetaEntity meta;


    @SerializedName("data")
    private Feed feed;

    public void setMeta(MetaEntity meta) {
        this.meta = meta;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }

    public MetaEntity getMeta() {
        return meta;
    }

    public Feed getFeed() {
        return feed;
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
