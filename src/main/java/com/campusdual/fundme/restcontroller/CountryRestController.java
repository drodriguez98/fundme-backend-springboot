package com.campusdual.fundme.restcontroller;

// Este controlador define rutas y métodos que gestionan las solicitudes relacionadas con los países.
// Utiliza el servicio ICountryService para llevar a cabo operaciones como consultar, insertar, actualizar y eliminar países.

import com.campusdual.fundme.api.ICountryService;
import com.campusdual.fundme.model.dto.CountryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/fundme/controller/rest/countries")
public class CountryRestController {

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