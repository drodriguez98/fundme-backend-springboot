package com.campusdual.fundme.model.dto;

import com.campusdual.fundme.model.Country;
import java.util.Date;

public class UserDTO {

    private int userId;
    private String name;
    private String password;
    private Date dateAdded;
    private Country countryId;
    private String postalCode;
    private String email;
    private String phone;
    private boolean active;
    private boolean admin;
    private String username;

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public Date getDateAdded() { return dateAdded; }
    public void setDateAdded(Date dateAdded) { this.dateAdded = dateAdded; }
    public Country getCountryId() { return countryId; }
    public void setCountryId(Country countryId) { this.countryId = countryId; }
    public String getPostalCode() { return postalCode; }
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }
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
