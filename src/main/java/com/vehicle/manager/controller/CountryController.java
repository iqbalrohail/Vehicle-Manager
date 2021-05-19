package com.vehicle.manager.controller;

import com.vehicle.manager.data.transfer.object.Country;
import com.vehicle.manager.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/countries")
    public String getCountries(Model model) {

        List<Country> CountryList = this.countryService.getCountries();
        model.addAttribute("countries", CountryList);
        return "country";
    }

    @PostMapping("/addCountries")
    public String addCountries(Country country) {
        this.countryService.addCountries(country);
        return "redirect:/countries";
    }

    @GetMapping("/updateCountryById")
    @ResponseBody
    public Optional<Country> updateCountryById(int id) {
        return this.countryService.updateCountryById(id);
    }

    @RequestMapping(value = "/updateCountries", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateCountries(Country country) {
        this.countryService.updateCountries(country);
        return "redirect:/countries";
    }

    @RequestMapping(value = "/deleteCountries/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteContact(@PathVariable("id") int id) {
        this.countryService.deleteCountries(id);
        return "redirect:/countries";
    }
}
