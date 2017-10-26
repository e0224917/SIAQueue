package com.flymetothemoon.siaqueue;

import android.app.Application;
import android.content.Context;

/**
 * Created by nhatton on 10/25/17.
 */

public class SIAQueueApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        QueueManager.getInstance().initPolly(this);
    }
}
