package com.deepakbaliga.instasdk.callback;

import com.deepakbaliga.instasdk.entity.model.InstaError;
import com.deepakbaliga.instasdk.entity.model.User;

/**
 * Created by deezdroid on 26/10/15.
 */
public interface UserCallback {

    public void onSuccess(User user);

    public void onFailure(InstaError error);
}
