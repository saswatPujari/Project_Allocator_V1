package com.crudapp.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "PROJECT")
public class Project {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
	
	@Column(name = "PROJECT_NAME")
    private String projectName;
	
	@Column(name = "DESCRIPTION")
    private String description;
	
	@Column(name = "TYPE")
    private String type;
	
	@Column(name = "STATUS")
    private String status;
	
	@Column(name = "START_DATE")
    private Date startDate;
	
	@Column(name = "END_DATE")
    private Date endDate;
	
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
    public String getProjectName() {
        return projectName;
    }
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
    @Override
    public String toString() {
        return "id: " + id +
               ", projectName: " + projectName +
               ", description: " + description +
               ", type: " + type +
               ", status: " + status +
               ", startDate: " + startDate +
               ", endDate: " + endDate +
               ", address: " + (address != null ? address.toString() : "null");
    }
}

