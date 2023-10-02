package com.campusdual.fundme.model;

import javax.persistence.*;

@Entity
@Table(name = "COUNTRIES")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int country_id;
    @Column
    private String name;

    public int getCountry_id() { return country_id; }
    public void setCountry_id(int country_id) { this.country_id = country_id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

}