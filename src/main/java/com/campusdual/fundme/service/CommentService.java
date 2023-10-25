package com.campusdual.fundme.service;

import com.campusdual.fundme.api.ICommentService;
import com.campusdual.fundme.model.Comment;
import com.campusdual.fundme.model.repository.CommentRepository;
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
    private CommentRepository commentRepository;

    @Override
    public CommentDTO getComment(CommentDTO commentDTO) {

        Comment comment = CommentMapper.INSTANCE.toEntity(commentDTO);
        return CommentMapper.INSTANCE.toDTO(this.commentRepository.getReferenceById(comment.getCommentId()));

    }

    @Override
    public List<CommentDTO> getAllComments() { return CommentMapper.INSTANCE.toDTOList(commentRepository.findAll()); }

    @Override
    public int insertComment (CommentDTO commentDTO) {

        Comment comment = CommentMapper.INSTANCE.toEntity(commentDTO);
        this.commentRepository.saveAndFlush(comment);
        return comment.getCommentId();

    }
    @Override
    public int updateComment (CommentDTO commentDTO) { return this.insertComment(commentDTO); }

    @Override
    public int deleteComment (CommentDTO commentDTO) {

        int id = commentDTO.getCommentId();
        Comment comment = CommentMapper.INSTANCE.toEntity(commentDTO);
        this.commentRepository.delete(comment);
        return id;

    }

}