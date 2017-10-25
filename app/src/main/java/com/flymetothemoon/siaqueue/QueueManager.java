package com.flymetothemoon.siaqueue;

import android.util.Log;

import com.flymetothemoon.siaqueue.model.User;
import com.flymetothemoon.siaqueue.retrofit.SIAClient;
import com.flymetothemoon.siaqueue.retrofit.model.FTResponse;
import com.flymetothemoon.siaqueue.retrofit.model.GetProfile;
import com.flymetothemoon.siaqueue.retrofit.model.KrisflyerRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by nhatton on 10/24/17.
 */

public class QueueManager {

    private static QueueManager sInstance;
    private User mUser;

    static {
        sInstance = new QueueManager();
    }

    private QueueManager() {

    }

    public static QueueManager getInstance() {
        return sInstance;
    }

    public void fetchUserFromKrisFlyerNumber(String krisFlyerNumber) {

    }

}
