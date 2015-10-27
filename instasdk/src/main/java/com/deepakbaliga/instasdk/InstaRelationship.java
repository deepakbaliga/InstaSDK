package com.deepakbaliga.instasdk;

import android.content.Context;

import com.deepakbaliga.instasdk.api.RelationshipEndpoint;
import com.deepakbaliga.instasdk.callback.RelationCallback;
import com.deepakbaliga.instasdk.callback.UsersCallback;
import com.deepakbaliga.instasdk.entity.model.InstaError;
import com.deepakbaliga.instasdk.entity.reponse.RelationshipEntity;
import com.deepakbaliga.instasdk.entity.reponse.UserList;
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
public class InstaRelationship {

    private Context context;
    private String accessToken;
    private Retrofit retrofit;

    //API
    private RelationshipEndpoint endpoint;

    public InstaRelationship(Context context) {
        this.context = context;
        accessToken = InstaPreference.with(context).get(InstaConstants.ACCESSTOKEN, null);

        retrofit = new Retrofit.Builder().baseUrl(InstaConstants.INSTA_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        endpoint = retrofit.create(RelationshipEndpoint.class);
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
     * Get the list of users this user follows.
     *
     * @param userID   ID of the user whos follow list has to be retrieved.
     *                 Can be InstaConstants.SELF to retrieve authenticated users follows
     * @param callback
     */
    public void getFollows(String userID, final UsersCallback callback) {

        Call<UserList> call = endpoint.getFollows(userID, accessToken);

        if (!NetworkUtility.isNetworkConnected(context))
            callback.onFailure(noInternet());

        else if (accessToken == null)
            callback.onFailure(noAccessToken());

        else
            call.enqueue(new Callback<UserList>() {
                @Override
                public void onResponse(Response<UserList> response, Retrofit retrofit) {
                    if (response.isSuccess())
                        callback.onSuccess(response.body().getUsers());
                    else
                        callback.onFailure(new InstaError(response.code(), response.raw().message()));
                }

                @Override
                public void onFailure(Throwable t) {
                    callback.onFailure(error(t));
                }
            });

    }

    /**
     * Get the list of users who follow this user
     *
     * @param userID   ID of the user whos follow list has to be retrieved.
     *                 Can be InstaConstants.SELF to retrieve authenticated users follows
     * @param callback
     */
    public void getFollowedBy(String userID, final UsersCallback callback) {

        Call<UserList> call = endpoint.getFollowedBy(userID, accessToken);

        if (!NetworkUtility.isNetworkConnected(context))
            callback.onFailure(noInternet());

        else if (accessToken == null)
            callback.onFailure(noAccessToken());

        else
            call.enqueue(new Callback<UserList>() {
                @Override
                public void onResponse(Response<UserList> response, Retrofit retrofit) {
                    if (response.isSuccess())
                        callback.onSuccess(response.body().getUsers());
                    else
                        callback.onFailure(new InstaError(response.code(), response.raw().message()));
                }

                @Override
                public void onFailure(Throwable t) {
                    callback.onFailure(error(t));
                }
            });

    }

    /**
     * List the users who have requested authenticated users permission to follow.
     *
     * @param callback
     */
    public void getFollowRequests(final UsersCallback callback) {

        Call<UserList> call = endpoint.getFollowRequests(accessToken);

        if (!NetworkUtility.isNetworkConnected(context))
            callback.onFailure(noInternet());

        else if (accessToken == null)
            callback.onFailure(noAccessToken());

        else
            call.enqueue(new Callback<UserList>() {
                @Override
                public void onResponse(Response<UserList> response, Retrofit retrofit) {
                    if (response.isSuccess())
                        callback.onSuccess(response.body().getUsers());
                    else
                        callback.onFailure(new InstaError(response.code(), response.raw().message()));
                }

                @Override
                public void onFailure(Throwable t) {
                    callback.onFailure(error(t));
                }
            });

    }


    /**
     * Get information about a relationship to another user.
     *
     * @param userID   ID of the user whos relationship status with the authenticated user has to be
     *                 retrieved.
     * @param callback
     */
    public void getRelationship(String userID, final RelationCallback callback) {

        Call<RelationshipEntity> call = endpoint.getRelationship(userID, accessToken);

        if (!NetworkUtility.isNetworkConnected(context))
            callback.onFailure(noInternet());

        else if (accessToken == null)
            callback.onFailure(noAccessToken());

        else
            call.enqueue(new Callback<RelationshipEntity>() {
                @Override
                public void onResponse(Response<RelationshipEntity> response, Retrofit retrofit) {

                    if (response.isSuccess())
                        callback.onSuccess(response.body().getRelationship());
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
