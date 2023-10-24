package com.campusdual.fundme.model.dto;

import com.campusdual.fundme.model.Area;
import com.campusdual.fundme.model.User;

import java.util.Date;

public class ProjectDTO {

    private int project_id;
    private User userId;
    private String title;
    private Date dateAdded;
    private Area area_id;
    private String description;
    private int totalAmount;

    public int getProject_id() { return project_id; }
    public void setProject_id(int project_id) { this.project_id = project_id; }
    public User getUserId() { return userId; }
    public void setUserId(User user_id) { this.userId = user_id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public Date getDateAdded() { return dateAdded; }
    public void setDateAdded(Date dateAdded) { this.dateAdded = dateAdded; }
    public Area getArea_id() { return area_id; }
    public void setArea_id(Area area_id) { this.area_id = area_id; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public int getTotalAmount() { return totalAmount; }
    public void setTotalAmount(int totalAmount) { this.totalAmount = totalAmount; }

}