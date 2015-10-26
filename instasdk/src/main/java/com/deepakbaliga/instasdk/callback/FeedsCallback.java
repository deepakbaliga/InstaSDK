package com.deepakbaliga.instasdk.callback;

import com.deepakbaliga.instasdk.entity.model.Feed;
import com.deepakbaliga.instasdk.entity.model.InstaError;
import com.deepakbaliga.instasdk.entity.model.User;

import java.util.List;

/**
 * Created by deezdroid on 26/10/15.
 */
public interface FeedsCallback {

    public void onSuccess(List<Feed> feeds);

    public void onFailure(InstaError error);
}
