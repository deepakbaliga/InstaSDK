package com.deepakbaliga.instasdk.api;

import com.deepakbaliga.instasdk.entity.reponse.FeedResponse;
import com.deepakbaliga.instasdk.entity.reponse.TagList;
import com.deepakbaliga.instasdk.entity.reponse.TagResponse;
import com.deepakbaliga.instasdk.util.InstaConstants;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by deezdroid on 24/10/15.
 */
public interface TagEndpoint {

    /**
     * Get information about a tag object.
     *
     * @param tagName name of the tag
     * @param token   Access token of the authenticated user
     * @return information about the #tag
     */
    @GET(InstaConstants.Endpoint.GET_TAG_DETAILS)
    Call<TagResponse> getTagDetails(@Path(InstaConstants.TAG_NAME) String tagName,
                                    @Query(InstaConstants.ACCESSTOKEN) String token);


    /**
     * Get a list of recently tagged media.
     *
     * @param tagName name of the tag
     * @param count
     * @param token   Access token of the authenticated user
     * @return list of recent media associated with this tag
     */
    @GET(InstaConstants.Endpoint.GET_RECENT_MEDIA_WITH_TAG)
    Call<FeedResponse> getRecentMediaWithTag(@Path(InstaConstants.TAG_NAME) String tagName,
                                             @Path(InstaConstants.COUNT) int count,
                                             @Query(InstaConstants.ACCESSTOKEN) String token);

    /**
     * Search for tags by name.
     *
     * @param query A valid tag name without a leading #. (eg. snowy, nofilter)
     * @param token Access token of the authenticated user
     * @return list of tags
     */
    @GET(InstaConstants.Endpoint.SEARCH_TAG)
    Call<TagList> searchTags(@Query(InstaConstants.QUERY) String query,
                             @Query(InstaConstants.ACCESSTOKEN) String token);

}
