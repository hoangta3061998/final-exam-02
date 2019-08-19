package com.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @OneToMany(targetEntity = City.class)
    private List<City> cities;

    public Country(String name, List<City> cities) {
        this.name = name;
        this.cities = cities;
    }

    public Country() {
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
