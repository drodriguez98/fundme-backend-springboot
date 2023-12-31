package com.campusdual.fundme.restcontroller;

import com.campusdual.fundme.api.IDonationService;
import com.campusdual.fundme.model.Donation;
import com.campusdual.fundme.model.Project;
import com.campusdual.fundme.model.dto.DonationDTO;
import com.campusdual.fundme.model.dto.ProjectDTO;
import com.campusdual.fundme.model.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/donations")
public class DonationRestController {

    @Autowired
    private IDonationService donationService;

    @PostMapping(value = "/get")
    public DonationDTO queryDonation (@RequestBody DonationDTO donation) { return this.donationService.getDonation(donation); }

    @PostMapping(value="/getByProject")
    public List<Donation> queryDonationsByProject (@RequestBody ProjectDTO project) { return this.donationService.getDonationsByProjectId(project); }

    @PostMapping(value="/getByUser")
    public List<Donation> queryDonationsByUser (@RequestBody UserDTO user) { return this.donationService.getDonationsByUserId(user); }

    @GetMapping(value = "/all")
    public List<DonationDTO> queryAllDonations() { return this.donationService.getAllDonations(); }

    @GetMapping(value="/top")
    public List<DonationDTO> queryTopDonations() { return this.donationService.getTopDonations(); }


    @PostMapping(value = "/add")
    public int insertDonation (@RequestBody DonationDTO donation) { return this.donationService.insertDonation(donation); }

    @PutMapping(value = "/update")
    public int updateDonation (@RequestBody DonationDTO donation) { return this.donationService.updateDonation(donation); }

    @PostMapping(value = "/delete")
    public int deleteDonation (@RequestBody DonationDTO donation) { return this.donationService.deleteDonation(donation); }

}