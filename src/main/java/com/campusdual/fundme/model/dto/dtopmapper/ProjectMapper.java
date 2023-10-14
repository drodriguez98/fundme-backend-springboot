package com.campusdual.fundme.model.dto.dtopmapper;

// Esta interfaz se utiliza para mapear entre objetos Project y objetos ProjectDTO.
// Utiliza la biblioteca MapStruct para generar implementaciones de mapeo automático entre las dos clases.

import com.campusdual.fundme.model.Project;
import com.campusdual.fundme.model.dto.ProjectDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper
public interface ProjectMapper {

    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);
    ProjectDTO toDTO(Project project);
    List<ProjectDTO> toDTOList(List<Project> projects);
    Project toEntity(ProjectDTO projectDTO);
}
