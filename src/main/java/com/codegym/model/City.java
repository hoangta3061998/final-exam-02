package com.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Khong duoc de trong")
    private String name;
    @NotNull(message = "Khong duoc de trong")
    @Min(value = 0, message = "Dien tich phai la so duong")
    private Float area;
    @NotNull(message = "Khong duoc de trong")
    @Min(value = 0, message = "Dan so phai la so duong")
    private Long population;
    @NotNull(message = "Khong duoc de trong")
    @Min(value = 0, message = "GDP phai la so duong")
    private Float gdp;
    private String description;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    public City() {
    }

    public City(@NotEmpty(message = "Khong duoc de trong") String name, @NotEmpty(message = "Khong duoc de trong") @Min(value = 0, message = "Dien tich phai la so duong") Float area, @NotEmpty(message = "Khong duoc de trong") @Min(value = 0, message = "Dan so phai la so duong") Long population, @NotEmpty(message = "Khong duoc de trong") @Min(value = 0, message = "GDP phai la so duong") Float gdp, String description, Country country) {
        this.name = name;
        this.area = area;
        this.population = population;
        this.gdp = gdp;
        this.description = description;
        this.country = country;
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

    public Float getArea() {
        return area;
    }

    public void setArea(Float area) {
        this.area = area;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public Float getGdp() {
        return gdp;
    }

    public void setGdp(Float gdp) {
        this.gdp = gdp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
