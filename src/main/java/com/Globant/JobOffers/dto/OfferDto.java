
package com.Globant.JobOffers.dto;

import java.time.LocalDate;
import java.util.List;


public class OfferDto {
    
    private Long id;
    private String tittle;
    private String description;
    private Long idJob;
    private Long idCity;
    private LocalDate datePosted;
    private boolean remote;
    private boolean active;
    private List<TechnologyDto> technologyDto;

    public OfferDto() {
    }

    public OfferDto(String tittle, String description, Long idJob, Long idCity, LocalDate datePosted, boolean remote) {
        this.tittle = tittle;
        this.description = description;
        this.idJob = idJob;
        this.idCity = idCity;
        this.datePosted = datePosted;
        this.remote = remote;
    }
    
    

    public OfferDto(String tittle, String description, Long idJob, Long idCity, boolean remote) {
        this.tittle = tittle;
        this.description = description;
        this.idJob = idJob;
        this.idCity = idCity;
        this.remote = remote;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getIdJob() {
        return idJob;
    }

    public void setIdJob(Long idJob) {
        this.idJob = idJob;
    }

    public Long getIdCity() {
        return idCity;
    }

    public void setIdCity(Long idCity) {
        this.idCity = idCity;
    }

    public LocalDate getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(LocalDate datePosted) {
        this.datePosted = datePosted;
    }

    public boolean isRemote() {
        return remote;
    }

    public void setRemote(boolean remote) {
        this.remote = remote;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<TechnologyDto> getTechnologyDto() {
        return technologyDto;
    }

    public void setTechnologyDto(List<TechnologyDto> technologyDto) {
        this.technologyDto = technologyDto;
    }
    
    
    
    
    
}
