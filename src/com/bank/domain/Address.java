package com.bank.domain;

public class Address {
    private int id;
    private String street1;
    private String street2;
    private String city;
    private String zip;
    private String country;

    public Address(int id, String street1, String street2, String city, String zip, String country) {
        this.id = id;
        this.street1 = street1;
        this.street2 = street2;
        this.city = city;
        this.zip = zip;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public String getStreet1() {
        return street1;
    }

    public String getStreet2() {
        return street2;
    }

    public String getCity() {
        return city;
    }

    public String getZip() {
        return zip;
    }

    public String getCountry() {
        return country;
    }
}
