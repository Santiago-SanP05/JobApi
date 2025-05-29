
package com.Globant.JobOffers.domain.repository;

import com.Globant.JobOffers.persistence.entity.*;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface CityRepository extends JpaRepository<City, Long> {

    Optional<City> findCityById(Long id);

    Optional<City> findCityByName(String name);

    List<City> findCityByCountry(Country country);

    @Query("SELECT c FROM City c "
            + "WHERE c.country.id = :countryId "
            + "AND c.name = :name")
    Optional<City> findCityByNameAndCountry(@Param("countryId") Long countryId, @Param("name") String name);

}
