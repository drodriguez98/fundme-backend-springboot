package com.campusdual.fundme.model;

// Este archivo define la entidad Area que se mapea a una tabla en la base de datos.
// La clase contiene propiedades que representan los atributos de un área y las anotaciones de JPA para definir cómo se mapea la entidad en la base de datos.

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