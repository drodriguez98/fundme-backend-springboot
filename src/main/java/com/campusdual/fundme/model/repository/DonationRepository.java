package com.campusdual.fundme.model.repository;

import com.campusdual.fundme.model.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DonationRepository extends JpaRepository<Donation, Integer> {

    List<Donation> findTop10ByOrderByAmountDesc();
    List<Donation> findTop10ByOrderByDateAddedDesc();

}