package com.campusdual.fundme.restcontroller;

import com.campusdual.fundme.api.IDonationService;
import com.campusdual.fundme.model.dto.DonationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/fundme/controller/rest/donations")
public class DonationRestController {

    @Autowired
    private IDonationService donationService;

    @PostMapping(value = "/get")
    public DonationDTO queryDonation (@RequestBody DonationDTO donation) { return this.donationService.getDonation(donation); }

    @GetMapping(value = "/all")
    public List<DonationDTO> queryAllDonations() { return this.donationService.getAllDonations(); }

    @PostMapping(value = "/add")
    public int insertDonation (@RequestBody DonationDTO donation) { return this.donationService.insertDonation(donation); }

    @PutMapping(value = "/update")
    public int updateDonation (@RequestBody DonationDTO donation) { return this.donationService.updateDonation(donation); }

    @PostMapping(value = "/delete")
    public int deleteDonation (@RequestBody DonationDTO donation) { return this.donationService.deleteDonation(donation); }

}