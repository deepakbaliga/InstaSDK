package com.deepakbaliga.instasdk;

import android.content.Context;

import com.deepakbaliga.instasdk.api.UserEndpoint;
import com.deepakbaliga.instasdk.callback.FeedsCallback;
import com.deepakbaliga.instasdk.callback.UserCallback;
import com.deepakbaliga.instasdk.callback.UsersCallback;
import com.deepakbaliga.instasdk.entity.model.InstaError;
import com.deepakbaliga.instasdk.entity.reponse.FeedResponse;
import com.deepakbaliga.instasdk.entity.reponse.UserList;
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
 * Created by deezdroid on 26/10/15.
 */
public class InstaUser {

    private Context context;
    private String accessToken;
    private Retrofit retrofit;


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
     * Get basic information about a user or authenticated user
     *
     * @param userID   the ID of the user. To get information about the owner of
     *                 the access token pass InstaConstants.SELF instead of userID.
     * @param callback
     */
    public void getUser(String userID, final UserCallback callback) {

        final Call<UserResponse> call = endpoint.getUser(userID, accessToken);

        if (!NetworkUtility.isNetworkConnected(context))
            callback.onFailure(noInternet());

        else if (accessToken == null)
            callback.onFailure(noAccessToken());

        else
            call.enqueue(new Callback<UserResponse>() {
                @Override
                public void onResponse(Response<UserResponse> response, Retrofit retrofit) {
                    if (response.isSuccess())
                        callback.onSuccess(response.body().getUser());
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
     * Retrieve the authenticated user's feed.
     *
     * @param callback
     */
    public void getFeeds(final FeedsCallback callback) {

        final Call<FeedResponse> call = endpoint.getFeeds(accessToken);

        if (!NetworkUtility.isNetworkConnected(context))
            callback.onFailure(noInternet());

        else if (accessToken == null)
            callback.onFailure(noAccessToken());

        else
            call.enqueue(new Callback<FeedResponse>() {
                @Override
                public void onResponse(Response<FeedResponse> response, Retrofit retrofit) {
                    if (response.isSuccess())
                        callback.onSuccess(response.body().getFeeds());
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
     * Retrieve the authenticated user's feed.
     *
     * @param count    Count of feeds to return
     * @param callback
     */
    public void getFeeds(int count, final FeedsCallback callback) {

        final Call<FeedResponse> call = endpoint.getFeeds(count, accessToken);

        if (!NetworkUtility.isNetworkConnected(context))
            callback.onFailure(noInternet());

        else if (accessToken == null)
            callback.onFailure(noAccessToken());

        else
            call.enqueue(new Callback<FeedResponse>() {
                @Override
                public void onResponse(Response<FeedResponse> response, Retrofit retrofit) {
                    if (response.isSuccess())
                        callback.onSuccess(response.body().getFeeds());
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
     * Retrieve the authenticated user's feed.
     *
     * @param count    Count of feeds to return
     * @param minID    Return media later than this minID.
     * @param maxID    Return media earlier than this maxID.
     * @param callback minID and maxID fields can be null.
     */
    public void getFeeds(int count, String minID, String maxID, final FeedsCallback callback) {

        final Call<FeedResponse> call = endpoint.getFeeds(count, minID, maxID, accessToken);

        if (!NetworkUtility.isNetworkConnected(context))
            callback.onFailure(noInternet());

        else if (accessToken == null)
            callback.onFailure(noAccessToken());

        else
            call.enqueue(new Callback<FeedResponse>() {
                @Override
                public void onResponse(Response<FeedResponse> response, Retrofit retrofit) {
                    if (response.isSuccess())
                        callback.onSuccess(response.body().getFeeds());
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
     * Get the most recent media published by a user. To get the most recent media published by
     * the owner of the access token, you can use self instead of the user-id.
     *
     * @param userID   the ID of the user. To get recent media published by the owner of
     *                 the access token pass InstaConstants.SELF instead of userID.
     * @param callback
     */
    public void getRecentMedia(String userID, final FeedsCallback callback) {

        final Call<FeedResponse> call = endpoint.getRecentMedia(userID, accessToken);

        if (!NetworkUtility.isNetworkConnected(context))
            callback.onFailure(noInternet());

        else if (accessToken == null)
            callback.onFailure(noAccessToken());

        else
            call.enqueue(new Callback<FeedResponse>() {
                @Override
                public void onResponse(Response<FeedResponse> response, Retrofit retrofit) {
                    if (response.isSuccess())
                        callback.onSuccess(response.body().getFeeds());
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
     * Get the most recent media published by a user. To get the most recent media published by
     * the owner of the access token, you can use self instead of the user-id.
     *
     * @param userID   the ID of the user. To get recent media published by the owner of
     *                 the access token pass InstaConstants.SELF instead of userID.
     * @param count    Number of media to return
     * @param callback
     */
    public void getRecentMedia(String userID, int count, final FeedsCallback callback) {

        final Call<FeedResponse> call = endpoint.getRecentMedia(userID, count, accessToken);

        if (!NetworkUtility.isNetworkConnected(context))
            callback.onFailure(noInternet());

        else if (accessToken == null)
            callback.onFailure(noAccessToken());

        else
            call.enqueue(new Callback<FeedResponse>() {
                @Override
                public void onResponse(Response<FeedResponse> response, Retrofit retrofit) {
                    if (response.isSuccess())
                        callback.onSuccess(response.body().getFeeds());
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
     * Get the most recent media published by a user. To get the most recent media published by
     * the owner of the access token, you can use self instead of the user-id.
     *
     * @param userID   the ID of the user. To get recent media published by the owner of
     *                 the access token pass InstaConstants.SELF instead of userID.
     * @param count    Number of media to return
     * @param minID    Return media later than this minID.
     * @param maxID    Return media earlier than this maxID.
     * @param callback
     */
    public void getRecentMedia(String userID, int count, String minID, String maxID, final FeedsCallback callback) {

        final Call<FeedResponse> call = endpoint.getRecentMedia(userID, count, minID, maxID, accessToken);

        if (!NetworkUtility.isNetworkConnected(context))
            callback.onFailure(noInternet());

        else if (accessToken == null)
            callback.onFailure(noAccessToken());

        else
            call.enqueue(new Callback<FeedResponse>() {
                @Override
                public void onResponse(Response<FeedResponse> response, Retrofit retrofit) {
                    if (response.isSuccess())
                        callback.onSuccess(response.body().getFeeds());
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
     * Get the most recent media published by a user. To get the most recent media published by
     * the owner of the access token, you can use self instead of the user-id.
     *
     * @param userID       the ID of the user. To get recent media published by the owner of
     *                     the access token pass InstaConstants.SELF instead of userID.
     * @param count        Number of media to return
     * @param minTimeStamp Return media after this UNIX timestamp.
     * @param maxTimeStamp Return media before this UNIX timestamp.
     * @param callback
     */
    public void getRecentMedia(String userID, int count, long minTimeStamp, long maxTimeStamp, final FeedsCallback callback) {

        final Call<FeedResponse> call = endpoint.getRecentMedia(userID, count, minTimeStamp, maxTimeStamp, accessToken);

        if (!NetworkUtility.isNetworkConnected(context))
            callback.onFailure(noInternet());

        else if (accessToken == null)
            callback.onFailure(noAccessToken());

        else
            call.enqueue(new Callback<FeedResponse>() {
                @Override
                public void onResponse(Response<FeedResponse> response, Retrofit retrofit) {
                    if (response.isSuccess())
                        callback.onSuccess(response.body().getFeeds());
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
     * Get the list of media liked by the authenticated user. Private media is returned as long as
     * the authenticated user has permission to view that media.
     *
     * @param count    Number of media to return
     * @param callback
     */
    public void getLikedMedia(int count, final FeedsCallback callback) {

        final Call<FeedResponse> call = endpoint.getLikedMedia(count, accessToken);

        if (!NetworkUtility.isNetworkConnected(context))
            callback.onFailure(noInternet());

        else if (accessToken == null)
            callback.onFailure(noAccessToken());

        else
            call.enqueue(new Callback<FeedResponse>() {
                @Override
                public void onResponse(Response<FeedResponse> response, Retrofit retrofit) {
                    if (response.isSuccess())
                        callback.onSuccess(response.body().getFeeds());
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
     * Search for a user by name.
     *
     * @param query    A query string.
     * @param callback
     */
    public void searchUser(String query, final UsersCallback callback) {

        final Call<UserList> call = endpoint.searchUser(query, accessToken);

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

                }
            });
    }

    /**
     * Search for a user by name.
     *
     * @param query    A query string.
     * @param callback
     */
    public void searchUser(String query, int count, final UsersCallback callback) {

        final Call<UserList> call = endpoint.searchUser(query, count, accessToken);

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

                }
            });
    }




}
