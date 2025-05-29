
package com.Globant.JobOffers.dto;


public class AreaDto {
    
    private Long id;
    private String name;

    
    // CONSTRUCTOR
    public AreaDto() {
    }

    public AreaDto(String name) {
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

    
    
}
