package com.deepakbaliga.instasdk.entity.reponse;

import com.deepakbaliga.instasdk.entity.model.Comment;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by deezdroid on 24/10/15.
 */
public class CommentsList {


    private MetaEntity meta;

    @SerializedName("data")
    private List<Comment> comments;

    public void setMeta(MetaEntity meta) {
        this.meta = meta;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public MetaEntity getMeta() {
        return meta;
    }

    public List<Comment> getComments() {
        return comments;
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
