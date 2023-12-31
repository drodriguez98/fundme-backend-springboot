package com.campusdual.fundme.api;

import com.campusdual.fundme.model.Donation;
import com.campusdual.fundme.model.dto.DonationDTO;
import com.campusdual.fundme.model.dto.ProjectDTO;
import com.campusdual.fundme.model.dto.UserDTO;

import java.util.List;

public interface IDonationService {

    DonationDTO getDonation(DonationDTO donationDTO);
    DonationDTO getDonationById(int donationId);
    List<DonationDTO> getAllDonations();

    int insertDonation (DonationDTO donationDTO);
    int updateDonation (DonationDTO donationDTO);
    int deleteDonation (DonationDTO donationDTO);

    List<Donation> getAllDonationsByOrderByDateAddedDesc();
    // List<Donation> getDonationsByAuthenticatedUserOrderByDateAddedDesc();
    List<DonationDTO> getTopDonations();
    List<Donation> getLastDonations();

    List<Donation> getDonationsByProjectId(ProjectDTO projectDTO);

    List<Donation> getDonationsByUserId(UserDTO userDTO);

    int getTotalDonationsByUser(int userId);

    int getDonationCountByUser(int userId);

}