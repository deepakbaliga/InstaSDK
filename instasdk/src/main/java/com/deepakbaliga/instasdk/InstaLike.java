package com.deepakbaliga.instasdk;

import android.content.Context;

import com.deepakbaliga.instasdk.api.CommentEndpoint;
import com.deepakbaliga.instasdk.api.LikeEndpoint;
import com.deepakbaliga.instasdk.callback.CommentsCallback;
import com.deepakbaliga.instasdk.callback.LikesCallback;
import com.deepakbaliga.instasdk.entity.model.InstaError;
import com.deepakbaliga.instasdk.entity.model.LikesEntity;
import com.deepakbaliga.instasdk.entity.reponse.CommentsList;
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
public class InstaLike {

    private Context context;
    private String accessToken;
    private Retrofit retrofit;

    //API
    private LikeEndpoint endpoint;

    public InstaLike(Context context) {
        this.context = context;
        accessToken = InstaPreference.with(context).get(InstaConstants.ACCESSTOKEN, null);

        retrofit = new Retrofit.Builder().baseUrl(InstaConstants.INSTA_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        endpoint = retrofit.create(LikeEndpoint.class);
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
     * Get a list of recent comments on a media object.
     *
     * @param mediaID  ID of the media for which the comments have to be retrieved.
     * @param callback
     */
    public void getLikes(String mediaID, final LikesCallback callback) {

        final Call<LikesEntity> call = endpoint.getLikes(mediaID, accessToken);

        if (!NetworkUtility.isNetworkConnected(context))
            callback.onFailure(noInternet());

        else if (accessToken == null)
            callback.onFailure(noAccessToken());

        else

            call.enqueue(new Callback<LikesEntity>() {
                @Override
                public void onResponse(Response<LikesEntity> response, Retrofit retrofit) {
                    if (response.isSuccess())
                        callback.onSuccess(response.body().getLikedUsers());
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
