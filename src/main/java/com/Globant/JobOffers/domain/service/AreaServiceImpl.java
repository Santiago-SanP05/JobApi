
package com.Globant.JobOffers.domain.service;

import com.Globant.JobOffers.domain.repository.AreaRepository;
import com.Globant.JobOffers.dto.AreaDto;
import com.Globant.JobOffers.persistence.entity.Area;
import com.Globant.JobOffers.web.exception.*;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class AreaServiceImpl implements AreaService {
    
    
    private final AreaRepository areaRepository;
    
    @Autowired
    public AreaServiceImpl (AreaRepository areaRepository){
        this.areaRepository = areaRepository;
    }
    
    
    // CREATE
    @Transactional
    @Override
    public ResponseEntity<AreaDto> saveArea(AreaDto areaDto) {
        
        Optional<Area> areaOpt = areaRepository.findAreaByName(areaDto.getName());
        if(areaOpt.isPresent()){
            throw new DataInUseException("Name Already in use");
        }
        
        Area areaSaved = areaRepository.save(Area.fromDTO(areaDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(areaSaved.toDTO());
        
    }
    
    
    //DELETE
    @Transactional
    @Override
    public ResponseEntity<Void> deleteArea(Long id) {
        
        Optional<Area> areaOpt = areaRepository.findAreaById(id);
        if(areaOpt.isEmpty()){
            throw new NotFoundException("Area not Found with id: " + id);
        }
        
        areaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
    
    //GET
    
    @Transactional
    @Override
    public List<AreaDto> getAllAreas() {
        List<Area> areas = areaRepository.findAll();
        return areas.stream().map(Area::toDTO).collect(Collectors.toList());
        
    }
    
    @Transactional
    @Override
    public ResponseEntity<AreaDto> getAreaById(Long id) {
        
        Optional<Area> areaOpt = areaRepository.findAreaById(id);
        if(areaOpt.isEmpty()){
            throw new NotFoundException("Area not Found with id: " + id);
        }
        AreaDto areaDto = areaOpt.get().toDTO();
        
        return ResponseEntity.ok(areaDto);   
    }
    
    
    @Transactional
    @Override
    public ResponseEntity<AreaDto> getAreaByName(String name) {
        
        Optional<Area> areaOpt = areaRepository.findAreaByName(name);
        if(areaOpt.isEmpty()){
            throw new NotFoundException("Area not Found with name: " + name);
        }
        AreaDto areaDto = areaOpt.get().toDTO();
        
        return ResponseEntity.ok(areaDto); 
    }
    
    
    //FIND
    @Transactional
    @Override
    public Optional<Area> findById(Long id) {
        return areaRepository.findAreaById(id);
    }

  
    
}
