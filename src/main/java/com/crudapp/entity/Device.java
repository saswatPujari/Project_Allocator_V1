package com.crudapp.entity;

import javax.persistence.*;

@Entity
@Table(name = "DEVICE")
public class Device{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
	
	@Column(name = "DEVICE_NAME")
    private String deviceName;
	
	@Column(name = "TYPE")
    private String type;
	
	@Column(name = "COST")
    private Double cost;
	
	@Column(name = "QUANTITY")
    private int quantity;

    // Getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDeviceName() {
        return deviceName;
    }
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Double getCost() {
        return cost;
    }
    public void setCost(Double cost) {
        this.cost = cost;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    @Override
    public String toString() {
        return "id: " + id +
               ", deviceName: " + deviceName +
               ", type: " + type +
               ", cost: " + cost +
               ", quantity: " + quantity;
    }
}
