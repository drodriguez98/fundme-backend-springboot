package com.campusdual.fundme.api;

// Esta interfaz define métodos que deben ser implementados por un servicio que maneja operaciones relacionadas con países.
// Incluye operaciones para consultar, insertar, actualizar y eliminar países.

import com.campusdual.fundme.model.dto.CountryDTO;
import java.util.List;

public interface ICountryService {

    CountryDTO getCountry(CountryDTO countryDTO);

    List<CountryDTO> getAllCountries();

    int insertCountry (CountryDTO countryDTO);

    int updateCountry (CountryDTO countryDTO);

    int deleteCountry (CountryDTO countryDTO);

}