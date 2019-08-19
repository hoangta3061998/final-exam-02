package com.codegym.service;

import com.codegym.model.Country;

public interface CountryService {
    Country findById(Integer id);
    Iterable<Country> findAll();
}
