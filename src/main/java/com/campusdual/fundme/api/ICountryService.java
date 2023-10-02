package com.campusdual.fundme.api;

import com.campusdual.fundme.model.dto.CountryDTO;
import java.util.List;

public interface ICountryService {

    CountryDTO queryCountry (CountryDTO countryDTO);
    List<CountryDTO> queryAllCountries();
    int insertCountry (CountryDTO countryDTO);
    int updateCountry (CountryDTO countryDTO);
    int deleteCountry (CountryDTO countryDTO);

}