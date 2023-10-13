package com.campusdual.fundmepls.model;

// Este archivo define la entidad Comment que se mapea a una tabla en la base de datos.

// La clase contiene propiedades que representan los atributos de un comentario y las anotaciones de JPA para definir cómo se mapea la entidad en la base de datos.

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "COMMENTS")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int comment_id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_id;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project_id;
    @Column
    private Date date_added;
    @Column
    private String content;

    public int getComment_id() { return comment_id; }
    public void setComment_id(int comment_id) { this.comment_id = comment_id; }
    public User getUser_id() { return user_id; }
    public void setUser_id(User user_id) { this.user_id = user_id; }
    public Project getProject_id() { return project_id; }
    public void setProject_id(Project project_id) { this.project_id = project_id; }
    public Date getDate_added() { return date_added; }
    public void setDate_added(Date date_added) { this.date_added = date_added; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

}