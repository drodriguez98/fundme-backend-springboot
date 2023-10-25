package com.campusdual.fundme.model;

import javax.persistence.*;

@Entity
@Table(name = "COUNTRIES")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int countryId;
    @Column
    private String name;

    public int getCountryId() { return countryId; }
    public void setCountryId(int countryId) { this.countryId = countryId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

}