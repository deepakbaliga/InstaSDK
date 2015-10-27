package com.deepakbaliga.instasdk.api;

import android.support.annotation.IntRange;

import com.deepakbaliga.instasdk.entity.reponse.FeedResponse;
import com.deepakbaliga.instasdk.entity.reponse.LocationEntity;
import com.deepakbaliga.instasdk.entity.reponse.Locations;
import com.deepakbaliga.instasdk.util.InstaConstants;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by deezdroid on 25/10/15.
 */
public interface LocationEndpoint {

    /**
     * Get information about a location.
     *
     * @param locationID ID of the location
     * @param token      Access token of authenticated user
     * @return Details about a location
     */
    @GET(InstaConstants.Endpoint.GET_LOCATION_DETAILS)
    Call<LocationEntity> getDetails(@Path(InstaConstants.LOCATION_ID) String locationID,
                                    @Query(InstaConstants.ACCESSTOKEN) String token);


    /**
     * Get a list of recent media objects from a given location.
     *
     * @param locationID ID of the location
     * @param token      Access token of authenticated user
     * @return list of feeds
     */
    @GET(InstaConstants.Endpoint.GET_RECENT_MEDIA_WITH_LOCATION)
    Call<FeedResponse> getRecentMediaWithTag(@Path(InstaConstants.LOCATION_ID) String locationID,
                                             @Query(InstaConstants.ACCESSTOKEN) String token);

    /**
     * Search for a location by geographic coordinate.
     *
     * @param latitude  Latitude of the center search coordinate. If used, longitude is required.
     * @param longitude Longitude of the center search coordinate. If used, latitude is required.
     * @param distance  Default is 1km , max distance is 5km. //TODO make sure to multiple int values by 1000 for this param in public api
     * @param token     Access token of the authenticated user
     * @return List of location
     */
    @GET(InstaConstants.Endpoint.SEARCH_LOCATION)
    Call<Locations> searchLocation(@Query(InstaConstants.LATITUDE) double latitude,
                                   @Query(InstaConstants.LONGITUDE) double longitude,
                                   @IntRange(from = 1, to = 5)
                                   @Query(InstaConstants.DISTANCE) int distance,
                                   @Query(InstaConstants.ACCESSTOKEN) String token);

}
