package com.campusdual.fundme.model.dto;

// Este archivo define una versión simplificada de la entidad Contry, utilizada para transferir datos entre la capa de servicios y los controladores.
// No tiene lógica de negocio y se utiliza para separar las preocupaciones entre las capas.

public class CountryDTO {

    private int country_id;
    private String name;

    public int getCountry_id() { return country_id; }
    public void setCountry_id(int country_id) { this.country_id = country_id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

}