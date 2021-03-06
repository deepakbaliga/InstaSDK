package com.deepakbaliga.instasdk.callback;

import com.deepakbaliga.instasdk.entity.model.InstaError;
import com.deepakbaliga.instasdk.entity.model.Location;

/**
 * Created by deezdroid on 27/10/15.
 */
public interface LocationCallback {
    public void onSuccess(Location location);

    public void onFailure(InstaError error);
}
