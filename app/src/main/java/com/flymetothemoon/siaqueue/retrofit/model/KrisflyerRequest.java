package com.flymetothemoon.siaqueue.retrofit.model;

/**
 * Created by nhatton on 10/24/17.
 */

public class KrisflyerRequest {

    private Request request;
    private String clientUUID;

    public KrisflyerRequest(String krisflyerNumber) {
        this.request = new Request(krisflyerNumber);
        this.clientUUID = "FlyMeToTheMoon";
    }

    private class Request {
        private String krisflyerNumber;

        public Request(String krisflyerNumber) {
            this.krisflyerNumber = krisflyerNumber;
        }
    }
}
