package com.crudapp.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ASSIGNMENT")
public class Assignment {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
	
    @ManyToOne
    @JoinColumn(name = "PROJECT_ID")
    private Project project;
    
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "ACTIVITY_ID")
    private Activity activity;
    
    @ManyToOne
    @JoinColumn(name = "DEVICE_ID")
    private Device device;
    
    @Column(name = "START_DATE")
    private Date startDate;
    
    @Column(name = "FINISH_DATE")
    private Date finishDate;
    
    @Column(name = "COST")
    private Double cost;

    // Getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Project getProject() {
        return project;
    }
    public void setProject(Project project) {
        this.project = project;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Device getDevice() {
        return device;
    }
    public void setDevice(Device device) {
        this.device = device;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getFinishDate() {
        return finishDate;
    }
    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }
    public Double getCost() {
        return cost;
    }
    public void setCost(Double cost) {
        this.cost = cost;
    }
    
	public Activity getActivity() {
		return activity;
	}
	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	
    @Override
    public String toString() {
        return "id: " + id +
               ", project: " + (project != null ? project.getProjectName() : "null") +
               ", activity: " + (activity != null ? activity.getActivityName() : "null") +
               ", user: " + (user != null ? user.getUserName() : "null") +
               ", device: " + (device != null ? device.getDeviceName(): "null") +
               ", startDate: " + startDate +
               ", finishDate: " + finishDate +
               ", cost: " + cost;
    }
}

