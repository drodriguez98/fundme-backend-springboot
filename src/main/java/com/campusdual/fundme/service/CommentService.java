package com.campusdual.fundme.service;

import com.campusdual.fundme.api.ICommentService;
import com.campusdual.fundme.model.dao.CommentDAO;
import com.campusdual.fundme.model.dto.AreaDTO;
import com.campusdual.fundme.model.dto.CommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CommentService")
@Lazy
public class CommentService implements ICommentService {

    @Autowired
    private CommentDAO commentDAO;

    @Override
    public CommentDTO queryComment (CommentDTO commentDTO) { return null; }
    @Override
    public List<CommentDTO> queryAllComments() { return null; }
    @Override
    public int insertComment (CommentDTO commentDTO) { return 0; }
    @Override
    public int updateComment (CommentDTO commentDTO) { return 0; }
    @Override
    public int deleteComment (CommentDTO commentDTO) { return 0; }

}