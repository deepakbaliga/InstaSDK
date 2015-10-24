package com.deepakbaliga.instasdk.entity.model;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by deezdroid on 24/10/15.
 */
public class UserEntity {


    private MetaEntity meta;

    @Nullable
    @SerializedName("data")
    private List<User> users;

    public void setMeta(MetaEntity meta) {
        this.meta = meta;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public MetaEntity getMeta() {
        return meta;
    }

    public List<User> getUsers() {
        return users;
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
