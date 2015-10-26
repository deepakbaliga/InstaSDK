package com.deepakbaliga.instasdk;

import android.content.Context;

import com.deepakbaliga.instasdk.api.UserEndpoint;
import com.deepakbaliga.instasdk.util.InstaConstants;
import com.deepakbaliga.instasdk.util.InstaPreference;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by deezdroid on 26/10/15.
 */
public class InstaUser {

    private Context context;
    private String accessToken;
    private Retrofit retrofit;
    public static final int ACCESS_TOKEN_NULL = 0;

    //API
    private UserEndpoint endpoint;


    public InstaUser(Context context) {
        this.context = context;

        accessToken = InstaPreference.with(context).get(InstaConstants.ACCESSTOKEN, null);

        retrofit = new Retrofit.Builder().baseUrl(InstaConstants.INSTA_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        endpoint = retrofit.create(UserEndpoint.class);

    }

}
