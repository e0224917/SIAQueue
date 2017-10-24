package com.flymetothemoon.siaqueue.retrofit.model;

/**
 * Created by nhatton on 10/23/17.
 */

public class FTResponse<T> {

    private String status;
    private int code;
    private String message;
    private T response;

}
