package com.campusdual.fundme.model.dto;

import com.campusdual.fundme.model.Project;
import com.campusdual.fundme.model.User;

import java.util.Date;

public class NotificationDTO {

    private int notificationId;
    private User recipient;
    private String message;
    private Date createdDate;
    private boolean read;
    private String type;
    private User relatedUser;
    private Project relatedProject;

    public int getNotificationId() { return notificationId; }
    public void setNotificationId(int notificationId) { this.notificationId = notificationId; }
    public User getRecipient() { return recipient; }
    public void setRecipient(User recipient) { this.recipient = recipient; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public Date getCreatedDate() { return createdDate; }
    public void setCreatedDate(Date createdDate) { this.createdDate = createdDate; }
    public boolean isRead() { return read; }
    public void setRead(boolean read) { this.read = read; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public User getRelatedUser() { return relatedUser; }
    public void setRelatedUser(User relatedUser) { this.relatedUser = relatedUser; }
    public Project getRelatedProject() { return relatedProject; }
    public void setRelatedProject(Project relatedProject) { this.relatedProject = relatedProject; }

}