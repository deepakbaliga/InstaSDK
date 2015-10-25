package com.deepakbaliga.instasdk.api;

import com.deepakbaliga.instasdk.entity.reponse.RelationshipEntity;
import com.deepakbaliga.instasdk.entity.reponse.UserList;
import com.deepakbaliga.instasdk.util.InstaConstants;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by deezdroid on 24/10/15.
 */
public interface RelationshipEndpoint {

    /**
     * Get the list of users this user follows.
     *
     * @param userID ID of the user whos follow list has to be retrieved. Can be self.
     * @param token  Access token of authenticated user
     * @return List of users and pagination
     */
    @GET(InstaConstants.Endpoint.GET_FOLLOWS)
    Call<UserList> getFollows(@Path(InstaConstants.USERID) String userID,
                              @Query(InstaConstants.ACCESSTOKEN) String token);

    /**
     * Get the list of users this user follows.
     *
     * @param userID ID of the user whos follow list has to be retrieved. Can be self.
     * @param token  Access token of authenticated user
     * @return List of users and pagination
     */
    @GET(InstaConstants.Endpoint.GET_FOLLOWED_BY)
    Call<UserList> getFollowedBy(@Path(InstaConstants.USERID) String userID,
                                 @Query(InstaConstants.ACCESSTOKEN) String token);


    /**
     * List the users who have requested authenticated users permission to follow.
     *
     * @param token Access token of authenticated user
     * @return List of users and pagination
     */
    @GET(InstaConstants.Endpoint.GET_REQUESTED_BY)
    Call<UserList> getFollowRequests(@Query(InstaConstants.ACCESSTOKEN) String token);


    /**
     * Get information about a relationship to another user.
     *
     * @param userID ID of the user whos relationship status with the authenticated user has to be
     *               retrieved.
     * @param token  Access token of authenticated user
     * @return Relation is returned
     */
    @GET(InstaConstants.Endpoint.GET_RELATIONSHIP)
    Call<RelationshipEntity> getRelationship(@Path(InstaConstants.USERID) String userID,
                                             @Query(InstaConstants.ACCESSTOKEN) String token);
}
