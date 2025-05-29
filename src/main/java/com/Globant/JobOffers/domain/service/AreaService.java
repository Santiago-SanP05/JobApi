
package com.Globant.JobOffers.domain.service;


import com.Globant.JobOffers.dto.AreaDto;
import com.Globant.JobOffers.persistence.entity.Area;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;


public interface AreaService {
    
    
    List<AreaDto> getAllAreas();
    ResponseEntity<AreaDto> getAreaById(Long id);
    ResponseEntity<AreaDto> getAreaByName(String name);
    
    ResponseEntity<AreaDto> saveArea (AreaDto areaDto);
    ResponseEntity<Void> deleteArea(Long id);
    
    Optional<Area> findById(Long id);
    
    
}
