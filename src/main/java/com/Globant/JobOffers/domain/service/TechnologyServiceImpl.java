
package com.Globant.JobOffers.domain.service;

import com.Globant.JobOffers.domain.repository.TechnologyRepository;
import com.Globant.JobOffers.dto.TechnologyDto;
import com.Globant.JobOffers.persistence.entity.Technology;
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
public class TechnologyServiceImpl implements TechnologyService {
    
    private final TechnologyRepository technologyRepository;
    
    @Autowired
    public TechnologyServiceImpl(TechnologyRepository technologyRepository) {
        this.technologyRepository = technologyRepository;
    }
    
    
    // CREATE
    @Transactional
    @Override
    public ResponseEntity<TechnologyDto> saveTechnology(TechnologyDto technologyDto) {
        Optional<Technology> technologyOpt = technologyRepository.findTechnologyByName(technologyDto.getName());
        if(technologyOpt.isPresent()){
            throw new DataInUseException("Name Already in use");
        }
        
        Technology technologySaved = technologyRepository.save(Technology.fromDTO(technologyDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(technologySaved.toDTO());
        
    }
    
    //DELETE
//    @Transactional
//    @Override
//    public ResponseEntity<Void> deleteTechnology(Long id) {
//         Optional<Technology> technologyOpt = technologyRepository.findById(id);
//         if(technologyOpt.isEmpty()){
//            throw new NotFoundException("Technology  not Found with id: " + id);
//        }
//        
//        technologyRepository.deleteById(id);
//        return ResponseEntity.noContent().build();
//
//    }
    
    //GET
    @Transactional
    @Override
    public List<TechnologyDto> getAllTechnologies() {
        List<Technology> technologies = technologyRepository.findAll();
        return technologies.stream().map(Technology::toDTO).collect(Collectors.toList());
    }
    
    @Transactional
    @Override
    public ResponseEntity<TechnologyDto> getTechnologyById(Long id) {
        Optional<Technology> technologyOpt = technologyRepository.findById(id);
        if(technologyOpt.isEmpty()){
            throw new NotFoundException("Technology not Found with id: " + id);
        }
        
        TechnologyDto technologyDto = technologyOpt.get().toDTO();
        return ResponseEntity.ok(technologyDto);  
    }
    
    @Transactional
    @Override
    public ResponseEntity<TechnologyDto> getTechnologyByName(String name) {
        Optional<Technology> technologyOpt = technologyRepository.findTechnologyByName(name);
        if(technologyOpt.isEmpty()){
            throw new NotFoundException("Technology not Found with name: " + name);
        }
        
        TechnologyDto technologyDto = technologyOpt.get().toDTO();
        return ResponseEntity.ok(technologyDto);
        
    }
    
    //FIND
    @Transactional
    @Override
    public Optional<Technology> findById(Long id) {
        return technologyRepository.findTechnologybyById(id);
    }


    
}
