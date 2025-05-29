
package com.Globant.JobOffers.persistence.entity;

import com.Globant.JobOffers.dto.AreaDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Area {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String name;
    
    
    // CONSTRUCTOR

    public Area() {
    }
    public Area(String name) {
        this.name = name;
    }
    

    // GETTERS AND SETTERS

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
    
    // DTO
    public static Area fromDTO(AreaDto dto){
        Area area = new Area();
        area.setId(dto.getId());
        area.setName(dto.getName());
        return area;
    }
    
    public AreaDto toDTO(){
        AreaDto dto = new AreaDto();
        dto.setId(this.id);
        dto.setName(this.name);
        return dto;
    }
    


    
    
    
    
}
