
package com.Globant.JobOffers.web.controller;

import com.Globant.JobOffers.domain.service.TechnologyServiceImpl;
import com.Globant.JobOffers.dto.TechnologyDto;
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
@RequestMapping("/api/technology")
public class TechnologyController {
    
    private final TechnologyServiceImpl technologyServiceImpl;
    
    @Autowired
    public TechnologyController(TechnologyServiceImpl technologyServiceImpl) {
        this.technologyServiceImpl = technologyServiceImpl;
    }
    
    //CREATE
    @PostMapping("/create")
    public ResponseEntity<TechnologyDto> saveTechnology(@RequestBody TechnologyDto technologyDto){
        System.out.println("Receiving request to create technology ");
        return technologyServiceImpl.saveTechnology(technologyDto);
    }
    
    // GET 
    @GetMapping("/all")
    public List<TechnologyDto> getAllTechnologies(){
        return technologyServiceImpl.getAllTechnologies();
    }
    
    @GetMapping("/id/{id}")
    public ResponseEntity<TechnologyDto> getTechnologyById(@PathVariable Long id){
        return technologyServiceImpl.getTechnologyById(id);
    }
    
    @GetMapping("/name/{name}")
    public ResponseEntity<TechnologyDto> getTechnologyByName(@PathVariable String name){
        return technologyServiceImpl.getTechnologyByName(name);
    }
}
