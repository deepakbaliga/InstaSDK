package com.deepakbaliga.instasdk.callback;

import com.deepakbaliga.instasdk.entity.model.InstaError;
import com.deepakbaliga.instasdk.entity.model.Location;

import java.util.List;

/**
 * Created by deezdroid on 27/10/15.
 */
public interface LocationsCallback {
    public void onSuccess(List<Location> locations);

    public void onFailure(InstaError error);
}
