package com.campusdual.fundme.model.dto.dtopmapper;

// Esta interfaz se utiliza para mapear entre objetos Country y objetos CountryDTO.

// Utiliza la biblioteca MapStruct para generar implementaciones de mapeo automático entre las dos clases.
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