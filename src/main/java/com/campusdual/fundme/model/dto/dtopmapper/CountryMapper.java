package com.campusdual.fundme.model.dto.dtopmapper;

import com.campusdual.fundme.model.Country;
import com.campusdual.fundme.model.dto.CountryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper
public interface CountryMapper {

    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);

    CountryDTO toDTO(Country country);

    List<CountryDTO> toDTOList(List<Country> countries);

    Country toEntity(CountryDTO countryDTO);

}