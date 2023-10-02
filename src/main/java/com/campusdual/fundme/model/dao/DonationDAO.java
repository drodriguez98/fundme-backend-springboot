package com.campusdual.fundme.model.dao;

import com.campusdual.fundme.model.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationDAO extends JpaRepository<Donation, Integer> {}