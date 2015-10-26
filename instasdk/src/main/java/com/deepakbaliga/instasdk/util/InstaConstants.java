package com.deepakbaliga.instasdk.util;

/**
 * Created by deezdroid on 24/10/15.
 */
public class InstaConstants {
    public static final String NO_INTERNET_CONNECTION = "Not connected to internet";

    public static final String INSTA_BASE_URL = "https://api.instagram.com/v1/";


    public static final String ACCESSTOKEN = "access_token";
    public static final String ACCESS_TOKEN_MESSAGE = "Access Token is not set. Please Authenticate";
    public static final String USERID = "user-id";
    public static final String COUNT = "count";
    public static final String MIN_ID = "min_id";
    public static final String MAX_ID = "max_id";
    public static final String MAX_TIMESTAMP = "max_timestamp";
    public static final String MIN_TIMESTAMP = "min_timestamp";
    public static final String MAX_LIKE_ID = "max_like_id";
    public static final String QUERY = "q";

    public static final String MEDIA_ID = "media-id";

    public static final String LATITUDE = "lat";
    public static final String LONGITUDE = "lng";
    public static final String DISTANCE = "distance";

    public static final String TAG_NAME = "tag-name";

    public static final String LOCATION_ID = "location-id";


    public static class Endpoint {

        public static final String GET_USER = "users/{user-id}";
        public static final String GET_FEEDS = "users/self/feed";
        public static final String GET_RECENT_MEDIA = "users/{user-id}/media/recent";
        public static final String GET_LIKED_MEDIA = "users/self/media/liked";
        public static final String SEARCH_USER = "users/search";


        public static final String GET_FOLLOWS = "users/{user-id}/follows";
        public static final String GET_FOLLOWED_BY = "users/{user-id}/followed-by";
        public static final String GET_REQUESTED_BY = "users/self/requested-by";
        public static final String GET_RELATIONSHIP = "users/{user-id}/relationship";


        public static final String GET_MEDIA_DETAILS = "media/{media-id}";
        public static final String SEARCH_BY_LOCATION = "media/search";
        public static final String GET_POPULAR = "media/popular";


        public static final String GET_COMMENTS = "media/{media-id}/comments";


        public static final String GET_LIKES = "media/{media-id}/likes";


        public static final String GET_TAG_DETAILS = "tags/{tag-name}";
        public static final String GET_RECENT_MEDIA_WITH_TAG = "tags/{tag-name}/media/recent";
        public static final String SEARCH_TAG = "tags/search";

        public static final String GET_LOCATION_DETAILS = "locations/{location-id}";
        public static final String GET_RECENT_MEDIA_WITH_LOCATION = "locations/{location-id}/media/recent";
        public static final String SEARCH_LOCATION = "locations/search";


    }

}
