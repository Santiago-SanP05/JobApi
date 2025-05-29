
package com.Globant.JobOffers.domain.service;

import com.Globant.JobOffers.dto.CountryDto;
import com.Globant.JobOffers.persistence.entity.City;
import com.Globant.JobOffers.persistence.entity.Country;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;


public interface CountryService {
    
    List<CountryDto> getAllCountries();
    ResponseEntity<CountryDto> getCountryById(Long id);
    ResponseEntity<CountryDto> getCountryByName(String name);
    
    ResponseEntity<CountryDto> saveCountry (CountryDto countryDto);
    ResponseEntity<Void> deleteCountry(Long id);
    Optional<Country> findById(Long id);
    
    Optional<Country> findByCity(City city);
}
