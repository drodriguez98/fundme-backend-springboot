package com.campusdual.fundme.service;

import com.campusdual.fundme.api.IAreaService;
import com.campusdual.fundme.model.dao.AreaDAO;
import com.campusdual.fundme.model.dto.AreaDTO;
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
    public AreaDTO queryArea (AreaDTO areaDTO) { return null; }
    @Override
    public List<AreaDTO> queryAllAreas() { return null; }
    @Override
    public int insertArea (AreaDTO areaDTO) { return 0; }
    @Override
    public int updateArea (AreaDTO areaDTO) { return 0; }
    @Override
    public int deleteArea (AreaDTO areaDTO) { return 0; }

}