package com.deepakbaliga.instasdk.api;

import android.support.annotation.IntRange;

import com.deepakbaliga.instasdk.entity.reponse.FeedResponse;
import com.deepakbaliga.instasdk.entity.reponse.MediaReponse;
import com.deepakbaliga.instasdk.util.InstaConstants;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by deezdroid on 24/10/15.
 */
public interface MediaEndpoint {

    /**
     * Get information about a media object. The returned 'type' key will allow you to differentiate
     * between image and video media.
     * Note: if you authenticate with an OAuth Token, you will receive the 'user_has_liked key' which
     * quickly tells you whether the current user has liked this media item.
     *
     * @param mediaID ID of the media for which the details have to be retrieved
     * @param token   Access token of the authenticated user
     * @return Details of a feed
     */
    @GET(InstaConstants.Endpoint.GET_MEDIA_DETAILS)
    Call<MediaReponse> getMediaDetails(@Path(InstaConstants.MEDIA_ID) String mediaID,
                                       @Query(InstaConstants.ACCESSTOKEN) String token);


    /**
     * Search for media in a given area. The default time span is set to 5 days
     * Can return mix of image and video types.
     *
     * @param latitude  Latitude of the center search coordinate. If used, longitude is required.
     * @param longitude Longitude of the center search coordinate. If used, latitude is required.
     * @param distance  Default is 1km , max distance is 5km. //TODO make sure to multiple int values by 1000 for this param in public api later
     * @param token     Access token of the authenticated user
     * @return List of feeds and pagination
     */
    @GET(InstaConstants.Endpoint.SEARCH_BY_LOCATION)
    Call<FeedResponse> searchMediaByLocation(@Query(InstaConstants.LATITUDE) double latitude,
                                             @Query(InstaConstants.LONGITUDE) double longitude,
                                             @IntRange(from = 1, to = 5)
                                             @Query(InstaConstants.DISTANCE) int distance,
                                             @Query(InstaConstants.ACCESSTOKEN) String token);


    /**
     * Get a list of what media is most popular at the moment. Can return mix of image and video types.
     *
     * @param token Access token of the authenticated user
     * @return list of feeds and pagination
     */
    @GET(InstaConstants.Endpoint.GET_POPULAR)
    Call<FeedResponse> getPopular(@Query(InstaConstants.ACCESSTOKEN) String token);

}
