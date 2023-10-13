package com.campusdual.fundmepls.model;

// Este archivo define la entidad User que se mapea a una tabla en la base de datos.

// La clase contiene propiedades que representan los atributos de un usuario y las anotaciones de JPA para definir cómo se mapea la entidad en la base de datos.

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    @Column
    private String name;
    @Column
    private String password;
    @Column
    private Date date_added;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country_id;
    @Column
    private String postal_code;
    @Column
    private String email;
    @Column
    private String phone;
    @Column
    private boolean active;
    @Column
    private boolean admin;
    @Column
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