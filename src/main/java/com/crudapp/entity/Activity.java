package com.crudapp.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "ACTIVITY")
public class Activity {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
	
	@Column(name = "ACTIVITY_NAME")
    private String activityName;
	
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

    // Getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	
    @Override
    public String toString() {
        return "id: " + id +
               ", activityName: " + activityName +
               ", description: " + description +
               ", type: " + type +
               ", status: " + status +
               ", startDate: " + startDate +
               ", endDate: " + endDate;
    }
}

