package com.deepakbaliga.instasdk;

import android.content.Context;
import android.support.annotation.IntRange;

import com.deepakbaliga.instasdk.api.LocationEndpoint;
import com.deepakbaliga.instasdk.api.RelationshipEndpoint;
import com.deepakbaliga.instasdk.callback.FeedsCallback;
import com.deepakbaliga.instasdk.callback.LocationCallback;
import com.deepakbaliga.instasdk.callback.LocationsCallback;
import com.deepakbaliga.instasdk.callback.RelationCallback;
import com.deepakbaliga.instasdk.callback.UsersCallback;
import com.deepakbaliga.instasdk.entity.model.InstaError;
import com.deepakbaliga.instasdk.entity.reponse.FeedResponse;
import com.deepakbaliga.instasdk.entity.reponse.LocationEntity;
import com.deepakbaliga.instasdk.entity.reponse.Locations;
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
public class InstaLocation {

    private Context context;
    private String accessToken;
    private Retrofit retrofit;

    //API
    private LocationEndpoint endpoint;

    public InstaLocation(Context context) {
        this.context = context;
        accessToken = InstaPreference.with(context).get(InstaConstants.ACCESSTOKEN, null);

        retrofit = new Retrofit.Builder().baseUrl(InstaConstants.INSTA_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        endpoint = retrofit.create(LocationEndpoint.class);
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
     * Get information about a location.
     *
     * @param locationID ID of the location
     * @param callback
     */
    public void getDetails(String locationID, final LocationCallback callback) {

        Call<LocationEntity> call = endpoint.getDetails(locationID, accessToken);

        if (!NetworkUtility.isNetworkConnected(context))
            callback.onFailure(noInternet());

        else if (accessToken == null)
            callback.onFailure(noAccessToken());

        else

            call.enqueue(new Callback<LocationEntity>() {
                @Override
                public void onResponse(Response<LocationEntity> response, Retrofit retrofit) {
                    if (response.isSuccess())
                        callback.onSuccess(response.body().getLocation());
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
     * Get a list of recent media objects from a given location.
     *
     * @param locationID ID of the location
     * @param callback
     */
    public void getRecentMediaWithTag(String locationID, final FeedsCallback callback) {
        Call<FeedResponse> call = endpoint.getRecentMediaWithTag(locationID, accessToken);

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
     * Search for a location by geographic coordinate.
     *
     * @param latitude  Latitude of the center search coordinate. If used, longitude is required.
     * @param longitude Longitude of the center search coordinate. If used, latitude is required.
     * @param distance  Default is 1km , max distance is 5km.
     * @param callback
     */
    public void searchLocation(double latitude, double longitude, @IntRange(from = 1, to = 5) int distance,
                               final LocationsCallback callback) {

        Call<Locations> call = endpoint.searchLocation(latitude, longitude, distance, accessToken);

        if (!NetworkUtility.isNetworkConnected(context))
            callback.onFailure(noInternet());

        else if (accessToken == null)
            callback.onFailure(noAccessToken());

        else

            call.enqueue(new Callback<Locations>() {
                @Override
                public void onResponse(Response<Locations> response, Retrofit retrofit) {
                    if (response.isSuccess())
                        callback.onSuccess(response.body().getLocations());
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
