package com.campusdual.fundme.model.dto;

import com.campusdual.fundme.model.Project;
import com.campusdual.fundme.model.User;

import java.util.Date;

public class DonationDTO {

    private int donationId;
    private User userId;
    private Project projectId;
    private Date dateAdded;
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
