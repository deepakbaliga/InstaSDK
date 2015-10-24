package com.deepakbaliga.instasdk.entity.model;

/**
 * Created by deezdroid on 24/10/15.
 */
public class Location {


    private double latitude;
    private String name;
    private double longitude;
    private int id;

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public String getName() {
        return name;
    }

    public double getLongitude() {
        return longitude;
    }

    public int getId() {
        return id;
    }
}
