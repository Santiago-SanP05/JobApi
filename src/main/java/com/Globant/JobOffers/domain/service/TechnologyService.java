
package com.Globant.JobOffers.domain.service;

import com.Globant.JobOffers.dto.TechnologyDto;
import com.Globant.JobOffers.persistence.entity.Technology;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;


public interface TechnologyService {
    
    List<TechnologyDto> getAllTechnologies();
    ResponseEntity<TechnologyDto> getTechnologyById(Long id);
    ResponseEntity<TechnologyDto> getTechnologyByName(String name);
    
    ResponseEntity<TechnologyDto> saveTechnology(TechnologyDto technologyDto);
//    ResponseEntity<Void> deleteTechnology(Long id);
    
    Optional<Technology> findById(Long id);

    
}
