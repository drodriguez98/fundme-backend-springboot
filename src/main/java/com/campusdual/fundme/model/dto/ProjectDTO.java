package com.campusdual.fundme.model.dto;

// Este archivo define una versión simplificada de la entidad Project, utilizada para transferir datos entre la capa de servicios y los controladores.
// No tiene lógica de negocio y se utiliza para separar las preocupaciones entre las capas.

import com.campusdual.fundme.model.Area;
import com.campusdual.fundme.model.User;

import java.util.Date;

public class ProjectDTO {

    private int project_id;
    private User user_id;
    private String title;
    private Date dateAdded;
    private Area area_id;
    private String description;
    private int totalAmount;

    public int getProject_id() { return project_id; }
    public void setProject_id(int project_id) { this.project_id = project_id; }
    public User getUser_id() { return user_id; }
    public void setUser_id(User user_id) { this.user_id = user_id; }
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