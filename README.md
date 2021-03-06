# InstaSDK 
### Still Under Development

An Instagram SDK for android that helps developers intergrate Instagram Authentication 
and use Instagram APIs asynchronously. InstaSDK for android uses the public Instagram API and is not affiliated with either Instagram, Inc. or Facebook, Inc.




Permissions
-----
Add the following permissions to your Android manifest file.

```
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
```


Authentication
-----

Instagram API uses the OAuth2 protocol for authentication, which is handled by the InstaSDK.

##### Obtaining Developer Keys

You will need to register in the instagram <a href="https://instagram.com/developer/register/" target="_blank">developer site</a> and obtain a Client ID, and Redirect URI for your client in order to authenticate and use the different operations in this library.

##### Authenticating a user

 Once user authentication is successful the library takes care of access token and you just need to call the required methods. Authentication is as simple as 

````
    InstaAuthentication authentication = new InstaAuthentication(this);
    
    authentication.begin(YOUR_CLIENT_ID, YOUR_REDIRECT_URL, new OnAuthentication(){
      @Override
      public void success(String accessToken){
        
      }
      
      @Override
      public void failure(String message){
      
      }
    });
````
API Methods
-----
All methods are asynchronously. So no AsyncTask blah blah blah.. 
 
##### InstaUser
* ````getUser(String userID, UserCallback callback) ````
    Get basic information about a user or authenticated user. To get information about the authenticated user pass               ````InstaConstants.SELF```` instead of userID.

* ````getFeeds(FeedsCallback callback)````
    Retrieve the authenticated user's feed. 

* ````getRecentMedia(String userID, FeedsCallback callback)````
    Get the most recent media published by a user. To get the most recent media published by
    the owner of the access token, you may use ````InstaConstants.SELF```` instead of the userID.
    
* ````getLikedMedia(int count, FeedsCallback callback)````
    Get the list of media liked by the authenticated user. Private          media is returned as long as the authenticated user has permission to view that media.
    
* ````searchUser(String query, UsersCallback callback)````
    Search for a user by name.


##### InstaMedia
* ````getMediaDetails(String mediaID, MediaDetailsCallback callback)````
    Get information about a media object. The returned 'type' key will     allow you to differentiate between image and video media.
    
* ````searchMediaByLocation(double latitude, double longitude, int distance, final FeedsCallback callback)````
    Search for media in a given area. The default time span is set to 5 days. Can return mix of image and video types.           Latitude of the center search coordinate. If used, longitude is required. Longitude of the center search coordinate. If      used, latitude is required. Default is 1km , max distance is 5km.

###### InstaRelationship
###### InstaComment
###### InstaLike
###### InstaLocation
###### InstaTag
    
 








