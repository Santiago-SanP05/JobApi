
package com.Globant.JobOffers.dto;

public class TechnologyDto {
    private Long id;
    private String name;

    public TechnologyDto() {
    }

    public TechnologyDto(String name) {
        this.name = name;
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
    
    
}
