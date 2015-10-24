package com.deepakbaliga.instasdk.util;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by deezdroid on 24/10/15.
 */
public class NetworkUtility {

    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }
}
