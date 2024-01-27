package com.crudapp.entity;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESS")
public class Address{
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "STREET")
    private String street;
    
    @Column(name = "CITY")
    private String city;
    
    @Column(name = "STATE")
    private String state;
    
    @Column(name = "COUNTRY")
    private String country;
    
    @Column(name = "ZIP_CODE")
    private String zipCode;

    // Getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
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
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    
    @Override
    public String toString() {
        return "id: " + id +
               ", street: " + street +
               ", city: " + city +
               ", state: " + state +
               ", country: " + country +
               ", zipCode: " + zipCode;
    }
}
