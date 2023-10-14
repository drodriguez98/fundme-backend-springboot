package com.campusdual.fundme.model.dao;

// Este archivo define una interfaz que extiende JpaRepository, que proporciona métodos para realizar operaciones de base de datos en la entidad Donation.

import com.campusdual.fundme.model.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationDAO extends JpaRepository<Donation, Integer> {}