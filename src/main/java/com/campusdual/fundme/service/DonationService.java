package com.campusdual.fundme.service;

import com.campusdual.fundme.api.IDonationService;
import com.campusdual.fundme.model.Donation;
import com.campusdual.fundme.model.repository.DonationRepository;
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
    private DonationRepository donationRepository;

    @Override
    public DonationDTO getDonation(DonationDTO donationDTO) {

        Donation donation = DonationMapper.INSTANCE.toEntity(donationDTO);
        return DonationMapper.INSTANCE.toDTO(this.donationRepository.getReferenceById(donation.getDonation_id()));

    }

    @Override
    public DonationDTO getDonationById(int donation_id) {

        Donation donation = donationRepository.getReferenceById(donation_id);
        return DonationMapper.INSTANCE.toDTO(donation);

    }

    @Override
    public List<DonationDTO> getAllDonations() { return DonationMapper.INSTANCE.toDTOList(donationRepository.findAll()); }

    @Override
    public int insertDonation (DonationDTO donationDTO) {

        Donation donation = DonationMapper.INSTANCE.toEntity(donationDTO);
        this.donationRepository.saveAndFlush(donation);
        return donation.getDonation_id();


    }
    @Override
    public int updateDonation (DonationDTO donationDTO) { return this.insertDonation(donationDTO); }

    @Override
    public int deleteDonation (DonationDTO donationDTO) {

        int id = donationDTO.getDonation_id();
        Donation donation = DonationMapper.INSTANCE.toEntity(donationDTO);
        this.donationRepository.delete(donation);
        return id;

    }

    public List<Donation> getTopDonations() { return donationRepository.findTop5ByOrderByAmountDesc(); }

    public List<Donation> getLastDonations() { return donationRepository.findTop5ByOrderByDateAddedDesc(); }

}