package com.campusdual.fundme.service;

import com.campusdual.fundme.api.ICountryService;
import com.campusdual.fundme.model.Country;
import com.campusdual.fundme.model.repository.CountryRepository;
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
    private CountryRepository countryRepository;

    @Override
    public CountryDTO getCountry(CountryDTO countryDTO) {

        Country country = CountryMapper.INSTANCE.toEntity(countryDTO);
        return CountryMapper.INSTANCE.toDTO(this.countryRepository.getReferenceById(country.getCountryId()));

    }

    @Override
    public List<CountryDTO> getAllCountries() { return CountryMapper.INSTANCE.toDTOList(countryRepository.findAll()); }

    @Override
    public int insertCountry (CountryDTO countryDTO) {

        Country country = CountryMapper.INSTANCE.toEntity(countryDTO);
        this.countryRepository.saveAndFlush(country);
        return country.getCountryId();

    }
    @Override
    public int updateCountry (CountryDTO countryDTO) { return this.insertCountry(countryDTO); }

    @Override
    public int deleteCountry (CountryDTO countryDTO) {

        int id = countryDTO.getCountryId();
        Country country = CountryMapper.INSTANCE.toEntity(countryDTO);
        this.countryRepository.delete(country);
        return id;

    }

}
