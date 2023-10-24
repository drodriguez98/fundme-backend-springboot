package com.campusdual.fundme.service;

import com.campusdual.fundme.api.IDonationService;
import com.campusdual.fundme.model.Donation;
import com.campusdual.fundme.model.User;
import com.campusdual.fundme.model.repository.DonationRepository;
import com.campusdual.fundme.model.dto.DonationDTO;
import com.campusdual.fundme.model.dto.dtopmapper.DonationMapper;

import com.campusdual.fundme.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("DonationService")
@Lazy
public class DonationService implements IDonationService {

    @Autowired
    private DonationRepository donationRepository;

    @Autowired
    private UserRepository userRepository;

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

    public List<Donation> getAllDonationsOrderByDateAddedDesc() {

        Sort sort = Sort.by(Sort.Direction.DESC, "dateAdded");

        return donationRepository.findAll(sort);

    }

    @Override
    public List<Donation> getDonationsByAuthenticatedUser() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null) { throw new RuntimeException("Ningún usuario autenticado."); }

        String username = authentication.getName();

        User authenticatedUser = userRepository.findByUsername(username);

        if (authenticatedUser == null) { throw new RuntimeException("Usuario autenticado no encontrado."); }

        return donationRepository.findByUserId(authenticatedUser);
    }

    public List<Donation> getTopDonations() { return donationRepository.findTop5ByOrderByAmountDesc(); }

    public List<Donation> getLastDonations() { return donationRepository.findTop5ByOrderByDateAddedDesc(); }

}