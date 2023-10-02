package com.campusdual.fundme.model.dto.dtopmapper;

import com.campusdual.fundme.model.Comment;
import com.campusdual.fundme.model.dto.CommentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper
public interface CommentMapper {

    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);
    CommentDTO toDTO(Comment comment);
    List<CommentDTO> toDTOList(List<Comment> comments);
    Comment toEntity(CommentDTO commentDTO);

}