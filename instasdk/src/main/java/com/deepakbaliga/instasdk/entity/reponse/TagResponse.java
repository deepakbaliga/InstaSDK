package com.deepakbaliga.instasdk.entity.reponse;

import com.deepakbaliga.instasdk.entity.model.Tag;
import com.google.gson.annotations.SerializedName;

/**
 * Created by deezdroid on 24/10/15.
 */
public class TagResponse {

    private MetaEntity meta;


    @SerializedName("data")
    private Tag tag;

    public void setMeta(MetaEntity meta) {
        this.meta = meta;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public MetaEntity getMeta() {
        return meta;
    }

    public Tag getTag() {
        return tag;
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
