package com.vehicle.manager.controller;

import com.vehicle.manager.data.transfer.object.Country;
import com.vehicle.manager.data.transfer.object.Location;
import com.vehicle.manager.data.transfer.object.State;
import com.vehicle.manager.service.CountryService;
import com.vehicle.manager.service.LocationService;
import com.vehicle.manager.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
public class LocationController {

    @Autowired
    private LocationService locationService;

    @Autowired
    private StateService stateService;

    @Autowired
    private CountryService countryService;

    @GetMapping("/locations")
    public String getLocations(Model model) {
        List<State> stateList = this.stateService.getStates();
        List<Country> countryList = this.countryService.getCountries();
        List<Location> locations = this.locationService.getLocations();
        model.addAttribute("countries" , countryList);
        model.addAttribute("states", stateList);
        model.addAttribute("locations", locations);
        return "location";
    }

    @PostMapping("/locations/add")
    public String addLocations(Location location) {
        this.locationService.addLocations(location);
        return "redirect:/locations";
    }

    @GetMapping("/locations/updateById")
    @ResponseBody
    public Optional<Location> updateLocationById(int id)
    {
        return this.locationService.updateLocationById(id);
    }

    @RequestMapping(value = "/locations/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateLocations(Location location)
    {
        this.locationService.updateLocations(location);
        return "redirect:/locations";
    }

    @RequestMapping(value = "/locations/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteLocation(@PathVariable("id") int id)
    {
        this.locationService.deletelocation(id);
        return "redirect:/locations";
    }




}
