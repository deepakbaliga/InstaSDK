package com.deepakbaliga.instasdk.callback;

import com.deepakbaliga.instasdk.entity.model.InstaError;
import com.deepakbaliga.instasdk.entity.model.User;

import java.util.List;

/**
 * Created by deezdroid on 26/10/15.
 */
public interface UsersCallback {

    public void onSuccess(List<User> UserCallback);

    public void onFailure(InstaError error);
}
