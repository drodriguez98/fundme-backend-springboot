package com.campusdual.fundme.model;

import javax.persistence.*;

@Entity
@Table(name = "AREAS")
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int area_id;
    @Column
    private String name;

    public int getArea_id() { return area_id; }
    public void setArea_id(int area_id) { this.area_id = area_id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

}