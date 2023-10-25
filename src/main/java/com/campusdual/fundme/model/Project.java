package com.campusdual.fundme.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PROJECTS")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projectId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;
    @Column
    private String title;
    @Column(name = "date_added")
    private Date dateAdded;
    @ManyToOne
    @JoinColumn(name = "area_id")
    private Area areaId;
    @Column
    private String description;
    @Column(name = "total_amount")
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