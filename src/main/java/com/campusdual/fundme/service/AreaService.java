package com.campusdual.fundme.service;

import com.campusdual.fundme.api.IAreaService;
import com.campusdual.fundme.model.Area;
import com.campusdual.fundme.model.dao.AreaDAO;
import com.campusdual.fundme.model.dto.AreaDTO;
import com.campusdual.fundme.model.dto.dtopmapper.AreaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AreaService")
@Lazy
public class AreaService implements IAreaService {

    @Autowired
    private AreaDAO areaDAO;

    @Override
    public AreaDTO queryArea (AreaDTO areaDTO) {

        Area area = AreaMapper.INSTANCE.toEntity(areaDTO);
        return AreaMapper.INSTANCE.toDTO(this.areaDAO.getReferenceById(area.getArea_id()));

    }

    @Override
    public List<AreaDTO> queryAllAreas() { return AreaMapper.INSTANCE.toDTOList(areaDAO.findAll()); }

    @Override
    public int insertArea (AreaDTO areaDTO) {

        Area area = AreaMapper.INSTANCE.toEntity(areaDTO);
        this.areaDAO.saveAndFlush(area);
        return area.getArea_id();

    }

    @Override
    public int updateArea (AreaDTO areaDTO) { return this.insertArea(areaDTO); }

    @Override
    public int deleteArea (AreaDTO areaDTO) {

        int id = areaDTO.getArea_id();
        Area area = AreaMapper.INSTANCE.toEntity(areaDTO);
        this.areaDAO.delete(area);
        return id;

    }

}