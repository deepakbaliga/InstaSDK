package com.deepakbaliga.instasdk.entity.reponse;

import com.deepakbaliga.instasdk.entity.model.Location;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by deezdroid on 24/10/15.
 */
public class Locations {


    private MetaEntity meta;


    @SerializedName("data")
    private List<Location> locations;

    public void setMeta(MetaEntity meta) {
        this.meta = meta;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public MetaEntity getMeta() {
        return meta;
    }

    public List<Location> getLocations() {
        return locations;
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
