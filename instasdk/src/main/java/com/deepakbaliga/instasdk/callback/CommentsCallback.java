package com.deepakbaliga.instasdk.callback;

import com.deepakbaliga.instasdk.entity.model.Comment;
import com.deepakbaliga.instasdk.entity.model.InstaError;

import java.util.List;

/**
 * Created by deezdroid on 27/10/15.
 */
public interface CommentsCallback {

    public void onSuccess(List<Comment> comments);

    public void onFailure(InstaError error);
}
