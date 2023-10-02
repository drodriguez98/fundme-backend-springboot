package com.campusdual.fundme.api;

import com.campusdual.fundme.model.dto.AreaDTO;
import java.util.List;

public interface IAreaService {

    AreaDTO queryArea (AreaDTO areaDTO);
    List <AreaDTO> queryAllAreas();
    int insertArea (AreaDTO areaDTO);
    int updateArea (AreaDTO areaDTO);
    int deleteArea (AreaDTO areaDTO);

}