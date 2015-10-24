package com.deepakbaliga.instasdk.authentication;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.deepakbaliga.instasdk.R;
import com.deepakbaliga.instasdk.util.InstaConstants;
import com.deepakbaliga.instasdk.util.InstaPreference;
import com.deepakbaliga.instasdk.util.NetworkUtility;

/**
 * Created by deezdroid on 24/10/15.
 */
public class InstaAuthentication extends Dialog {

    private WebView loginWebView;
    private ProgressBar progressBar;
    private OnAuthentication authentication;
    private String dialogTitle = "Login With Instagram";

    public InstaAuthentication(Context context) {
        super(context);
        initializeViews();
    }

    public InstaAuthentication(Context context, int themeResId) {
        super(context, themeResId);
        initializeViews();
    }

    protected InstaAuthentication(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        initializeViews();
    }

    /**
     * Sets title of the authentication dialog
     * @param dialogTitle title to be set
     */
    public void setDialogTitle(String dialogTitle) {
        this.dialogTitle = dialogTitle;
    }

    /**
     *
     * @param clientID obtained during creating an application on http://instagram.com/developers
     * @param redirectURL Redirect URL provided for this application
     * @param onAuthentication Callback returning accessToken or error message
     */
    public void begin(String clientID, String redirectURL, OnAuthentication onAuthentication){

        this.authentication = onAuthentication;



        loginWebView.loadUrl( getAuthURL(clientID, redirectURL));
        loginWebView.setWebViewClient(new WebViewClient() {

            boolean authComplete = false;


            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);

                if(!NetworkUtility.isNetworkConnected(getContext())){
                    authentication.failure(InstaConstants.NO_INTERNET_CONNECTION);
                }

                else if (url.contains("#access_token=") && !authComplete) {


                    String accessToken[] = url.split("access_token=");
                    authComplete = true;

                    authentication.success(accessToken[1]);

                    InstaPreference.with(getContext()).put(InstaConstants.ACCESSTOKEN, accessToken[1]);

                    InstaAuthentication.super.dismiss();

                }

                if(url.contains("error")){
                    Uri uri = Uri.parse(url);
                    authentication.failure(uri.getQueryParameter("error_description"));
                    InstaAuthentication.super.dismiss();
                }

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                authentication.failure("Something went wrong");

                InstaAuthentication.super.dismiss();


            }


        });

        this.show();
        this.setTitle(dialogTitle);
    }

    private void initializeViews(){

        super.setContentView(R.layout.insta_auth_dilog);
        progressBar = (ProgressBar) findViewById(R.id.progress);
        loginWebView = (WebView) findViewById(R.id.insta_login_webview);
        loginWebView.getSettings().setJavaScriptEnabled(true);

    }



    private String getAuthURL(String clientID, String redirectURL){
        return "https://instagram.com/oauth/authorize/?client_id="+clientID
                +"&redirect_uri="+redirectURL+"&response_type=token&" +
                "scope=likes+comments+basic+relationships";
    }

}
