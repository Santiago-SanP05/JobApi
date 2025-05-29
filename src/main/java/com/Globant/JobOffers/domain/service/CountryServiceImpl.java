
package com.Globant.JobOffers.domain.service;

import com.Globant.JobOffers.domain.repository.CountryRepository;
import com.Globant.JobOffers.dto.CountryDto;
import com.Globant.JobOffers.persistence.entity.*;
import com.Globant.JobOffers.web.exception.DataInUseException;
import com.Globant.JobOffers.web.exception.NotFoundException;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService{
    
    private final CountryRepository countryRepository;
    
    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }
    
    // CREATE
    @Transactional
    @Override
    public ResponseEntity<CountryDto> saveCountry(CountryDto countryDto) {
        
        Optional<Country> countryOpt = countryRepository.findCountryByName(countryDto.getName());
        if(countryOpt.isPresent()){
            throw new DataInUseException("Name Already in use");
        }
        
        
        Country countrySaved = countryRepository.save(Country.fromDTO(countryDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(countrySaved.toDTO());
        
        
    }
    
    //DELETE
    @Transactional
    @Override
    public ResponseEntity<Void> deleteCountry(Long id) {
        
        Optional<Country> countryOpt = countryRepository.findCountryById(id);
        if(countryOpt.isEmpty()){
            throw new NotFoundException("Country  not Found with id: " + id);
        }
        
        countryRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
    //GET
    @Transactional
    @Override
    public List<CountryDto> getAllCountries() {
       List<Country> countries = countryRepository.findAll();
        return countries.stream().map(Country::toDTO).collect(Collectors.toList()); 
    }
    
    @Transactional
    @Override
    public ResponseEntity<CountryDto> getCountryById(Long id) {
        Optional<Country> countryOpt = countryRepository.findCountryById(id);
        if(countryOpt.isEmpty()){
            throw new NotFoundException("Country not Found with id: " + id);
        }
        CountryDto countryDto = countryOpt.get().toDTO();
        
        return ResponseEntity.ok(countryDto);
    }
    
    @Transactional
    @Override
    public ResponseEntity<CountryDto> getCountryByName(String name) {
        
        Optional<Country> countryOpt = countryRepository.findCountryByName(name);
        if(countryOpt.isEmpty()){
            throw new NotFoundException("Country not Found with name: " + name);
        }
        CountryDto countryDto = countryOpt.get().toDTO();
        
        return ResponseEntity.ok(countryDto);
    }
    
    //FIND.........................................................................
    @Transactional
    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findCountryById(id);
    }
    
    @Transactional
    @Override
    public Optional<Country> findByCity(City city) {
        return countryRepository.findByCity(city);
    }

  
}
