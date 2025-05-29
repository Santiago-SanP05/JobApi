
package com.Globant.JobOffers.persistence.entity;

import com.Globant.JobOffers.dto.CityDto;
import com.Globant.JobOffers.dto.CountryDto;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;


@Entity
public class Country {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String name;
    
    // ----------------- LISTAS
    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<City> cities = new ArrayList<>();
    
    
    
    // ----------------- CONSTRUCTORES

    public Country() {
    }

    public Country(String name) {
        this.name = name;
    }
    
    // ----------------- GETTER & SETTER
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

    public List<City> getCities() {
        return cities;
    }    
    
// ----------------- LIST FIXED      
    public void addCity(City city){
        this.cities.add(city);
        city.setCountry(this);
    }
    public void removeCity(City city){
        this.cities.remove(city);
        city.setCountry(null);
    }
    
    // ----------------- DTO

    public static Country fromDTO(CountryDto dto){
        Country country = new Country();
        country.setId(dto.getId());
        country.setName(dto.getName());
        return country;
    }

    public CountryDto toDTO(){
        CountryDto dto = new CountryDto();
        dto.setId(this.id);
        dto.setName(this.name);
        
        // Aquí convertimos la lista de Likes a LikeCommentDto
        List<CityDto> cityDtoList = this.cities.stream()
                .map(city -> city.toDTO())
                .collect(Collectors.toList());
        
        // Establecemos la lista convertida en commentDto
        dto.setCityDto(cityDtoList);
        return dto;
    }
    
    
    
}
