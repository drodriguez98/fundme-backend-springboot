package com.campusdual.fundmepls.model;

// Este archivo define la entidad Country que se mapea a una tabla en la base de datos.

// La clase contiene propiedades que representan los atributos de un país y las anotaciones de JPA para definir cómo se mapea la entidad en la base de datos.

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