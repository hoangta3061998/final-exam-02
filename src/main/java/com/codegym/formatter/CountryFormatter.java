package com.codegym.formatter;

import com.codegym.model.Country;
import com.codegym.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class CountryFormatter implements Formatter<Country> {

    private CountryService countryService;

    @Autowired
    public CountryFormatter(CountryService countryService) {
        this.countryService = countryService;
    }

    @Override
    public Country parse(String text, Locale locale) throws ParseException {
        return countryService.findById(Integer.parseInt(text));
    }

    @Override
    public String print(Country object, Locale locale) {
        return null;
    }
}
