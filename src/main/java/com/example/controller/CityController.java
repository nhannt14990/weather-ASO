package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.entity.City;
import com.example.service.CityService;

/**
 * City controller.
 */
@Controller
public class CityController {

    private CityService cityService;
    
    @Autowired
    public void setCityService(CityService cityService) {
        this.cityService = cityService;
    }
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("cities", cityService.listAllCities());
        model.addAttribute("city", new City());
        return "index";
    }
    
    /**
     * Search city by city name
     * @param city
     * @param model
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(City city, Model model) {    	
    	if(city.getCityName() == null || city.getCityName() == "")
    		model.addAttribute("cities", cityService.listAllCities());
    	else
    		model.addAttribute("cities", cityService.search(city.getCityName()));
    	
        return "index";
    }

    /**
     * New city.
     *
     * @param model
     * @return
     */
    @RequestMapping("city/new")
    public String newCity(Model model) {
        model.addAttribute("city", new City());
        return "cityformadd";
    }

    /**
     * Save city to database.
     *
     * @param city
     * @return
     */
    @RequestMapping(value = "addCity", method = RequestMethod.POST)
    public String saveCity(Model model, City city) {
    	if(city.getCityName() != null && city.getCityName() != "")
    		cityService.saveCity(city);
        return "redirect:/";
    }

    /**
     * Delete city by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("city/delete/{idCity}")
    public String delete(@PathVariable Integer idCity) {
        cityService.deleteCity(idCity);
        return "redirect:/";
    }
}
