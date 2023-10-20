package com.campusdual.fundme.api;

// Esta interfaz define métodos que deben ser implementados por un servicio que maneja operaciones relacionadas con donaciones.
// Incluye operaciones para consultar, insertar, actualizar y eliminar donaciones.

import com.campusdual.fundme.model.Donation;
import com.campusdual.fundme.model.Project;
import com.campusdual.fundme.model.dto.DonationDTO;
import java.util.List;

public interface IDonationService {

    DonationDTO getDonation(DonationDTO donationDTO);
    DonationDTO getDonationById(int donation_id);
    List<DonationDTO> getAllDonations();

    int insertDonation (DonationDTO donationDTO);
    int updateDonation (DonationDTO donationDTO);
    int deleteDonation (DonationDTO donationDTO);

    List<Donation> getTopDonations();
    List<Donation> getLastDonations();

}