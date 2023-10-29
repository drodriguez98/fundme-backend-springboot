package com.campusdual.fundme.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "NOTIFICATIONS")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int notificationId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User recipient;
    @Column
    private String message;
    @Column
    private Date createdDate;
    @Column
    private boolean read;
    @Column
    private String type;
    @ManyToOne
    @JoinColumn(name = "related_user_id")
    private User relatedUser;
    @ManyToOne
    @JoinColumn(name = "related_project_id")
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