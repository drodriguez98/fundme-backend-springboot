package com.campusdual.fundme.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PROJECTS")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int project_id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_id;
    @Column
    private String title;
    @Column
    private Date date_added;
    @ManyToOne
    @JoinColumn(name = "area_id")
    private Area area_id;
    @Column
    private String description;
    @Column
    private int total_amount;

    public int getProject_id() { return project_id; }
    public void setProject_id(int project_id) { this.project_id = project_id; }
    public User getUser_id() { return user_id; }
    public void setUser_id(User user_id) { this.user_id = user_id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public Date getDate_added() { return date_added; }
    public void setDate_added(Date date_added) { this.date_added = date_added; }
    public Area getArea_id() { return area_id; }
    public void setArea_id(Area area_id) { this.area_id = area_id; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public int getTotal_amount() { return total_amount; }
    public void setTotal_amount(int total_amount) { this.total_amount = total_amount; }

}