package com.campusdual.fundme.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "DONATIONS")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int donationId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project projectId;
    @Column(name = "date_added")
    private Date dateAdded;
    @Column
    private int amount;

    public int getDonationId() { return donationId; }
    public void setDonationId(int donationId) { this.donationId = donationId; }
    public User getUserId() { return userId; }
    public void setUserId(User userId) { this.userId = userId; }
    public Project getProjectId() { return projectId; }
    public void setProjectId(Project projectId) { this.projectId = projectId; }
    public Date getDateAdded() { return dateAdded; }
    public void setDateAdded(Date dateAdded) { this.dateAdded = dateAdded; }
    public int getAmount() { return amount; }
    public void setAmount(int amount) { this.amount = amount; }

}