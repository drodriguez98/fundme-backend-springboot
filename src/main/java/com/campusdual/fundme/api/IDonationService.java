package com.campusdual.fundme.api;

import com.campusdual.fundme.model.dto.DonationDTO;
import java.util.List;

public interface IDonationService {

    DonationDTO queryDonation (DonationDTO donationDTO);
    List<DonationDTO> queryAllDonations();
    int insertDonation (DonationDTO donationDTO);
    int updateDonation (DonationDTO donationDTO);
    int deleteDonation (DonationDTO donationDTO);

}