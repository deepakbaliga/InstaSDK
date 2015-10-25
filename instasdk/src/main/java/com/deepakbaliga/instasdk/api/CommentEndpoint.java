package com.deepakbaliga.instasdk.api;

import com.deepakbaliga.instasdk.entity.reponse.CommentsList;
import com.deepakbaliga.instasdk.util.InstaConstants;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by deezdroid on 24/10/15.
 */
public interface CommentEndpoint {


    /**
     * Get a list of recent comments on a media object.
     *
     * @param mediaID ID of the media for which the comments have to be retrieved
     * @param token   Access token of the authenticated user
     * @return Returns list of comments
     */
    @GET(InstaConstants.Endpoint.GET_COMMENTS)
    Call<CommentsList> getComments(@Path(InstaConstants.MEDIA_ID) String mediaID,
                                   @Query(InstaConstants.ACCESSTOKEN) String token);
}
