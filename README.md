# InstaSDK 
### Still Under Development

An Instagram SDK for android that helps developers intergrate Instagram Authentication 
and use Instagram APIs asynchronously. InstaSDK for android uses the public Instagram API and is not affiliated with either Instagram, Inc. or Facebook, Inc.


Download
--------

Grab via Gradle:
```groovy
compile 'com.deepakbaliga....'
```

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

Authentication is as simple as 

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
 Once user authentication is successful the library takes care of access token and you just need to call the required methods.
 
##### InstaUser
##### InstaMedia
##### InstaRelationship
##### InstaComment
##### InstaLike
##### InstaLocation
##### InstaTag
    
 
 








