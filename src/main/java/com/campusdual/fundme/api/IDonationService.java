package com.campusdual.fundme.api;

import com.campusdual.fundme.model.Donation;
import com.campusdual.fundme.model.dto.DonationDTO;
import java.util.List;

public interface IDonationService {

    DonationDTO getDonationById(int donation_id);

    DonationDTO getDonation(DonationDTO donationDTO);
    List<DonationDTO> getAllDonations();

    int insertDonation (DonationDTO donationDTO);
    int updateDonation (DonationDTO donationDTO);
    int deleteDonation (DonationDTO donationDTO);

    List<Donation> getTopDonations();
    List<Donation> getLastDonations();

}