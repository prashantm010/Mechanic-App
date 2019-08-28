package com.example.prashantmaheshwari.firstapp;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by prashant maheshwari on 27-02-2018.
 */

public class FireApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Firebase.setAndroidContext(this);

    }
}
