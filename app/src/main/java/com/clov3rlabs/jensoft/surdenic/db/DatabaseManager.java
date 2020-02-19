package com.clov3rlabs.jensoft.surdenic.db;


import android.content.Context;

import com.j256.ormlite.android.apptools.OpenHelperManager;

/**
 * Created by rsaavedra on 26/7/2018.
 */

public class DatabaseManager {

    static private DatabaseManager instance;

    static public void init(Context ctx) {
        if (null==instance) {
            instance = new DatabaseManager(ctx);
        }
    }

    static public void destroy(){
        if (null!=instance){
            OpenHelperManager.releaseHelper();
            instance = null;
        }
    }

    static public DatabaseManager getInstance() {
        return instance;
    }

    private DatabaseHelper helper;
    private DatabaseManager(Context ctx) {
        helper = new DatabaseHelper(ctx);
    }

    public DatabaseHelper getHelper() {
        return helper;
    }

}
