package com.vehicle.manager.controller;

import com.vehicle.manager.data.transfer.object.Country;
import com.vehicle.manager.data.transfer.object.MessageDto;
import com.vehicle.manager.data.transfer.object.State;
import com.vehicle.manager.repositories.CountryRepository;
import com.vehicle.manager.repositories.StateRepository;
import com.vehicle.manager.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.vehicle.manager.service.StateService;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Controller
public class StateController {

    @Autowired
    private StateService stateService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private StateRepository stateRepository;


    @GetMapping("/states")
    public String getCountries(Model model , HttpSession session) {

            List<State> stateList = this.stateService.getStates();
            List<Country> countryList = this.countryService.getCountries();

            System.out.println("welcome to for eachhhhhhh");


           model.addAttribute("countries" , countryList);
            model.addAttribute("states", stateList);

        return "State";
    }

    @PostMapping("/addStates")
    public String addCountries(State state) {
        this.stateService.addStates(state);
        return "redirect:/states";
    }

    @GetMapping("/updateStateById")
    @ResponseBody
    public Optional<State> updateCountryById(int id) {
        return this.stateService.updateStateById(id);
    }

    @RequestMapping(value = "/updateStates", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateCountries(State state) {
        this.stateService.updateStates(state);
        return "redirect:/states";
    }

    @RequestMapping(value = "/deleteStates/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteContact(@PathVariable("id") int id) {
        this.stateService.deleteStates(id);
        return "redirect:/states";
    }

    @GetMapping("/countryDetail")
    @ResponseBody
    public  Optional<Country>  getCountryByCountryId( int countryid)
    {
     return this.countryService.getCountryById(countryid);
    }


}
