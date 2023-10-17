package com.campusdual.fundme.api;

// Esta interfaz define métodos que deben ser implementados por un servicio que maneja operaciones relacionadas con áreas.
// Incluye operaciones para consultar, insertar, actualizar y eliminar áreas.

import com.campusdual.fundme.model.dto.AreaDTO;
import java.util.List;

public interface IAreaService {

    AreaDTO getArea(AreaDTO areaDTO);

    List <AreaDTO> getAllAreas();

    int insertArea (AreaDTO areaDTO);

    int updateArea (AreaDTO areaDTO);

    int deleteArea (AreaDTO areaDTO);

}