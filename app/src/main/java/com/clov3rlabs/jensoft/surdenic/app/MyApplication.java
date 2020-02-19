package com.clov3rlabs.jensoft.surdenic.app;

import android.app.Application;

import com.clov3rlabs.jensoft.surdenic.db.DatabaseManager;

/**
 * Created by rsaavedra on 26/7/2018.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate(){
        super.onCreate();
        DatabaseManager.init(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        DatabaseManager.destroy();
    }

}
