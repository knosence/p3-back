package com.skillstrom.projectthree.warehouseapi.location;

import lombok.Data;
import lombok.extern.java.Log;

import javax.persistence.*;

@Log
@Entity
@Data
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private int locationId;

    @Column(name = "street_address")
    private String streetAddress;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "postal_code")
    private int postalCode;

    @Override
    public String toString() {
        return "Location{" +
                "locationId=" + locationId +
                ", streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode=" + postalCode +
                '}';
    }
}
