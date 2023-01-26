package com.skillstorm.p3one.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id", nullable = false)
    private Integer id;

    @Column(name = "street_address", nullable = false, length = 60)
    private String streetAddress;

    @Column(name = "city", nullable = false, length = 40)
    private String city;

    @Column(name = "state", nullable = false, length = 2)
    private String state;

    @Column(name = "postal_code", nullable = false)
    private Integer postalCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(getId(), location.getId()) && Objects.equals(getStreetAddress(), location.getStreetAddress()) && Objects.equals(getCity(), location.getCity()) && Objects.equals(getState(), location.getState()) && Objects.equals(getPostalCode(), location.getPostalCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStreetAddress(), getCity(), getState(), getPostalCode());
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode=" + postalCode +
                '}';
    }
}