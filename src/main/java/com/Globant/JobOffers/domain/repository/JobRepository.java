
package com.Globant.JobOffers.domain.repository;

import com.Globant.JobOffers.persistence.entity.*;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface JobRepository  extends JpaRepository<Job, Long>{
    

    
    Optional<Job> findJobById(Long id);
    Optional<Job> findJobByName(String name);
    
    @Query("SELECT j FROM Job j "
            + "WHERE j.area.id = :areaId "
            + "AND j.name = :name")
    Optional<Job> findJobByNameAndArea(@Param("areaId") Long areaId, @Param("name") String name);

    List<Job> findJobByArea(Area area);
}
