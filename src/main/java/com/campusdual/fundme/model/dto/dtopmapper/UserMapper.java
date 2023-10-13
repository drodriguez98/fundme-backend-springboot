package com.campusdual.fundme.model.dto.dtopmapper;

// Esta interfaz se utiliza para mapear entre objetos User y objetos UserDTO.

// Utiliza la biblioteca MapStruct para generar implementaciones de mapeo automático entre las dos clases.

import com.campusdual.fundme.model.User;
import com.campusdual.fundme.model.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDTO toDTO(User user);
    List<UserDTO> toDTOList(List<User> users);
    User toEntity(UserDTO userDTO);

}