package com.campusdual.fundme.api;

// Esta interfaz define métodos que deben ser implementados por un servicio que maneja operaciones relacionadas con comentarios.
// Incluye operaciones para consultar, insertar, actualizar y eliminar comentarios.

import com.campusdual.fundme.model.dto.CommentDTO;
import java.util.List;

public interface ICommentService {

    CommentDTO getComment(CommentDTO commentDTO);

    List<CommentDTO> getAllComments();

    int insertComment (CommentDTO commentDTO);

    int updateComment (CommentDTO commentDTO);

    int deleteComment (CommentDTO commentDTO);

}