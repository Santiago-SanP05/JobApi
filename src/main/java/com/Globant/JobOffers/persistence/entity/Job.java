
package com.Globant.JobOffers.persistence.entity;

import com.Globant.JobOffers.dto.JobDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class Job {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String name;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Area area;

    
    //CONSTRUCTOR
    public Job() {
    }

    public Job(String name, Area area) {
        this.name = name;
        this.area = area;
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

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
    
    // DTO
    public static Job fromDTO(JobDto dto, Area areaEntity){
        Job job = new Job();
        job.setId(dto.getId());
        job.setName(dto.getName());
        job.setArea(areaEntity);
        return job;
    }
    
     public JobDto toDTO(){
        JobDto dto = new JobDto();
        dto.setId(this.id);
        dto.setName(this.name);
        dto.setIdArea(this.area.getId());
        return dto;
    }   
    
    
    
}
