package com.deepakbaliga.instasdk;

import android.content.Context;

import com.deepakbaliga.instasdk.api.MediaEndpoint;
import com.deepakbaliga.instasdk.api.UserEndpoint;
import com.deepakbaliga.instasdk.callback.MediaDetailsCallback;
import com.deepakbaliga.instasdk.callback.UserCallback;
import com.deepakbaliga.instasdk.entity.model.InstaError;
import com.deepakbaliga.instasdk.entity.reponse.MediaReponse;
import com.deepakbaliga.instasdk.entity.reponse.UserResponse;
import com.deepakbaliga.instasdk.util.InstaConstants;
import com.deepakbaliga.instasdk.util.InstaPreference;
import com.deepakbaliga.instasdk.util.NetworkUtility;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by deezdroid on 27/10/15.
 */
public class InstaMedia {

    private Context context;
    private String accessToken;
    private Retrofit retrofit;

    //APIs
    private MediaEndpoint endpoint;


    public InstaMedia(Context context) {
        this.context = context;

        accessToken = InstaPreference.with(context).get(InstaConstants.ACCESSTOKEN, null);

        retrofit = new Retrofit.Builder().baseUrl(InstaConstants.INSTA_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        endpoint = retrofit.create(MediaEndpoint.class);

    }


    private InstaError noInternet() {
        return new InstaError(InstaConstants.NOT_CONNECTED, InstaConstants.NO_INTERNET_CONNECTION_MESSAGE);
    }

    private InstaError noAccessToken() {
        return new InstaError(InstaConstants.ACCESS_TOKEN_NULL, InstaConstants.ACCESS_TOKEN_MESSAGE);
    }

    private InstaError error(Throwable t) {
        return new InstaError(InstaConstants.ERROR, t.getMessage());
    }


    /**
     * Get information about a media object. The returned 'type' key will allow you to differentiate
     * between image and video media.
     *
     * @param mediaID  ID of the media for which the details have to be retrieved
     * @param callback
     */
    public void getMediaDetails(String mediaID, final MediaDetailsCallback callback) {

        final Call<MediaReponse> call = endpoint.getMediaDetails(mediaID, accessToken);

        if (!NetworkUtility.isNetworkConnected(context))
            callback.onFailure(noInternet());

        else if (accessToken == null)
            callback.onFailure(noAccessToken());

        else

            call.enqueue(new Callback<MediaReponse>() {
                @Override
                public void onResponse(Response<MediaReponse> response, Retrofit retrofit) {
                    if (response.isSuccess())
                        callback.onSuccess(response.body().getFeed());
                    else
                        callback.onFailure(new InstaError(response.code(), response.raw().message()));
                }

                @Override
                public void onFailure(Throwable t) {
                    callback.onFailure(error(t));
                }
            });

    }


}
