package com.campusdual.fundme.model.dto;

import com.campusdual.fundme.model.Project;
import com.campusdual.fundme.model.User;

import java.util.Date;

public class CommentDTO {

    private int commentId;
    private User userId;
    private Project projectId;
    private Date dateAdded;
    private String content;

    public int getCommentId() { return commentId; }
    public void setCommentId(int commentId) { this.commentId = commentId; }
    public User getUserId() { return userId; }
    public void setUserId(User userId) { this.userId = userId; }
    public Project getProjectId() { return projectId; }
    public void setProjectId(Project projectId) { this.projectId = projectId; }
    public Date getDateAdded() { return dateAdded; }
    public void setDateAdded(Date dateAdded) { this.dateAdded = dateAdded; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

}