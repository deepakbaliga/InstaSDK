package com.deepakbaliga.instasdk.callback;

import com.deepakbaliga.instasdk.entity.model.Feed;
import com.deepakbaliga.instasdk.entity.model.InstaError;

/**
 * Created by deezdroid on 27/10/15.
 */
public interface MediaDetailsCallback {

    public void onSuccess(Feed media);

    public void onFailure(InstaError error);
}
