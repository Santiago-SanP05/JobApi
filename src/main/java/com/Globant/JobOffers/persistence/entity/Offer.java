
package com.Globant.JobOffers.persistence.entity;

import com.Globant.JobOffers.dto.OfferDto;
import com.Globant.JobOffers.dto.TechnologyDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.UniqueConstraint;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Entity
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tittle;

    private String description;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Job job;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private City city;

    private LocalDate datePosted;

    private Boolean remote;

    private Boolean active;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "offer_technology", 
            joinColumns = @JoinColumn(name = "offer_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "technology_id", referencedColumnName = "id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"offer_id", "technology_id"})
    )
    private List<Technology> technologies = new ArrayList<>();

    //CONSTRUCTOR
    public Offer() {
    }

    public Offer(String tittle, String description, Job job, City city, LocalDate datePosted, boolean remote, boolean active) {
        this.tittle = tittle;
        this.description = description;
        this.job = job;
        this.city = city;
        this.datePosted = datePosted;
        this.remote = remote;
        this.active = active;
    }

    // GETTERS AND SETTERS
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

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public LocalDate getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(LocalDate datePosted) {
        this.datePosted = datePosted;
    }

    public Boolean getRemote() {
        return remote;
    }

    public void setRemote(Boolean remote) {
        this.remote = remote;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<Technology> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<Technology> technologies) {
        this.technologies = technologies;
    }
    
    

    // ----------------- LIST FIXED      
    public void addTechnology(Technology technology) {
        this.technologies.add(technology);
        
    }

    public void removeTechnology(Technology technology) { 
        this.technologies.remove(technology);
        
    }
    
    // ----------------- DTO

    public static Offer fromDTO(OfferDto dto, Job jobEntity,City cityEntity){
        Offer offer = new Offer();
        offer.setId(dto.getId());
        offer.setTittle(dto.getTittle());
        offer.setDescription(dto.getDescription());
        offer.setJob(jobEntity);
        offer.setCity(cityEntity);
        offer.setDatePosted(LocalDate.now());
        offer.setRemote(dto.isRemote());
        offer.setActive(true);
        return offer;
    }

    public OfferDto toDTO(){
        OfferDto dto = new OfferDto();
        dto.setId(this.id);
        dto.setTittle(this.tittle);
        dto.setDescription(this.description);
        dto.setIdJob(this.job.getId());
        dto.setIdCity(this.city.getId());
        dto.setDatePosted(this.datePosted);
        dto.setRemote(this.remote);
        dto.setActive(this.active);
        
        
        // Aquí convertimos la lista de Likes a LikeCommentDto
        List<TechnologyDto> technologyDtoList = this.technologies.stream()
                .map(technology -> technology.toDTO())
                .collect(Collectors.toList());
        
        // Establecemos la lista convertida en commentDto
        dto.setTechnologyDto(technologyDtoList);
        return dto;
    }
}
