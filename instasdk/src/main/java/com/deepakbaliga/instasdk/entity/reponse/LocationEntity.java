package com.deepakbaliga.instasdk.entity.reponse;

import com.deepakbaliga.instasdk.entity.model.Location;
import com.google.gson.annotations.SerializedName;

/**
 * Created by deezdroid on 25/10/15.
 */
public class LocationEntity {


    @SerializedName("data")
    private Location location;

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }


}
