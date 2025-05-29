
package com.Globant.JobOffers.domain.repository;

import com.Globant.JobOffers.persistence.entity.*;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;



public interface AreaRepository extends JpaRepository<Area, Long>{
   
    
    Optional<Area> findAreaById(Long id);
    Optional<Area> findAreaByName(String name);

    
}
