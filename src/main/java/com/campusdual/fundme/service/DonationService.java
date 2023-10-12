package com.campusdual.fundme.service;

import com.campusdual.fundme.api.IDonationService;
import com.campusdual.fundme.model.Donation;
import com.campusdual.fundme.model.dao.DonationDAO;
import com.campusdual.fundme.model.dto.DonationDTO;
import com.campusdual.fundme.model.dto.dtopmapper.DonationMapper;
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
    public DonationDTO queryDonation (DonationDTO donationDTO) {

        Donation donation = DonationMapper.INSTANCE.toEntity(donationDTO);
        return DonationMapper.INSTANCE.toDTO(this.donationDAO.getReferenceById(donation.getDonation_id()));

    }

    @Override
    public List<DonationDTO> queryAllDonations() { return DonationMapper.INSTANCE.toDTOList(donationDAO.findAll()); }

    @Override
    public int insertDonation (DonationDTO donationDTO) {

        Donation donation = DonationMapper.INSTANCE.toEntity(donationDTO);
        this.donationDAO.saveAndFlush(donation);
        return donation.getDonation_id();


    }
    @Override
    public int updateDonation (DonationDTO donationDTO) { return this.insertDonation(donationDTO); }

    @Override
    public int deleteDonation (DonationDTO donationDTO) {

        int id = donationDTO.getDonation_id();
        Donation donation = DonationMapper.INSTANCE.toEntity(donationDTO);
        this.donationDAO.delete(donation);
        return id;

    }

}