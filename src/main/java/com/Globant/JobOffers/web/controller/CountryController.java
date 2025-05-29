
package com.Globant.JobOffers.web.controller;

import com.Globant.JobOffers.domain.service.CountryServiceImpl;
import com.Globant.JobOffers.dto.CountryDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/country")
public class CountryController {
    
    private final CountryServiceImpl countryServiceImpl;
    
    @Autowired
    public CountryController(CountryServiceImpl countryServiceImpl) {
        this.countryServiceImpl = countryServiceImpl;
    }
    
    //CREATE
    @PostMapping("/create")
    public ResponseEntity<CountryDto> saveCountry(@RequestBody CountryDto countryDto){
        System.out.println("Receiving request to create country");
        return countryServiceImpl.saveCountry(countryDto);
    }
    
    // GET all comments by post ID
    @GetMapping("/all")
    public List<CountryDto> getAllCountries(){
        return countryServiceImpl.getAllCountries();
    }
    
    @GetMapping("/id/{id}")
    public ResponseEntity<CountryDto> getCountryById(@PathVariable Long id){
        return countryServiceImpl.getCountryById(id);
    }
    
    @GetMapping("/name/{name}")
    public ResponseEntity<CountryDto> getCountryByName(@PathVariable String name){
        return countryServiceImpl.getCountryByName(name);
    }
    
    
    
}
