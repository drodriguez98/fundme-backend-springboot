package com.campusdual.fundme.service;

import com.campusdual.fundme.api.IAreaService;
import com.campusdual.fundme.model.Area;
import com.campusdual.fundme.model.repository.AreaRepository;
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
    private AreaRepository areaRepository;

    @Override
    public AreaDTO getArea(AreaDTO areaDTO) {

        Area area = AreaMapper.INSTANCE.toEntity(areaDTO);
        return AreaMapper.INSTANCE.toDTO(this.areaRepository.getReferenceById(area.getArea_id()));

    }

    @Override
    public List<AreaDTO> getAllAreas() { return AreaMapper.INSTANCE.toDTOList(areaRepository.findAll()); }

    @Override
    public int insertArea (AreaDTO areaDTO) {

        Area area = AreaMapper.INSTANCE.toEntity(areaDTO);
        this.areaRepository.saveAndFlush(area);
        return area.getArea_id();

    }

    @Override
    public int updateArea (AreaDTO areaDTO) { return this.insertArea(areaDTO); }

    @Override
    public int deleteArea (AreaDTO areaDTO) {

        int id = areaDTO.getArea_id();
        Area area = AreaMapper.INSTANCE.toEntity(areaDTO);
        this.areaRepository.delete(area);
        return id;

    }

}