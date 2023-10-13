package com.campusdual.fundme.model.dto;

// Este archivo define una versión simplificada de la entidad Donation, utilizada para transferir datos entre la capa de servicios y los controladores.
// No tiene lógica de negocio y se utiliza para separar las preocupaciones entre las capas.

import com.campusdual.fundme.model.Project;
import com.campusdual.fundme.model.User;

import java.util.Date;

public class DonationDTO {

    private int donation_id;
    private User user_id;
    private Project project_id;
    private Date date_added;
    private int amount;

    public int getDonation_id() { return donation_id; }
    public void setDonation_id(int donation_id) { this.donation_id = donation_id; }
    public User getUser_id() { return user_id; }
    public void setUser_id(User user_id) { this.user_id = user_id; }
    public Project getProject_id() { return project_id; }
    public void setProject_id(Project project_id) { this.project_id = project_id; }
    public Date getDate_added() { return date_added; }
    public void setDate_added(Date date_added) { this.date_added = date_added; }
    public int getAmount() { return amount; }
    public void setAmount(int amount) { this.amount = amount; }

}
