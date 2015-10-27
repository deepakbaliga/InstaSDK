package com.deepakbaliga.instasdk.callback;

import com.deepakbaliga.instasdk.entity.model.InstaError;
import com.deepakbaliga.instasdk.entity.model.Relation;

/**
 * Created by deezdroid on 27/10/15.
 */
public interface RelationCallback {

    public void onSuccess(Relation relation);

    public void onFailure(InstaError error);
}
