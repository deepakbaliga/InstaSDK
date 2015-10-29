# _InstaSDK STILL UNDER DEVELOPMENT_ 

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
```
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
```


Authentication
-----

Instagram API uses the OAuth2 protocol for authentication, which is handled by the InstaSDK.

### Obtaining an access token

You will need to register in the instagram [developer site](https://instagram.com/developer/register/) and obtain app's Client ID, and Redirect URI in order to authenticate and use the operations in this library.

### Authenticating a user






