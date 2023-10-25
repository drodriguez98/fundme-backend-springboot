package com.campusdual.fundme.api;

import com.campusdual.fundme.model.Donation;
import com.campusdual.fundme.model.dto.DonationDTO;
import java.util.List;

public interface IDonationService {

    DonationDTO getDonation(DonationDTO donationDTO);
    DonationDTO getDonationById(int donationId);

    List<DonationDTO> getAllDonations();

    int insertDonation (DonationDTO donationDTO);
    int updateDonation (DonationDTO donationDTO);
    int deleteDonation (DonationDTO donationDTO);

    List<Donation> getAllDonationsOrderByDateAddedDesc();
    List<Donation> getDonationsByAuthenticatedUser();

    List<Donation> getTopDonations();
    List<Donation> getLastDonations();

}