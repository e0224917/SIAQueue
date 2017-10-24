package com.flymetothemoon.siaqueue.retrofit.model;

import java.util.List;

/**
 * Created by nhatton on 10/23/17.
 */

public class Flight {

    private List<String> flightIDs;
    private Place origin;
    private Place destination;
    private Airline operatingAirline;
    private Airline marketingAirLine;
    private String scheduledDepartureDateTime;
    private String scheduledArrivalDateTime;
    private String estimatedDepartureDateTime;
    private String estimatedArrivalDateTime;
    private boolean tci;
    private boolean rci;

    public List<String> getFlightIDs() {
        return flightIDs;
    }

    public Place getOrigin() {
        return origin;
    }

    public Place getDestination() {
        return destination;
    }

    public Airline getOperatingAirline() {
        return operatingAirline;
    }

    public Airline getMarketingAirLine() {
        return marketingAirLine;
    }

    public String getScheduledDepartureDateTime() {
        return scheduledDepartureDateTime;
    }

    public String getScheduledArrivalDateTime() {
        return scheduledArrivalDateTime;
    }

    public String getEstimatedDepartureDateTime() {
        return estimatedDepartureDateTime;
    }

    public String getEstimatedArrivalDateTime() {
        return estimatedArrivalDateTime;
    }

    public boolean isTci() {
        return tci;
    }

    public boolean isRci() {
        return rci;
    }

    class Place {
        private String airportCode;
        private String airportName;
        private String airportTerminal;
        private String cityName;

        public String getAirportCode() {
            return airportCode;
        }

        public String getAirportName() {
            return airportName;
        }

        public String getAirportTerminal() {
            return airportTerminal;
        }

        public String getCityName() {
            return cityName;
        }
    }

    class Airline {
        private String airlineCode;
        private String airlineName;
        private String flightNumber;

        public String getAirlineCode() {
            return airlineCode;
        }

        public String getAirlineName() {
            return airlineName;
        }

        public String getFlightNumber() {
            return flightNumber;
        }
    }
}
