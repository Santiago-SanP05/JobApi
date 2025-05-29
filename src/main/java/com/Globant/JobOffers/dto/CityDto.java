
package com.Globant.JobOffers.dto;

public class CityDto {
    private Long id;
    private String name;
    private Long idCountry;

    public CityDto() {
    }

    public CityDto(String name, Long idCountry) {
        this.name = name;
        this.idCountry = idCountry;
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

    public Long getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(Long idCountry) {
        this.idCountry = idCountry;
    }
    
    
}
