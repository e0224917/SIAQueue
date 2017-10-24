package com.flymetothemoon.siaqueue.retrofit.model;

import java.util.List;

/**
 * Created by nhatton on 10/23/17.
 */

public class GetPassenger {

    private boolean partiallyCheckedIn;
    private String recordLocator;
    private List<Flight> flights;
    private List<Passenger> passengers;
    private List<Service> services;

    public boolean isPartiallyCheckedIn() {
        return partiallyCheckedIn;
    }

    public String getRecordLocator() {
        return recordLocator;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public List<Service> getServices() {
        return services;
    }
}
