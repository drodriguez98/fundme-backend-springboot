package com.campusdual.fundme.model.dto;

import com.campusdual.fundme.model.Area;
import com.campusdual.fundme.model.User;

import java.util.Date;

public class ProjectDTO {

    private int projectId;
    private User userId;
    private String title;
    private Date dateAdded;
    private Area areaId;
    private String description;
    private int totalAmount;

    public int getProjectId() { return projectId; }
    public void setProjectId(int projectId) { this.projectId = projectId; }
    public User getUserId() { return userId; }
    public void setUserId(User userId) { this.userId = userId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public Date getDateAdded() { return dateAdded; }
    public void setDateAdded(Date dateAdded) { this.dateAdded = dateAdded; }
    public Area getAreaId() { return areaId; }
    public void setAreaId(Area areaId) { this.areaId = areaId; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public int getTotalAmount() { return totalAmount; }
    public void setTotalAmount(int totalAmount) { this.totalAmount = totalAmount; }

}