package com.campusdual.fundme.model.dto;

// Este archivo define una versión simplificada de la entidad User, utilizada para transferir datos entre la capa de servicios y los controladores.

// No tiene lógica de negocio y se utiliza para separar las preocupaciones entre las capas.

import com.campusdual.fundme.model.Country;
import java.util.Date;

public class UserDTO {

    private int user_id;
    private String name;
    private String password;
    private Date date_added;
    private Country country_id;
    private String postal_code;
    private String email;
    private String phone;
    private boolean active;
    private boolean admin;
    private String username;

    public int getUser_id() { return user_id; }
    public void setUser_id(int user_id) { this.user_id = user_id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public Date getDate_added() { return date_added; }
    public void setDate_added(Date date_added) { this.date_added = date_added; }
    public Country getCountry_id() { return country_id; }
    public void setCountry_id(Country country_id) { this.country_id = country_id; }
    public String getPostal_code() { return postal_code; }
    public void setPostal_code(String postal_code) { this.postal_code = postal_code; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
    public boolean isAdmin() { return admin; }
    public void setAdmin(boolean admin) { this.admin = admin; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

}
