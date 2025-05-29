
package com.Globant.JobOffers.persistence.entity;

import com.Globant.JobOffers.dto.CityDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class City {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    
    @ManyToOne
    private Country country;

    
    //CONSTRUCTOR
    public City() {
    }

    public City(String name, Country country) {
        this.name = name;
        this.country = country;
    }
    
    
    public City(String name) {
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
    

    public static City fromDTO(CityDto dto, Country countryEntity){
        City city = new City();
        city.setId(dto.getId());
        city.setName(dto.getName());
        city.setCountry(countryEntity);
        return city;
    }
    
    public CityDto toDTO(){
        CityDto dto = new CityDto();
        dto.setId(this.id);
        dto.setName(this.name);
        dto.setIdCountry(this.country.getId());
        return dto;
    }

    @Override
    public String toString() {
        return "City{" + "id=" + id + ", name=" + name + ", country=" + country + '}';
    }

    
    
}
