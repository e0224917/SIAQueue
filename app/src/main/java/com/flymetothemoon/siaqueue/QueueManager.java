package com.flymetothemoon.siaqueue;

/**
 * Created by nhatton on 10/24/17.
 */

public class QueueManager {

    private static QueueManager sInstance;
    private String mCustomerTitle;
    private String mCustomerName;
    private String mKrisFlyerName;
    private String mPNR;

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

    public String getPNR() {
        return mPNR;
    }

    public void setPNR(String mPNR) {
        this.mPNR = mPNR;
    }

    public String getGreeting() {
        return "Good morning " + mCustomerTitle + " " + mCustomerName + "." + " Please select category of your concern.";
    }

}
