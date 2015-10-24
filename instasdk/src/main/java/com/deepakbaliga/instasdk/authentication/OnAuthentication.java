package com.deepakbaliga.instasdk.authentication;

/**
 * Created by deezdroid on 24/10/15.
 */
public interface OnAuthentication {
    public void success(String accessToken);
    public void failure(String message);

}
