package com.campusdual.fundme.service;

import com.campusdual.fundme.api.ICountryService;
import com.campusdual.fundme.model.dao.CountryDAO;
import com.campusdual.fundme.model.dto.CommentDTO;
import com.campusdual.fundme.model.dto.CountryDTO;
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
    public CountryDTO queryCountry (CountryDTO countryDTO) { return null; }
    @Override
    public List<CountryDTO> queryAllCountries() { return null; }
    @Override
    public int insertCountry (CountryDTO countryDTO) { return 0; }
    @Override
    public int updateCountry (CountryDTO countryDTO) { return 0; }
    @Override
    public int deleteCountry (CountryDTO countryDTO) { return 0; }

}
