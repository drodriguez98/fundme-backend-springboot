package com.campusdual.fundme.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "COMMENTS")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project projectId;
    @Column
    private Date date_added;
    @Column
    private String content;

    public int getCommentId() { return commentId; }
    public void setCommentId(int commentId) { this.commentId = commentId; }
    public User getUserId() { return userId; }
    public void setUserId(User userId) { this.userId = userId; }
    public Project getProjectId() { return projectId; }
    public void setProjectId(Project projectId) { this.projectId = projectId; }
    public Date getDate_added() { return date_added; }
    public void setDate_added(Date date_added) { this.date_added = date_added; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

}