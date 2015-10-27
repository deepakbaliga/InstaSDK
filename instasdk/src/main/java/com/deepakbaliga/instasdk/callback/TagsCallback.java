package com.deepakbaliga.instasdk.callback;

import com.deepakbaliga.instasdk.entity.model.InstaError;
import com.deepakbaliga.instasdk.entity.model.Tag;

import java.util.List;

/**
 * Created by deezdroid on 27/10/15.
 */
public interface TagsCallback {
    public void onSuccess(List<Tag> tags);

    public void onFailure(InstaError error);
}
