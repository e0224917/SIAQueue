package com.flymetothemoon.siaqueue.retrofit.model;

/**
 * Created by nhatton on 10/23/17.
 */

public class Service {

    private String flightID;
    private String passengerID;
    private String cabinClass;
    private String seatSelected;
    private String ticketNumber;
    private boolean upgraded;
    private Status dcsStatus;
    private FQDetail fqtvDetails;
    private FQDetail fqtsDetails;

    public String getFlightID() {
        return flightID;
    }

    public String getPassengerID() {
        return passengerID;
    }

    public String getCabinClass() {
        return cabinClass;
    }

    public String getSeatSelected() {
        return seatSelected;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public boolean isUpgraded() {
        return upgraded;
    }

    public Status getDcsStatus() {
        return dcsStatus;
    }

    public FQDetail getFqtvDetails() {
        return fqtvDetails;
    }

    public FQDetail getFqtsDetails() {
        return fqtsDetails;
    }

    class Status{
        private boolean boardingPassIssued;
        private boolean checkedIn;
        private boolean docChecksPassed;
        private boolean regulatoryChecksPassed;
        private boolean spBpEnabled;
        private boolean ccvDocCheckRequired;
        private boolean visaDocCheckRequired;
        private boolean dcsIceIsBlocked;

        public boolean isBoardingPassIssued() {
            return boardingPassIssued;
        }

        public boolean isCheckedIn() {
            return checkedIn;
        }

        public boolean isDocChecksPassed() {
            return docChecksPassed;
        }

        public boolean isRegulatoryChecksPassed() {
            return regulatoryChecksPassed;
        }

        public boolean isSpBpEnabled() {
            return spBpEnabled;
        }

        public boolean isCcvDocCheckRequired() {
            return ccvDocCheckRequired;
        }

        public boolean isVisaDocCheckRequired() {
            return visaDocCheckRequired;
        }

        public boolean isDcsIceIsBlocked() {
            return dcsIceIsBlocked;
        }
    }

    class FQDetail {
        private boolean loyaltyTierCode;
        private boolean loyaltyTierName;
        private String ffpAirline;
        private String ffpNumber;

        public boolean isLoyaltyTierCode() {
            return loyaltyTierCode;
        }

        public boolean isLoyaltyTierName() {
            return loyaltyTierName;
        }

        public String getFfpAirline() {
            return ffpAirline;
        }

        public String getFfpNumber() {
            return ffpNumber;
        }
    }
}
