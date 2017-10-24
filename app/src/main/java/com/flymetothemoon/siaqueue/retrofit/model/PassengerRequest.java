package com.flymetothemoon.siaqueue.retrofit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by nhatton on 10/23/17.
 */

public class PassengerRequest {

    private Request request;
    private String clientUUID;

    public PassengerRequest(String pnr){
        this.request = new Request(pnr);
        this.clientUUID = "Test";
    }

    class Request {
        @SerializedName("pnr")
        @Expose
        private String pnr;

        public Request(String pnr){
            this.pnr = pnr;
        }

        public String getPnr() {
            return pnr;
        }

        public void setPnr(String pnr) {
            this.pnr = pnr;
        }
    }

}
