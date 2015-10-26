package com.deepakbaliga.instasdk.api;

import com.deepakbaliga.instasdk.entity.reponse.FeedResponse;
import com.deepakbaliga.instasdk.entity.reponse.UserList;
import com.deepakbaliga.instasdk.entity.reponse.UserResponse;
import com.deepakbaliga.instasdk.util.InstaConstants;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by deezdroid on 24/10/15.
 */
public interface UserEndpoint {

    /**
     * Get basic information about a user. To get information about the owner of
     * the access token, you can use self instead of the user-id.
     *
     * @param userID the ID of the user or self
     * @return Information about the user
     */
    @GET(InstaConstants.Endpoint.GET_USER)
    Call<UserResponse> getUser(@Path(InstaConstants.USERID) String userID,
                               @Query(InstaConstants.ACCESSTOKEN) String token);


    /**
     * See the authenticated user's feed.
     *
     * @param token access token of authenticated user
     * @return Feeds and pagination information
     */
    @GET(InstaConstants.Endpoint.GET_FEEDS)
    Call<FeedResponse> getFeeds(@Query(InstaConstants.ACCESSTOKEN) String token);


    /**
     * See the authenticated user's feed.
     *
     * @param token access token of authenticated user
     * @param count Count of media to return.
     * @return Feeds and pagination information
     */
    @GET(InstaConstants.Endpoint.GET_FEEDS)
    Call<FeedResponse> getFeeds(@Query(InstaConstants.COUNT) int count,
                                @Query(InstaConstants.ACCESSTOKEN) String token);

    /**
     * See the authenticated user's feed.
     *
     * @param count Count of media to return.
     * @param minID Return media later than this min_id.
     * @param maxID Return media earlier than this max_id.
     * @param token access token of authenticated user
     * @return Feeds and pagination information
     */
    @GET(InstaConstants.Endpoint.GET_FEEDS)
    Call<FeedResponse> getFeeds(@Query(InstaConstants.COUNT) int count,
                                @Query(InstaConstants.MIN_ID) String minID,
                                @Query(InstaConstants.MAX_ID) String maxID,
                                @Query(InstaConstants.ACCESSTOKEN) String token);


    /**
     * Get the most recent media published by a user. To get the most recent media published by
     * the owner of the access token, you can use self instead of the user-id.
     *
     * @param userID the ID of the user or self
     * @param token  access token of authenticated user
     * @return Feeds and pagination information
     */
    @GET(InstaConstants.Endpoint.GET_RECENT_MEDIA)
    Call<FeedResponse> getRecentMedia(@Query(InstaConstants.USERID) String userID,
                                      @Query(InstaConstants.ACCESSTOKEN) String token);


    /**
     * Get the most recent media published by a user. To get the most recent media published by
     * the owner of the access token, you can use self instead of the user-id.
     *
     * @param userID the ID of the user or self
     * @param count  Count of media to return.
     * @param token  access token of authenticated user
     * @return Feeds and pagination information
     */
    @GET(InstaConstants.Endpoint.GET_RECENT_MEDIA)
    Call<FeedResponse> getRecentMedia(@Query(InstaConstants.USERID) String userID,
                                      @Query(InstaConstants.COUNT) int count,
                                      @Query(InstaConstants.ACCESSTOKEN) String token);

    /**
     * Get the most recent media published by a user. To get the most recent media published by
     * the owner of the access token, you can use self instead of the user-id.
     *
     * @param userID the ID of the user or self
     * @param count  Count of media to return.
     * @param minID  Return media later than this min_id.
     * @param maxID  Return media earlier than this max_id.
     * @param token  access token of authenticated user
     * @return Feeds and pagination information
     */
    @GET(InstaConstants.Endpoint.GET_RECENT_MEDIA)
    Call<FeedResponse> getRecentMedia(@Query(InstaConstants.USERID) String userID,
                                      @Query(InstaConstants.COUNT) int count,
                                      @Query(InstaConstants.MIN_ID) String minID,
                                      @Query(InstaConstants.MAX_ID) String maxID,
                                      @Query(InstaConstants.ACCESSTOKEN) String token);


    /**
     * Get the most recent media published by a user. To get the most recent media published by
     * the owner of the access token, you can use self instead of the user-id.
     *
     * @param userID       the ID of the user or self
     * @param count        Count of media to return.
     * @param minTimeStamp Return media after this UNIX timestamp.
     * @param maxTimeStamp Return media before this UNIX timestamp.
     * @param token        access token of authenticated user
     * @return Feeds and pagination information
     */
    @GET(InstaConstants.Endpoint.GET_RECENT_MEDIA)
    Call<FeedResponse> getRecentMedia(@Query(InstaConstants.USERID) String userID,
                                      @Query(InstaConstants.COUNT) int count,
                                      @Query(InstaConstants.MIN_TIMESTAMP) long minTimeStamp,
                                      @Query(InstaConstants.MAX_TIMESTAMP) long maxTimeStamp,
                                      @Query(InstaConstants.ACCESSTOKEN) String token);


    /**
     * Get the list of media liked by the authenticated user. Private media is returned as long as
     * the authenticated user has permission to view that media. Liked media lists are only available
     * for the currently authenticated user.
     *
     * @param count     Count of media to return.
     * @param token     access token of authenticated user
     * @return
     */
    @GET(InstaConstants.Endpoint.GET_LIKED_MEDIA)
    Call<FeedResponse> getLikedMedia(@Query(InstaConstants.COUNT) int count,
                                     @Query(InstaConstants.ACCESSTOKEN) String token);

    /**
     * Get the list of media liked by the authenticated user. Private media is returned as long as
     * the authenticated user has permission to view that media. Liked media lists are only available
     * for the currently authenticated user.
     *
     * @param count     Count of media to return.
     * @param maxLikeID Return media liked before this id.
     * @param token     access token of authenticated user
     * @return
     */
    @GET(InstaConstants.Endpoint.GET_LIKED_MEDIA)
    Call<FeedResponse> getLikedMedia(@Query(InstaConstants.COUNT) int count,
                                     @Query(InstaConstants.MAX_LIKE_ID) String maxLikeID,
                                     @Query(InstaConstants.ACCESSTOKEN) String token);

    /**
     * Search for a user by name.
     *
     * @param query A query string.
     * @param token access token of authenticated user
     * @return List of users
     */
    @GET(InstaConstants.Endpoint.GET_LIKED_MEDIA)
    Call<UserList> searchUser(@Query(InstaConstants.QUERY) String query,
                              @Query(InstaConstants.ACCESSTOKEN) String token);

    /**
     * Search for a user by name.
     *
     * @param query A query string.
     * @param count Number of users to return.
     * @param token access token of authenticated user
     * @return List of users
     */
    @GET(InstaConstants.Endpoint.SEARCH_USER)
    Call<UserList> searchUser(@Query(InstaConstants.QUERY) String query,
                              @Query(InstaConstants.COUNT) int count,
                              @Query(InstaConstants.ACCESSTOKEN) String token);


}
