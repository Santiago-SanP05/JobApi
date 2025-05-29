
package com.Globant.JobOffers.web.controller;

import com.Globant.JobOffers.domain.service.CityServiceImpl;
import com.Globant.JobOffers.dto.CityDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/city")
public class CityController {
    
    private final CityServiceImpl cityServiceImpl;
    
    @Autowired
    public CityController(CityServiceImpl cityServiceImpl) {
        this.cityServiceImpl = cityServiceImpl;
    }
    
    //CREATE
    @PostMapping("/create")
    public ResponseEntity<CityDto> saveCity(@RequestBody CityDto cityDto){
        System.out.println("Receiving request to create city");
        return cityServiceImpl.saveCity(cityDto);
    }
    
    // GET all comments by post ID
    @GetMapping("/all/{idCountry}")
    public List<CityDto> getAllCities(@PathVariable Long idCountry){
        return cityServiceImpl.getAllCities(idCountry);
    }
    
    @GetMapping("/id/{id}")
    public ResponseEntity<CityDto> getCityById(@PathVariable Long id){
        return cityServiceImpl.getCityById(id);
    }
    
    @GetMapping("/name/{name}")
    public ResponseEntity<CityDto> getCityByName(@PathVariable String name){
        return cityServiceImpl.getCityByName(name);
    }
    
    
}
