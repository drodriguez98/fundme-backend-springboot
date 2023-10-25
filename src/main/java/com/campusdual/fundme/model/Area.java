package com.campusdual.fundme.model;

import javax.persistence.*;

@Entity
@Table(name = "AREAS")
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int areaId;
    @Column
    private String name;

    public int getAreaId() { return areaId; }
    public void setAreaId(int areaId) { this.areaId = areaId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

}