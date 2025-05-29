
package com.Globant.JobOffers.persistence.entity;

import com.Globant.JobOffers.dto.TechnologyDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Technology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "technologies")
    @JsonIgnore
    private List<Offer> offers = new ArrayList<>();

    // CONSTRUCTOR
    public Technology() {
    }

    public Technology(String name) {
        this.name = name;
    }

    //GETTERS AND SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // ----------------- LIST FIXED      
    public void addOffer(Offer offer) {
        this.offers.add(offer);
        offer.getTechnologies().add(this);  
    }

    public void removeOffer(Offer offer) {
        this.offers.remove(offer);
        offer.getTechnologies().remove(this);  
    }

    // DTO
    public static Technology fromDTO(TechnologyDto dto) {
        Technology technology = new Technology();
        technology.setId(dto.getId());
        technology.setName(dto.getName());
        return technology;
    }

    public TechnologyDto toDTO() {
        TechnologyDto dto = new TechnologyDto();
        dto.setId(this.id);
        dto.setName(this.name);
        return dto;
    }

}
