
package com.Globant.JobOffers.domain.service;

import com.Globant.JobOffers.dto.CityDto;
import com.Globant.JobOffers.persistence.entity.City;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;


public interface CityService {
    
    List<CityDto> getAllCities(Long idCountry);
    ResponseEntity<CityDto> getCityById(Long id);
    ResponseEntity<CityDto> getCityByName(String name);
    
    ResponseEntity<CityDto> saveCity (CityDto cityDto);
    ResponseEntity<Void> deleteCity(Long id);
    Optional<City> findById(Long id);
}
