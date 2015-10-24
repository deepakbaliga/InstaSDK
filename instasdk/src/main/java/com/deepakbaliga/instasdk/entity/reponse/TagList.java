package com.deepakbaliga.instasdk.entity.reponse;

import com.deepakbaliga.instasdk.entity.model.Tag;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by deezdroid on 24/10/15.
 */
public class TagList {

    private MetaEntity meta;

    @SerializedName("data")
    private List<Tag> tags;

    public void setMeta(MetaEntity meta) {
        this.meta = meta;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public MetaEntity getMeta() {
        return meta;
    }

    public List<Tag> getTags() {
        return tags;
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
