package com.campusdual.fundme.api;

import com.campusdual.fundme.model.dto.CommentDTO;
import java.util.List;

public interface ICommentService {

    CommentDTO queryComment (CommentDTO commentDTO);

    List<CommentDTO> queryAllComments();

    int insertComment (CommentDTO commentDTO);

    int updateComment (CommentDTO commentDTO);

    int deleteComment (CommentDTO commentDTO);

}