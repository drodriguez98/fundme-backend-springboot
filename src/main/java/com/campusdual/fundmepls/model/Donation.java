package com.campusdual.fundmepls.model;

// Este archivo define la entidad Donation que se mapea a una tabla en la base de datos.

// La clase contiene propiedades que representan los atributos de una donación y las anotaciones de JPA para definir cómo se mapea la entidad en la base de datos.

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "DONATIONS")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int donation_id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_id;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project_id;
    @Column
    private Date date_added;
    @Column
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