package com.campusdual.fundme.model;

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
    private User userId;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project_id;
    @Column(name = "date_added")
    private Date dateAdded;
    @Column
    private int amount;

    public int getDonation_id() { return donation_id; }
    public void setDonation_id(int donation_id) { this.donation_id = donation_id; }
    public User getUserId() { return userId; }
    public void setUserId(User userId) { this.userId = userId; }
    public Project getProject_id() { return project_id; }
    public void setProject_id(Project project_id) { this.project_id = project_id; }
    public Date getDateAdded() { return dateAdded; }
    public void setDateAdded(Date dateAdded) { this.dateAdded = dateAdded; }
    public int getAmount() { return amount; }
    public void setAmount(int amount) { this.amount = amount; }

}