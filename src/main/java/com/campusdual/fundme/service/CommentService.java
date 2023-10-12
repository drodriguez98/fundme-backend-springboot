package com.campusdual.fundme.service;

import com.campusdual.fundme.api.ICommentService;
import com.campusdual.fundme.model.Comment;
import com.campusdual.fundme.model.dao.CommentDAO;
import com.campusdual.fundme.model.dto.CommentDTO;
import com.campusdual.fundme.model.dto.dtopmapper.CommentMapper;
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
    public CommentDTO queryComment (CommentDTO commentDTO) {

        Comment comment = CommentMapper.INSTANCE.toEntity(commentDTO);
        return CommentMapper.INSTANCE.toDTO(this.commentDAO.getReferenceById(comment.getComment_id()));

    }

    @Override
    public List<CommentDTO> queryAllComments() { return CommentMapper.INSTANCE.toDTOList(commentDAO.findAll()); }

    @Override
    public int insertComment (CommentDTO commentDTO) {

        Comment comment = CommentMapper.INSTANCE.toEntity(commentDTO);
        this.commentDAO.saveAndFlush(comment);
        return comment.getComment_id();

    }
    @Override
    public int updateComment (CommentDTO commentDTO) { return this.insertComment(commentDTO); }

    @Override
    public int deleteComment (CommentDTO commentDTO) {

        int id = commentDTO.getComment_id();
        Comment comment = CommentMapper.INSTANCE.toEntity(commentDTO);
        this.commentDAO.delete(comment);
        return id;

    }

}