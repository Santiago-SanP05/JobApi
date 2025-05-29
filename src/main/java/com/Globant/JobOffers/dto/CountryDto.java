
package com.Globant.JobOffers.dto;

import java.util.List;


public class CountryDto {
    private Long id;
    private String name;
    private List<CityDto> cityDto;
// CONSTRUCTOR
    public CountryDto() {
    }

    public CountryDto(String name) {
        this.name = name;
    }
// GETTERS SETTERS

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

    public List<CityDto> getCityDto() {
        return cityDto;
    }

    public void setCityDto(List<CityDto> cityDto) {
        this.cityDto = cityDto;
    }

    
    
}
