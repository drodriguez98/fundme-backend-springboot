package com.campusdual.fundme.model.dto.dtopmapper;

// Esta interfaz se utiliza para mapear entre objetos Donation y objetos DonationDTO.

// Utiliza la biblioteca MapStruct para generar implementaciones de mapeo automático entre las dos clases.

import com.campusdual.fundme.model.Donation;
import com.campusdual.fundme.model.dto.DonationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper
public interface DonationMapper {

    DonationMapper INSTANCE = Mappers.getMapper(DonationMapper.class);
    DonationDTO toDTO(Donation donation);
    List<DonationDTO> toDTOList(List<Donation> donations);
    Donation toEntity(DonationDTO donationDTO);

}