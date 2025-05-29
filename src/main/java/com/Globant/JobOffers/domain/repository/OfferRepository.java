
package com.Globant.JobOffers.domain.repository;

import com.Globant.JobOffers.persistence.entity.*;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface OfferRepository extends JpaRepository<Offer, Long> {

    Optional<Offer> findOfferbyById(Long id);

    Optional<Offer> findOfferByTittle(String tittle);

    @Query("SELECT t FROM Technology t "
            + "WHERE t.id = :techId "
            + "AND EXISTS (SELECT 1 FROM Offer o JOIN o.technologies ot "
            + "             WHERE o.id = :offerId AND ot.id = t.id)")
    Optional<Technology> findTechnologiesByOfferAndTechId(@Param("offerId") Long offerId, @Param("techId") Long techId);

    @Query("SELECT o FROM Offer o WHERE o.active = TRUE")
    List<Offer> findAllOffersActive();

    @Query("SELECT o FROM Offer o "
            + "WHERE o.active = TRUE "
            + "AND (:areaId IS NULL OR o.job.area.id = :areaId) "
            + "AND (o.city.id = 1 OR :cityId IS NULL OR o.city.id = :cityId) "
            + "AND (:remote IS NULL OR o.remote = :remote)")
    List<Offer> findAllOffers(
            @Param("areaId") Long areaId,
            @Param("cityId") Long cityId,
            @Param("remote") Boolean remote);

}
