package com.deepakbaliga.instasdk.api;

import com.deepakbaliga.instasdk.entity.reponse.FeedResponse;
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
    @GET("users/{user-id}")
    public Call<UserResponse> getUser(@Path(InstaConstants.USERID) String userID,
                                      @Query(InstaConstants.ACCESSTOKEN) String token);


    /**
     * See the authenticated user's feed.
     *
     * @param token access token of authenticated user
     * @return Feeds and pagination information
     */
    @GET("/users/self/feed")
    public Call<FeedResponse> getFeeds(@Query(InstaConstants.ACCESSTOKEN) String token);


    @GET("/users/self/feed")
    public Call<FeedResponse> getFeeds(@Query(InstaConstants.COUNT) int count,
                                       @Query(InstaConstants.ACCESSTOKEN) String token);

    /**
     * See the authenticated user's feed.
     *
     * @param count Count of media to return.
     * @param minID Return media later than this min_id.
     * @param maxID Return media earlier than this max_id.s
     * @param token access token of authenticated user
     * @return Feeds and pagination information
     */
    @GET("/users/self/feed")
    public Call<FeedResponse> getFeeds(@Query(InstaConstants.COUNT) int count,
                                       @Query(InstaConstants.MIN_ID) String minID,
                                       @Query(InstaConstants.MAX_ID) String maxID,
                                       @Query(InstaConstants.ACCESSTOKEN) String token);


}
