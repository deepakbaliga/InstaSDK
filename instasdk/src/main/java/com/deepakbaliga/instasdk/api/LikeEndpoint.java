package com.deepakbaliga.instasdk.api;

import com.deepakbaliga.instasdk.entity.model.LikesEntity;
import com.deepakbaliga.instasdk.entity.reponse.CommentsList;
import com.deepakbaliga.instasdk.util.InstaConstants;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by deezdroid on 24/10/15.
 */
public interface LikeEndpoint {

    /**
     * Get a list of users who have liked this media.
     *
     * @param mediaID ID of the media for list of users who like this media have to be retrieved
     * @param token   Access token of the authenticated user
     * @return Returns list of users
     */
    @GET(InstaConstants.Endpoint.GET_LIKES)
    Call<LikesEntity> getLikes(@Path(InstaConstants.MEDIA_ID) String mediaID,
                                @Query(InstaConstants.ACCESSTOKEN) String token);
}
