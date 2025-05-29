
package com.Globant.JobOffers.web.controller;

import com.Globant.JobOffers.domain.service.AreaServiceImpl;
import com.Globant.JobOffers.dto.AreaDto;
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
@RequestMapping("/api/area")
public class AreaController {
    
    private final AreaServiceImpl areaServiceImpl;
    
    @Autowired
    public AreaController(AreaServiceImpl areaServiceImpl) {
        this.areaServiceImpl = areaServiceImpl;
    }
    
    
    //CREATE
    @PostMapping("/create")
    public ResponseEntity<AreaDto> createArea(@RequestBody AreaDto createAreaDto){
        System.out.println("Receiving request to create area ");
        return areaServiceImpl.saveArea(createAreaDto);
        
    }

    // GET 
    @GetMapping("/all")
    public List<AreaDto> getAllAreas(){
        return areaServiceImpl.getAllAreas();
    }
    
    @GetMapping("/id/{id}")
    public ResponseEntity<AreaDto> getAreaById(@PathVariable Long id) {
        return areaServiceImpl.getAreaById(id);
    }
    
    @GetMapping("/name/{name}")
    public ResponseEntity<AreaDto> getAreaByName(@PathVariable String name){
        return areaServiceImpl.getAreaByName(name);
    }
    
    
    
}
