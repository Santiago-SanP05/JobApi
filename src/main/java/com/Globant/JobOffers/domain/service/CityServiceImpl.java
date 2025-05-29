
package com.Globant.JobOffers.domain.service;

import com.Globant.JobOffers.domain.repository.CityRepository;
import com.Globant.JobOffers.dto.CityDto;
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
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final CountryServiceImpl countryServiceImpl;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository, CountryServiceImpl countryServiceImpl) {
        this.cityRepository = cityRepository;
        this.countryServiceImpl = countryServiceImpl;
    }

    // CREATE
    @Transactional
    @Override
    public ResponseEntity<CityDto> saveCity(CityDto cityDto) {
        Optional<Country> countryOpt = countryServiceImpl.findById(cityDto.getIdCountry());
        if (countryOpt.isEmpty()) {
            throw new NotFoundException("Country not Found with id: " + cityDto.getIdCountry());
        }

        Optional<City> cityOpt = cityRepository.findCityByNameAndCountry(cityDto.getIdCountry(), cityDto.getName());
        if (cityOpt.isPresent()) {
            System.out.println("City was created");
            throw new DataInUseException("The city already exist in this country "+countryOpt.get().getName());
        }

        Country countryEntity = countryOpt.get();
        City citySaved = cityRepository.save(City.fromDTO(cityDto, countryEntity));

        countryEntity.addCity(citySaved);

        return ResponseEntity.status(HttpStatus.CREATED).body(citySaved.toDTO());
    }
    
    
    //DELETE
    @Transactional
    @Override
    public ResponseEntity<Void> deleteCity(Long id) {
        Optional<City> cityOpt = cityRepository.findById(id);
        if(cityOpt.isEmpty()){
            throw new NotFoundException("City  not Found with id: " + id);
        }
        
        Optional<Country> countryOpt = countryServiceImpl.findByCity(cityOpt.get());
        
        countryOpt.get().removeCity(cityOpt.get());
        
        cityRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
    //GET
    @Transactional
    @Override
    public List<CityDto> getAllCities(Long idCountry) {
        Optional<Country> countryOpt = countryServiceImpl.findById(idCountry);
        if (countryOpt.isEmpty()) {
            throw new NotFoundException("Country not Found with id: " + idCountry);
        }
        
        List<City> cities = cityRepository.findCityByCountry(countryOpt.get());
        return cities.stream().map(City::toDTO).collect(Collectors.toList()); 
    
    }
    
    @Transactional
    @Override
    public ResponseEntity<CityDto> getCityById(Long id) {
        Optional<City> cityOpt = cityRepository.findById(id);
        if(cityOpt.isEmpty()){
            throw new NotFoundException("City  not Found with id: " + id);
        }
        
        CityDto cityDto = cityOpt.get().toDTO();
        
        return ResponseEntity.ok(cityDto);
    }
    
    @Transactional
    @Override
    public ResponseEntity<CityDto> getCityByName(String name) {
        Optional<City> cityOpt = cityRepository.findCityByName(name);
        if(cityOpt.isEmpty()){
            throw new NotFoundException("City not Found with name: " + name);
        }
        CityDto cityDto = cityOpt.get().toDTO();
        
        return ResponseEntity.ok(cityDto);
    }

    //FIND
    @Transactional
    @Override
    public Optional<City> findById(Long id) {
        return cityRepository.findCityById(id);
    }

}
