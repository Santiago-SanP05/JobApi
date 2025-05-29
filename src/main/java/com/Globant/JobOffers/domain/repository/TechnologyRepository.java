
package com.Globant.JobOffers.domain.repository;

import com.Globant.JobOffers.persistence.entity.*;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TechnologyRepository extends JpaRepository<Technology, Long>{
        

    Optional<Technology> findTechnologybyById(Long id);
    Optional<Technology> findTechnologyByName(String name);
    
    
    
    
}
