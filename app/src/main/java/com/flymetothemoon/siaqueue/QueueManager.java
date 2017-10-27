package com.flymetothemoon.siaqueue;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.util.Log;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.polly.AmazonPollyPresigningClient;
import com.amazonaws.services.polly.model.DescribeVoicesRequest;
import com.amazonaws.services.polly.model.DescribeVoicesResult;
import com.amazonaws.services.polly.model.OutputFormat;
import com.amazonaws.services.polly.model.SynthesizeSpeechPresignRequest;
import com.amazonaws.services.polly.model.Voice;
import com.flymetothemoon.siaqueue.model.User;

import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * Created by nhatton on 10/24/17.
 */

public class QueueManager {

    private static QueueManager sInstance;
    private String mCustomerTitle;
    private String mCustomerName;
    private String mKrisFlyerName;

    static {
        sInstance = new QueueManager();
    }

    private QueueManager() {

    }

    public static QueueManager getInstance() {
        return sInstance;
    }

    public String getCustomerTitle() {
        return mCustomerTitle;
    }

    public void setCustomerTitle(String mCustomerTitle) {
        this.mCustomerTitle = mCustomerTitle;
    }

    public String getCustomerName() {
        return mCustomerName;
    }

    public void setCustomerName(String mCustomerName) {
        this.mCustomerName = mCustomerName;
    }

    public String getKrisFlyerName() {
        return mKrisFlyerName;
    }

    public void setKrisFlyerName(String mKrisFlyerName) {
        this.mKrisFlyerName = mKrisFlyerName;
    }

    public String getGreeting() {
        return "Good morning " + mCustomerTitle + " " + mCustomerName + "." + " Please select category of your concern.";
    }

}
