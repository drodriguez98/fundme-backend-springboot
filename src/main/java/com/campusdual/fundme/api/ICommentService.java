package com.campusdual.fundme.api;

import com.campusdual.fundme.model.dto.CommentDTO;
import java.util.List;

public interface ICommentService {

    CommentDTO getComment(CommentDTO commentDTO);
    List<CommentDTO> getAllComments();

    int insertComment (CommentDTO commentDTO);
    int updateComment (CommentDTO commentDTO);
    int deleteComment (CommentDTO commentDTO);

}