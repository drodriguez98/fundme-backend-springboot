package com.campusdual.fundme.api;

import com.campusdual.fundme.model.dto.AreaDTO;
import java.util.List;

public interface IAreaService {

    AreaDTO getArea(AreaDTO areaDTO);
    List <AreaDTO> getAllAreas();

    int insertArea (AreaDTO areaDTO);
    int updateArea (AreaDTO areaDTO);
    int deleteArea (AreaDTO areaDTO);

}