package com.deepakbaliga.instasdk.view;


import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

import com.deepakbaliga.instasdk.R;

/**
 * This button contains instagram logo and text.
 * To be used in xml layouts
 * Created by deezdroid on 24/10/15.
 */

public class InstaLoginButton extends Button {

    public InstaLoginButton(Context context) {
        super(context);
        init();
    }

    public InstaLoginButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public InstaLoginButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    private void init() {
        if (isInEditMode()) {
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.mipmap.insta_logo), null, null, null);
        setBackgroundResource(R.drawable.instagram_button);
        setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
        setPadding(8, 8, 8, 8);
        setTextColor(getResources().getColor(R.color.white));
    }

}
