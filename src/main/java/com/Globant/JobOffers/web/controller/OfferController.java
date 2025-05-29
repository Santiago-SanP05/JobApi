
package com.Globant.JobOffers.web.controller;

import com.Globant.JobOffers.domain.service.OfferServiceImpl;
import com.Globant.JobOffers.dto.OfferDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/offer")
public class OfferController {

    private final OfferServiceImpl offerServiceImpl;

    @Autowired
    public OfferController(OfferServiceImpl offerServiceImpl) {
        this.offerServiceImpl = offerServiceImpl;
    }

    //CREATE
    @PostMapping("/create")
    public ResponseEntity<OfferDto> saveOffer(@RequestBody OfferDto offerDto) {
        System.out.println("Receiving request to create offer");
        return offerServiceImpl.saveOffer(offerDto);

    }

    //UPDATE
    @PatchMapping("/add/technology/{id}")
    public Boolean addTechnology(@PathVariable Long id, @RequestParam Long idTechnology) {
        return offerServiceImpl.addTechnology(id, idTechnology);
    }

    @PatchMapping("/add/technologies/{id}")
    public Boolean addTechnologies(@PathVariable Long id, @RequestBody List<Long> idTechnologies) {
        return offerServiceImpl.addTechnologies(id, idTechnologies);
    }

    //UPDATE
    @PatchMapping("/remove/technology/{id}")
    public Boolean removeTechnology(@PathVariable Long id, @RequestParam Long idTechnology) {
        return offerServiceImpl.removeTechnology(id, idTechnology);
    }


    @PatchMapping("/remove/technologies/{id}")
    public Boolean removeTechnologies(@PathVariable Long id, @RequestBody List<Long> idTechnologies) {
        return offerServiceImpl.removeTechnologies(id, idTechnologies);
    }

    //UPDATE
    @PatchMapping("/update/active/{id}")
    public Boolean updateActive(@PathVariable Long id) {
        return offerServiceImpl.updateActive(id);
    }

    //GET
    @GetMapping("/all")
    public List<OfferDto> getAllOffers() {
        return offerServiceImpl.getAllOffers();

    }

    @GetMapping("/filter")
    public List<OfferDto> getAllOffers(
            @RequestParam(required = false) Long areaId,
            @RequestParam(required = false) Long cityId,
            @RequestParam(required = false) Boolean remote) {
        return offerServiceImpl.getAllOffersFilter(areaId, cityId, remote);
    }

}
