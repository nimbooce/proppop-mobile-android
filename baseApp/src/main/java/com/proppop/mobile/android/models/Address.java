package com.proppop.mobile.android.models;

import com.google.firebase.database.Exclude;

import java.util.HashMap;

/**
 * Created by animal@martus.org on 9/2/16.
 */

public class Address {

    public int unitNumnber;
    public int streetNumber;
    public String street;
    public int zipCode;
    public String city;
    public String state;
    public String country;

    public Address() {
    }

    public Address(int unitNumnber, int streetNumber, String street, int zipCode, String city, String state, String country) {
        this.unitNumnber = unitNumnber;
        this.streetNumber = streetNumber;
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
        this.state =  state;
        this.country = country;
    }

    @Exclude
    public HashMap<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("unit_number", unitNumnber);
        result.put("street_number", streetNumber);
        result.put("street", street);
        result.put("zipCode", zipCode);
        result.put("city", city);
        result.put("state", state);
        result.put("country", country);

        return result;
    }
}
