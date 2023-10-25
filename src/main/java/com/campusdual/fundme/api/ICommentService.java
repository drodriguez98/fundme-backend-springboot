package com.campusdual.fundme.api;

import com.campusdual.fundme.model.Comment;
import com.campusdual.fundme.model.Project;
import com.campusdual.fundme.model.dto.CommentDTO;
import com.campusdual.fundme.model.dto.ProjectDTO;

import java.util.List;

public interface ICommentService {

    CommentDTO getComment(CommentDTO commentDTO);
    List<CommentDTO> getAllComments();

    int insertComment (CommentDTO commentDTO);
    int updateComment (CommentDTO commentDTO);
    int deleteComment (CommentDTO commentDTO);

    List<Comment> getCommentsByProjectId(ProjectDTO projectDTO);

}