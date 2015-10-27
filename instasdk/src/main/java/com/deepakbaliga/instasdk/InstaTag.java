package com.deepakbaliga.instasdk;

import android.content.Context;

import com.deepakbaliga.instasdk.api.LikeEndpoint;
import com.deepakbaliga.instasdk.api.TagEndpoint;
import com.deepakbaliga.instasdk.callback.FeedsCallback;
import com.deepakbaliga.instasdk.callback.LikesCallback;
import com.deepakbaliga.instasdk.callback.TagCallback;
import com.deepakbaliga.instasdk.callback.TagsCallback;
import com.deepakbaliga.instasdk.entity.model.InstaError;
import com.deepakbaliga.instasdk.entity.model.LikesEntity;
import com.deepakbaliga.instasdk.entity.reponse.FeedResponse;
import com.deepakbaliga.instasdk.entity.reponse.TagList;
import com.deepakbaliga.instasdk.entity.reponse.TagResponse;
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
public class InstaTag {

    private Context context;
    private String accessToken;
    private Retrofit retrofit;

    //API
    private TagEndpoint endpoint;

    public InstaTag(Context context) {
        this.context = context;
        accessToken = InstaPreference.with(context).get(InstaConstants.ACCESSTOKEN, null);

        retrofit = new Retrofit.Builder().baseUrl(InstaConstants.INSTA_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        endpoint = retrofit.create(TagEndpoint.class);
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
     * Get information about a tag object.
     *
     * @param tagName  name of the tag
     * @param callback
     */
    public void getTagDetails(String tagName, final TagCallback callback) {

        final Call<TagResponse> call = endpoint.getTagDetails(tagName, accessToken);

        if (!NetworkUtility.isNetworkConnected(context))
            callback.onFailure(noInternet());

        else if (accessToken == null)
            callback.onFailure(noAccessToken());

        else
            call.enqueue(new Callback<TagResponse>() {
                @Override
                public void onResponse(Response<TagResponse> response, Retrofit retrofit) {
                    if (response.isSuccess())
                        callback.onSuccess(response.body().getTag());
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
     * Get a list of recently tagged media.
     *
     * @param tagName  name of the tag
     * @param count
     * @param callback
     */
    public void getRecentMediaWithTag(String tagName, int count, final FeedsCallback callback) {

        final Call<FeedResponse> call = endpoint.getRecentMediaWithTag(tagName, count, accessToken);

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
     * Search for tags by name.
     *
     * @param query    A valid tag name without a leading #. (eg. snowy, nofilter)
     * @param callback
     */
    public void searchTags(String query, final TagsCallback callback) {

        Call<TagList> call = endpoint.searchTags(query, accessToken);

        if (!NetworkUtility.isNetworkConnected(context))
            callback.onFailure(noInternet());

        else if (accessToken == null)
            callback.onFailure(noAccessToken());

        else
            call.enqueue(new Callback<TagList>() {
                @Override
                public void onResponse(Response<TagList> response, Retrofit retrofit) {
                    if (response.isSuccess())
                        callback.onSuccess(response.body().getTags());
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
