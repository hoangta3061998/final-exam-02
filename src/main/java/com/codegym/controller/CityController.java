package com.codegym.controller;


import com.codegym.model.City;
import com.codegym.model.Country;
import com.codegym.service.CityService;
import com.codegym.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;
    @Autowired
    private CountryService countryService;


    @ModelAttribute("countries")
    public Iterable<Country> countries() {
        return countryService.findAll();
    }

    @GetMapping("/list")
    public ModelAndView findAll(Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/city/list");
        Page<City> cities = cityService.findAll(pageable);
        modelAndView.addObject("cities", cities);
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView view(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("/city/view");
        modelAndView.addObject("city", cityService.findById(id));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/city/create");
        modelAndView.addObject("city", new City());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createCity(@Validated @ModelAttribute("city") City city, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("/city/create");
            return modelAndView;
        }
        cityService.save(city);
        ModelAndView modelAndView = new ModelAndView("/city/create");
        modelAndView.addObject("city", new City());
        modelAndView.addObject("message","created!");
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable("id")Long id){
        ModelAndView modelAndView = new ModelAndView("/city/edit");
        modelAndView.addObject("city",cityService.findById(id));
        return modelAndView;
    }
    @PostMapping("/edit")
    public ModelAndView editCity(@ModelAttribute("city") City city,Pageable pageable){
        cityService.save(city);
        ModelAndView modelAndView = new ModelAndView("/city/list");
        modelAndView.addObject("message","Updated");
        modelAndView.addObject("cities",cityService.findAll(pageable));
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView("/city/delete");
        modelAndView.addObject("city",cityService.findById(id));
        return modelAndView;
    }
    @PostMapping("/delete")
    public ModelAndView deleteCity(@ModelAttribute("city") City city,Pageable pageable){
        cityService.delete(city.getId());
        ModelAndView modelAndView = new ModelAndView("/city/list");
        modelAndView.addObject("cities",cityService.findAll(pageable));
        modelAndView.addObject("message","Deleted");
        return modelAndView;
    }
}
