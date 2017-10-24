package com.flymetothemoon.siaqueue.retrofit.model;

import java.util.List;

/**
 * Created by nhatton on 10/23/17.
 */

public class Passenger {

    private String passengerID;
    private List<String> flightIDs;
    private String lastName;
    private String firstName;
    private String title;
    private String dateOfBirth;
    private String gender;
    private String passengerType;
    private AddInfo addressInfo;
    private String countryOfResidence;
    private PRCard prCard;
    private Passport passport;
    private Contact contactDetails;
    private NextOfKin nextOfKinDetails;

    class AddInfo {
        private String address;
        private String stateName;
        private String countryName;
        private String cityName;
        private String zipCode;

        public String getAddress() {
            return address;
        }

        public String getStateName() {
            return stateName;
        }

        public String getCountryName() {
            return countryName;
        }

        public String getCityName() {
            return cityName;
        }

        public String getZipCode() {
            return zipCode;
        }
    }

    private class PRCard {
        private String number;
        private String expiryDate;
        private String issuingCountryCode;
        private String registrationCountryCode;
        private String type;
        private String firstName;
        private String lastName;

        public String getNumber() {
            return number;
        }

        public String getExpiryDate() {
            return expiryDate;
        }

        public String getIssuingCountryCode() {
            return issuingCountryCode;
        }

        public String getRegistrationCountryCode() {
            return registrationCountryCode;
        }

        public String getType() {
            return type;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }
    }

    private class Passport {
        private String firstName;
        private String lastName;
        private String expiryDate;
        private String issuingCountryCode;
        private String nationalityCode;
        private String passportNumber;
    }

    private class Contact {
        private String mobileNumber;
        private String mobileCountryCode;
        private String email;
    }

    private class NextOfKin {
        private String name;
        private String relation;
        private String mobileNumber;
        private String mobileCountryCode;
    }
}
