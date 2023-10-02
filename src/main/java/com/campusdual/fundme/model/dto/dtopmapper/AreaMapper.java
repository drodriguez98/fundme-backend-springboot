package com.campusdual.fundme.model.dto.dtopmapper;

import com.campusdual.fundme.model.Area;
import com.campusdual.fundme.model.dto.AreaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper
public interface AreaMapper {

    AreaMapper INSTANCE = Mappers.getMapper(AreaMapper.class);
    AreaDTO toDTO(Area area);
    List<AreaDTO> toDTOList(List<Area> areas);
    Area toEntity(AreaDTO areaDTO);

}