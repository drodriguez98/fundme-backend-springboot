package com.campusdual.fundme.model.dto;

// Este archivo define una versión simplificada de la entidad Area, utilizada para transferir datos entre la capa de servicios y los controladores.

// No tiene lógica de negocio y se utiliza para separar las preocupaciones entre las capas.

public class AreaDTO {

    private int area_id;
    private String name;

    public int getArea_id() { return area_id; }
    public void setArea_id(int area_id) { this.area_id = area_id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

}