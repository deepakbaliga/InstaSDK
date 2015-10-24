package com.deepakbaliga.instasdk.entity.reponse;

import com.deepakbaliga.instasdk.entity.model.User;
import com.google.gson.annotations.SerializedName;

/**
 * Created by deezdroid on 24/10/15.
 */
public class UserResponse {

    private MetaEntity meta;


    @SerializedName("data")
    private User user;

    public void setMeta(MetaEntity meta) {
        this.meta = meta;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public MetaEntity getMeta() {
        return meta;
    }

    public User getUser() {
        return user;
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
