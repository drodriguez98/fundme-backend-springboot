package com.campusdual.fundme.model.repository;

import com.campusdual.fundme.model.Donation;
import com.campusdual.fundme.model.Project;
import com.campusdual.fundme.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DonationRepository extends JpaRepository<Donation, Integer> {

    List<Donation> findTop5ByOrderByAmountDesc();
    List<Donation> findTop5ByOrderByDateAddedDesc();
    List<Donation> findByUserIdOrderByDateAddedDesc(User user);
    public List<Donation> getAllDonationsByOrderByDateAddedDesc();
    List<Donation> findByProjectIdOrderByDateAddedDesc(Project project);

}