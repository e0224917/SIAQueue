package com.flymetothemoon.siaqueue.retrofit.model;

/**
 * Created by nhatton on 10/23/17.
 */

public class PassengerRequest {

    private Request request;
    private String clientUUID;

    public PassengerRequest(String pnr) {
        this.request = new Request(pnr);
        this.clientUUID = "FlyMeToTheMoon";
    }

    private class Request {
        private String pnr;

        public Request(String pnr) {
            this.pnr = pnr;
        }
    }
}
