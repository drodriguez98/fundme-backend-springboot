package com.campusdual.fundme.controller;

import com.campusdual.fundme.api.IAreaService;
import com.campusdual.fundme.model.dto.AreaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/private/areas")
public class AreaController {

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