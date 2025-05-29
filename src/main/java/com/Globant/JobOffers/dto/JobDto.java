
package com.Globant.JobOffers.dto;

public class JobDto {
    private Long id;
    private String name;
    private Long idArea;

    public JobDto() {
    }

    public JobDto(String name, Long idArea) {
        this.name = name;
        this.idArea = idArea;
    }

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

    public Long getIdArea() {
        return idArea;
    }

    public void setIdArea(Long idArea) {
        this.idArea = idArea;
    }
    
    
    
}
