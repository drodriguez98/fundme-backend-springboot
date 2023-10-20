package com.campusdual.fundme.model;

// Este archivo define la entidad Project que se mapea a una tabla en la base de datos.
// La clase contiene propiedades que representan los atributos de un proyecto y las anotaciones de JPA para definir cómo se mapea la entidad en la base de datos.

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
    @Column(name = "date_added")
    private Date dateAdded;
    @ManyToOne
    @JoinColumn(name = "area_id")
    private Area area_id;
    @Column
    private String description;
    @Column(name = "total_amount")
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