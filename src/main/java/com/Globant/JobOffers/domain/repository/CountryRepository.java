
package com.Globant.JobOffers.domain.repository;

import com.Globant.JobOffers.persistence.entity.City;
import com.Globant.JobOffers.persistence.entity.Country;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface CountryRepository extends JpaRepository<Country, Long>{
    
    Optional<Country> findCountryById(Long id);
    Optional<Country> findCountryByName(String name);
    @Query("SELECT c FROM Country c JOIN c.cities ci WHERE ci = :city")
    Optional<Country> findByCity(@Param("city") City city);
    
}
