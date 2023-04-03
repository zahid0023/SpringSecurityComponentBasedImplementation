package com.example.springdatajpa.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressData {
    private Long addressId;
    private String address;
    private String city;
    private String state;
    private String zip;

    public AddressData(Long addressId,
                       String address,
                       String city,
                       String state,
                       String zip) {
        this.addressId = addressId;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "AddressData{" +
                "addressId=" + addressId +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }
}
