package com.panatlanticdev.clubnauticogt;

/**
 * Created by acifuina on 24/11/15.
 */


import android.app.Application;

import com.parse.Parse;
import com.parse.ParseInstallation;


public class UserInfo extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, "2KGnOZNHgPYNqWm2dUXyRQA88hpih4A0M21ufzoS", "TgnpJbNpIu7vUiJBpaMphtGKdxVdBmyFpKVqscuj");
        ParseInstallation.getCurrentInstallation().saveInBackground();
    }
}
