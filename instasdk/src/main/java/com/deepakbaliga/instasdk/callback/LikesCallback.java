package com.deepakbaliga.instasdk.callback;

import com.deepakbaliga.instasdk.entity.model.Comment;
import com.deepakbaliga.instasdk.entity.model.InstaError;
import com.deepakbaliga.instasdk.entity.model.User;

import java.util.List;

/**
 * Created by deezdroid on 27/10/15.
 */
public interface LikesCallback {

    public void onSuccess(List<User> users);

    public void onFailure(InstaError error);
}
