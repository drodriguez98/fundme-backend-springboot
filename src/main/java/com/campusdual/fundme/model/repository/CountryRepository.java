package com.campusdual.fundme.model.repository;

import com.campusdual.fundme.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {}