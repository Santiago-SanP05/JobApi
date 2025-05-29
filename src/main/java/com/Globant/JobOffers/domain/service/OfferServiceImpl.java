
package com.Globant.JobOffers.domain.service;

import com.Globant.JobOffers.domain.repository.OfferRepository;
import com.Globant.JobOffers.dto.OfferDto;
import com.Globant.JobOffers.persistence.entity.City;
import com.Globant.JobOffers.persistence.entity.Job;
import com.Globant.JobOffers.persistence.entity.Offer;
import com.Globant.JobOffers.persistence.entity.Technology;
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
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final TechnologyServiceImpl technologyServiceImpl;
    private final JobServiceImpl jobServiceImpl;
    private final CityServiceImpl cityServiceImpl;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository, TechnologyServiceImpl technologyServiceImpl, JobServiceImpl jobServiceImpl, CityServiceImpl cityServiceImpl) {
        this.offerRepository = offerRepository;
        this.technologyServiceImpl = technologyServiceImpl;
        this.jobServiceImpl = jobServiceImpl;
        this.cityServiceImpl = cityServiceImpl;
    }

    // CREATE
    @Transactional
    @Override
    public ResponseEntity<OfferDto> saveOffer(OfferDto offerDto) {
        Optional<Job> jobOpt = jobServiceImpl.findById(offerDto.getIdJob());
        if (jobOpt.isEmpty()) {
            throw new NotFoundException("Job  not Found with id: " + offerDto.getIdJob());
        }

        Optional<City> cityOpt = cityServiceImpl.findById(offerDto.getIdCity());
        if (cityOpt.isEmpty()) {
            throw new NotFoundException("City  not Found with id: " + offerDto.getIdCity());
        }

        Job jobEntity = jobOpt.get();
        City cityEntity = cityOpt.get();
        Offer offerSaved = offerRepository.save(Offer.fromDTO(offerDto, jobEntity, cityEntity));
        return ResponseEntity.status(HttpStatus.CREATED).body(offerSaved.toDTO());

    }

    //ADD TECHNOLOGY
    @Transactional
    @Override
    public Boolean addTechnology(Long id, Long idTechnology) {
        if (id == null || idTechnology == null) {
            throw new IllegalArgumentException("ID and Technology ID cannot be null");
        }
        Optional<Offer> offerOpt = offerRepository.findById(id);
        if (offerOpt.isEmpty()) {
            throw new NotFoundException("Offer not Found with id: " + id);
        }

        Optional<Technology> technologyOpt = technologyServiceImpl.findById(idTechnology);
        if (technologyOpt.isEmpty()) {
            throw new NotFoundException("Technology not Found with id: " + id);
        }

        Offer offer = offerOpt.get();
        offer.addTechnology(technologyOpt.get());
        offerRepository.save(offer);
        return true;

    }

    //ADD TECHNOLOGIES
    @Transactional
    @Override
    public Boolean addTechnologies(Long id, List<Long> idTechnologies) {
        if (id == null || idTechnologies == null || idTechnologies.isEmpty()) {
            throw new IllegalArgumentException("ID and Technology IDs cannot be null or empty");
        }
        Optional<Offer> offerOpt = offerRepository.findById(id);
        if (offerOpt.isEmpty()) {
            throw new NotFoundException("Offer not Found with id: " + id);
        }

        Offer offer = offerOpt.get();

        for (Long idTechnology : idTechnologies) {
            Optional<Technology> technologyOpt = technologyServiceImpl.findById(idTechnology);
            if (technologyOpt.isEmpty()) {
                throw new NotFoundException("Technology not Found with id: " + idTechnology);
            }

            Technology technology = technologyOpt.get();

            // Check if the technology already exists in the offer
            if (offer.getTechnologies().contains(technology)) {
                throw new IllegalArgumentException("Technology with id: " + idTechnology + " already exists in the offer");
            }

            offer.addTechnology(technology);
        }

        offerRepository.save(offer);
        return true;
    }

    //REMOVE TECHNOLOGY
    @Transactional
    @Override
    public Boolean removeTechnology(Long id, Long idTechnology) {
        if (id == null || idTechnology == null) {
            throw new IllegalArgumentException("ID and Technology ID cannot be null");
        }
        Optional<Offer> offerOpt = offerRepository.findById(id);
        if (offerOpt.isEmpty()) {
            throw new NotFoundException("Offer not Found with id: " + id);
        }
        Optional<Technology> technologyOpt = offerRepository.findTechnologiesByOfferAndTechId(id, idTechnology);
        if (technologyOpt.isEmpty()) {
            throw new NotFoundException("Technology not Found with id: " + id + " in this offer");
        }

        Offer offer = offerOpt.get();
        offer.removeTechnology(technologyOpt.get());
        offerRepository.save(offer);
        return true;
    }

    //REMOVE TECHNOLOGIES
    @Transactional
    @Override
    public Boolean removeTechnologies(Long id, List<Long> idTechnologies) {
        if (id == null || idTechnologies == null || idTechnologies.isEmpty()) {
            throw new IllegalArgumentException("ID and Technology IDs cannot be null or empty");
        }
        Optional<Offer> offerOpt = offerRepository.findById(id);
        if (offerOpt.isEmpty()) {
            throw new NotFoundException("Offer not Found with id: " + id);
        }

        Offer offer = offerOpt.get();

        for (Long idTechnology : idTechnologies) {
            Optional<Technology> technologyOpt = offerRepository.findTechnologiesByOfferAndTechId(id, idTechnology);
            if (technologyOpt.isEmpty()) {
                throw new NotFoundException("Technology not Found with id: " + idTechnology + " in this offer");
            }

            Technology technology = technologyOpt.get();
            offer.removeTechnology(technology);
        }

        offerRepository.save(offer);
        return true;
    }

    //UPDATE ACTIVE
    @Transactional
    @Override
    public Boolean updateActive(Long id) {
        Optional<Offer> offerOpt = offerRepository.findById(id);
        if (offerOpt.isEmpty()) {
            throw new NotFoundException("Offer not Found with id: " + id);
        }

        Offer offer = offerOpt.get();

        if (offer.getActive().equals(Boolean.TRUE)) {
            offer.setActive(Boolean.FALSE);
        } else {
            offer.setActive(Boolean.TRUE);
        }

        offerRepository.save(offer);
        return offer.getActive();
    }

    //GET ALL
    @Transactional
    @Override
    public List<OfferDto> getAllOffers() {
        List<Offer> offers = offerRepository.findAllOffersActive();
        return offers.stream().map(Offer::toDTO).collect(Collectors.toList());
    }

    //GET ALL WITH FILTERS
    @Transactional
    @Override
    public List<OfferDto> getAllOffersFilter(Long areaId, Long cityId, Boolean remote) {
        List<Offer> offers = offerRepository.findAllOffers(areaId, cityId, remote);
        return offers.stream().map(Offer::toDTO).collect(Collectors.toList());
    }



}

