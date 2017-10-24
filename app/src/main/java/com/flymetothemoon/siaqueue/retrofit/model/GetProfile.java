package com.flymetothemoon.siaqueue.retrofit.model;

import java.util.Date;
import java.util.List;

/**
 * Created by nhatton on 10/24/17.
 */

public class GetProfile {

    private Account accountSummary;
    private List<Address> address;
    private List<Contact> contact;
    private String datOfBirth;
    private String firstName;
    private String lastName;
    private String gender;
    private String loyaltyTierCode;
    private String loyaltyTierName;
    private Passport passport;
    private String title;

    public Account getAccountSummary() {
        return accountSummary;
    }

    public List<Address> getAddress() {
        return address;
    }

    public List<Contact> getContact() {
        return contact;
    }

    public String getDatOfBirth() {
        return datOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getLoyaltyTierCode() {
        return loyaltyTierCode;
    }

    public String getLoyaltyTierName() {
        return loyaltyTierName;
    }

    public Passport getPassport() {
        return passport;
    }

    public String getTitle() {
        return title;
    }

    class Account{
        private Date memberSince;
        private Date cardExpiryDate;
        private long kfMiles;
        private long eliteMiles;
        private String eliteRequalifiedBy;
        private long eliteRequalifiedMilesRequired;
        private long ppsMiles;
        private long ppsValues;
        private long ppsReserveValue;
        private String ppsRequalifiedBy;
        private long ppsRequalifiedMilesRequired;

        public Date getMemberSince() {
            return memberSince;
        }

        public Date getCardExpiryDate() {
            return cardExpiryDate;
        }

        public long getKfMiles() {
            return kfMiles;
        }

        public long getEliteMiles() {
            return eliteMiles;
        }

        public String getEliteRequalifiedBy() {
            return eliteRequalifiedBy;
        }

        public long getEliteRequalifiedMilesRequired() {
            return eliteRequalifiedMilesRequired;
        }

        public long getPpsMiles() {
            return ppsMiles;
        }

        public long getPpsValues() {
            return ppsValues;
        }

        public long getPpsReserveValue() {
            return ppsReserveValue;
        }

        public String getPpsRequalifiedBy() {
            return ppsRequalifiedBy;
        }

        public long getPpsRequalifiedMilesRequired() {
            return ppsRequalifiedMilesRequired;
        }
    }

    class Address{
        private String type;
        private String line1;
        private String line2;
        private String line3;
        private String line4;
        private String city;
        private String state;
        private String country;
        private String postalCode;

        public String getType() {
            return type;
        }

        public String getLine1() {
            return line1;
        }

        public String getLine2() {
            return line2;
        }

        public String getLine3() {
            return line3;
        }

        public String getLine4() {
            return line4;
        }

        public String getCity() {
            return city;
        }

        public String getState() {
            return state;
        }

        public String getCountry() {
            return country;
        }

        public String getPostalCode() {
            return postalCode;
        }
    }

    class Passport {
        private String passportNumber;
        private String expiryDate;
        private String issuingCountry;
        private String nationality;

        public String getPassportNumber() {
            return passportNumber;
        }

        public String getExpiryDate() {
            return expiryDate;
        }

        public String getIssuingCountry() {
            return issuingCountry;
        }

        public String getNationality() {
            return nationality;
        }
    }

    private class Contact {
        private String type;
        private String phoneNumber;
        private String countryCode;
        private String areaCode;

        public String getType() {
            return type;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public String getAreaCode() {
            return areaCode;
        }
    }
}
