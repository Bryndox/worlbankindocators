package com.ubunifuconcepts.wbdatacatalog.observer;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import com.ubunifuconcepts.wbdatacatalog.constant.Constants;
import com.ubunifuconcepts.wbdatacatalog.loader.CatalogLoader;


public class Observer extends BroadcastReceiver {

    private CatalogLoader mLoader;
    private IntentFilter intentFilter;

    public Observer(String action) {
        intentFilter = new IntentFilter();
        intentFilter.addAction(action);
    }

    //Catalog Loader Constructor
    public Observer(CatalogLoader loader) {
        //call empty constructor
        this(Constants.BroadcastReceiver.Actions.CATALOG_CHANGED);

        mLoader = loader;
        mLoader.getContext().registerReceiver(this, intentFilter);
    }


    @Override
    public void onReceive(Context context, Intent intent) {
        //Handle catalog change broadcast
        if (intent.getAction().equals(Constants.BroadcastReceiver.Actions.CATALOG_CHANGED)) {
            mLoader.onContentChanged();
        }
    }
}
