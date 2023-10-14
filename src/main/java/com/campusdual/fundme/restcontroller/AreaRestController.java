package com.campusdual.fundme.restcontroller;

// Este controlador define rutas y métodos que gestionan las solicitudes relacionadas con las áreas.
// Utiliza el servicio IAreaService para llevar a cabo operaciones como consultar, insertar, actualizar y eliminar áreas.

import com.campusdual.fundme.api.IAreaService;
import com.campusdual.fundme.model.dto.AreaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/fundme/controller/rest/areas")
public class AreaRestController {

    @Autowired
    private IAreaService areaService;

    @PostMapping(value = "get")
    public AreaDTO queryArea (@RequestBody AreaDTO area) { return this.areaService.queryArea(area); }

    @GetMapping(value = "/all")
    public List<AreaDTO> queryAllAreas() { return this.areaService.queryAllAreas(); }

    @PostMapping(value = "/add")
    public int insertArea (@RequestBody AreaDTO area) { return this.areaService.insertArea(area); }

    @PutMapping(value = "/update")
    public int updateArea (@RequestBody AreaDTO area) { return this.areaService.updateArea(area); }

    @PostMapping(value = "/delete")
    public int deleteArea (@RequestBody AreaDTO area) { return this.areaService.deleteArea(area); }

}