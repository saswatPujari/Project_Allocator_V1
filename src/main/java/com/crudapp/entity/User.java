package com.crudapp.entity;

import javax.persistence.*;

@Entity
@Table(name = "USER")
public class User {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
	
	@Column(name = "USER_NAME")
    private String userName;
	
	@Column(name = "EMAIL")
    private String email;
	
	@Column(name = "PHONE")
    private String phone;
	
	@Column(name = "JOB")
    private String job;
	
	@Column(name = "AVAILABILITY")
    private String availability;
	
	@Column(name = "COST")
    private Double cost;
	
    @ManyToOne
    @JoinColumn(name = "ADDRESS_ID")
    private Address address;

    // Getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }
    public String getAvailability() {
        return availability;
    }
    public void setAvailability(String availability) {
        this.availability = availability;
    }
    public Double getCost() {
        return cost;
    }
    public void setCost(Double cost) {
        this.cost = cost;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    
    @Override
    public String toString() {
        return "id: " + id +
               ", userName: " + userName +
               ", email: " + email +
               ", phone: " + phone +
               ", job: " + job +
               ", availability: " + availability +
               ", cost: " + cost +
               ", address: " + (address != null ? address.toString() : "null");
    }
}

