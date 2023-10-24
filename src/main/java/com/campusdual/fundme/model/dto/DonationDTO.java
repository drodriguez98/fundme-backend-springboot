package com.campusdual.fundme.model.dto;

import com.campusdual.fundme.model.Project;
import com.campusdual.fundme.model.User;

import java.util.Date;

public class DonationDTO {

    private int donation_id;
    private User userId;
    private Project project_id;
    private Date dateAdded;
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
