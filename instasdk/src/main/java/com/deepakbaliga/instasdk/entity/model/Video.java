package com.deepakbaliga.instasdk.entity.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by deezdroid on 24/10/15.
 */


public class Video {

    @SerializedName("low_bandwidth")
    private LowBandwidth lowBandwidth;

    @SerializedName("standard_resolution")
    private StandardResolution standardResolution;


    @SerializedName("low_resolution")
    private LowResolution lowResolution;

    public void setLowBandwidth(LowBandwidth lowBandwidth) {
        this.lowBandwidth = lowBandwidth;
    }

    public void setStandardResolution(StandardResolution standardResolution) {
        this.standardResolution = standardResolution;
    }

    public void setLowResolution(LowResolution lowResolution) {
        this.lowResolution = lowResolution;
    }

    public LowBandwidth getLowBandwidth() {
        return lowBandwidth;
    }

    public StandardResolution getStandardResolution() {
        return standardResolution;
    }

    public LowResolution getLowResolution() {
        return lowResolution;
    }

    public static class LowBandwidth {
        private String url;
        private int width;
        private int height;

        public void setUrl(String url) {
            this.url = url;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public String getUrl() {
            return url;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }
    }

    public static class StandardResolution {
        private String url;
        private int width;
        private int height;

        public void setUrl(String url) {
            this.url = url;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public String getUrl() {
            return url;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }
    }

    public static class LowResolution {
        private String url;
        private int width;
        private int height;

        public void setUrl(String url) {
            this.url = url;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public String getUrl() {
            return url;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }
    }
}