package com.campusdual.fundme.model.dto.dtopmapper;

// Esta interfaz se utiliza para mapear entre objetos Comment y objetos CommentDTO.
// Utiliza la biblioteca MapStruct para generar implementaciones de mapeo automático entre las dos clases.

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