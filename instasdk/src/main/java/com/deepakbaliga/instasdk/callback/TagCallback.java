package com.deepakbaliga.instasdk.callback;

import com.deepakbaliga.instasdk.entity.model.InstaError;
import com.deepakbaliga.instasdk.entity.model.Tag;

/**
 * Created by deezdroid on 27/10/15.
 */
public interface TagCallback {
    public void onSuccess(Tag tag);

    public void onFailure(InstaError error);
}
