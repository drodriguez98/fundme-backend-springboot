package com.campusdual.fundme.service;



import com.campusdual.fundme.api.ICountryService;
import com.campusdual.fundme.model.Country;
import com.campusdual.fundme.model.dao.CountryDAO;
import com.campusdual.fundme.model.dto.CountryDTO;
import com.campusdual.fundme.model.dto.dtopmapper.CountryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CountryService")
@Lazy
public class CountryService implements ICountryService {

    @Autowired
    private CountryDAO countryDAO;

    @Override
    public CountryDTO queryCountry (CountryDTO countryDTO) {

        Country country = CountryMapper.INSTANCE.toEntity(countryDTO);
        return CountryMapper.INSTANCE.toDTO(this.countryDAO.getReferenceById(country.getCountry_id()));

    }

    @Override
    public List<CountryDTO> queryAllCountries() { return CountryMapper.INSTANCE.toDTOList(countryDAO.findAll()); }

    @Override
    public int insertCountry (CountryDTO countryDTO) {

        Country country = CountryMapper.INSTANCE.toEntity(countryDTO);
        this.countryDAO.saveAndFlush(country);
        return country.getCountry_id();

    }
    @Override
    public int updateCountry (CountryDTO countryDTO) { return this.insertCountry(countryDTO); }

    @Override
    public int deleteCountry (CountryDTO countryDTO) {

        int id = countryDTO.getCountry_id();
        Country country = CountryMapper.INSTANCE.toEntity(countryDTO);
        this.countryDAO.delete(country);
        return id;

    }

}
