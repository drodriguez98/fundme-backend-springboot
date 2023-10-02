package com.campusdual.fundme.service;

import com.campusdual.fundme.api.IDonationService;
import com.campusdual.fundme.model.dao.DonationDAO;
import com.campusdual.fundme.model.dto.DonationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("DonationService")
@Lazy
public class DonationService implements IDonationService {

    @Autowired
    private DonationDAO donationDAO;

    @Override
    public DonationDTO queryDonation (DonationDTO donationDTO) { return null; }
    @Override
    public List<DonationDTO> queryAllDonations() { return null; }
    @Override
    public int insertDonation (DonationDTO donationDTO) { return 0; }
    @Override
    public int updateDonation (DonationDTO donationDTO) { return 0; }
    @Override
    public int deleteDonation (DonationDTO donationDTO) { return 0; }

}