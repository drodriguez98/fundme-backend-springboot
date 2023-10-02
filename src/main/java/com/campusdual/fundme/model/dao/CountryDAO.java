package com.campusdual.fundme.model.dao;

import com.campusdual.fundme.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryDAO extends JpaRepository<Country, Integer> {}