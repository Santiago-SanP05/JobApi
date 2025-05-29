
package com.Globant.JobOffers.domain.service;

import com.Globant.JobOffers.dto.OfferDto;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface OfferService {
    
    ResponseEntity<OfferDto> saveOffer (OfferDto offerDto);
    Boolean addTechnology(Long id, Long idTechnology);
    Boolean removeTechnology(Long id, Long idTechnology);
    Boolean updateActive (Long id);
    List<OfferDto> getAllOffers();
    List<OfferDto> getAllOffersFilter(Long areaId, Long cityId, Boolean remote);
    Boolean addTechnologies(Long id, List<Long> idTechnologies);
    Boolean removeTechnologies(Long id, List<Long> idTechnologies);
    
}
