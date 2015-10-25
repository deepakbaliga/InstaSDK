package com.deepakbaliga.instasdk.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by deezdroid on 24/10/15.
 * InstaPreference is a wrapper for Shared Preferences
 */

/**
 *
 */
public class InstaPreference {

    static InstaPreference singleton = null;

    static SharedPreferences preferences;

    static SharedPreferences.Editor editor;

    InstaPreference(Context context) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = preferences.edit();
    }

    InstaPreference(Context context, String name, int mode) {
        preferences = context.getSharedPreferences(name, mode);
        editor = preferences.edit();
    }

    public static InstaPreference with(Context context) {
        if (singleton == null) {
            singleton = new Builder(context, null, -1).build();
        }
        return singleton;
    }

    public static InstaPreference with(Context context, String name, int mode) {
        if (singleton == null) {
            singleton = new Builder(context, name, mode).build();
        }
        return singleton;
    }

    public void put(String key, String value) {
        editor.putString(key, value).apply();
    }


    public void clear(String key) {
        editor.remove(key).apply();
    }

    public void clearAll(){
        editor.clear().apply();
    }

    private static class Builder {

        private final Context context;
        private final int mode;
        private final String name;

        public Builder(Context context, String name, int mode) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null");
            }
            this.context = context.getApplicationContext();
            this.name = name;
            this.mode = mode;
        }


        public InstaPreference build() {
            if (mode == -1 || name == null) {
                return new InstaPreference(context);
            }
            return new InstaPreference(context, name, mode);
        }
    }
}