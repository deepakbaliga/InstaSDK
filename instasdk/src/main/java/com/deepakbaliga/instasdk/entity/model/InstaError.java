package com.deepakbaliga.instasdk.entity.model;

/**
 * Created by deezdroid on 26/10/15.
 */
public class InstaError {

    private int code;
    private String message;

    public InstaError(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public InstaError() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
