package com.campusdual.fundme.controller;

import com.campusdual.fundme.api.ICountryService;
import com.campusdual.fundme.model.dto.CountryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/private/countries")
public class CountryController {

    @Autowired
    private ICountryService countryService;

    @PostMapping(value = "/get")
    public CountryDTO queryCountry (@RequestBody CountryDTO country) { return this.countryService.queryCountry(country); }

    @GetMapping(value = "/all")
    public List<CountryDTO> queryAllCountries() { return this.countryService.queryAllCountries(); }

    @PostMapping(value = "/add")
    public int insertCountry (@RequestBody CountryDTO country) { return this.countryService.insertCountry(country); }

    @PutMapping(value = "/update")
    public int updateCountry (@RequestBody CountryDTO country) { return this.countryService.updateCountry(country); }

    @PostMapping(value = "/delete")
    public int deleteCountry (@RequestBody CountryDTO country) { return this.countryService.deleteCountry(country); }

}