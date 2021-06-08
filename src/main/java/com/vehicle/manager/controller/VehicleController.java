package com.vehicle.manager.controller;

import com.vehicle.manager.data.transfer.object.*;
import com.vehicle.manager.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleController {


    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private VehicleTypeService vehicleTypeService;

    @Autowired
    private VehicleMakeService vehicleMakeService;

    @Autowired
    private VehicleStatusService vehicleStatusService;

    @Autowired
    private VehicleModelService vehicleModelService;

    @Autowired
    private LocationService locationService;


    @GetMapping("/vehicles")
    public String getVehicles(Model model) {
        List<Vehicle> vehicles = this.vehicleService.getVehicles();
        List<VehicleType> vehicleTypes = this.vehicleTypeService.getVehicleTypes();
        List<VehicleMake> vehicleMakes = this.vehicleMakeService.getVehicleMakes();
        List<VehicleStatus> vehicleStatuses = this.vehicleStatusService.getVehicleStatuss();
        List<VehicleModel> vehicleModels = this.vehicleModelService.getVehicleModels();
        List<Location> locations = this.locationService.getLocations();
        model.addAttribute("vehicles", vehicles);
        model.addAttribute("vehicleTypes", vehicleTypes);
        model.addAttribute("vehicleMakes", vehicleMakes);
        model.addAttribute("vehicleStatuses", vehicleStatuses);
        model.addAttribute("vehicleModels", vehicleModels);
        model.addAttribute("locations", locations);
        return "Vehicle";
    }

    @PostMapping("/vehicles/add")
    public String addVehicles(Vehicle vehicle) {
        this.vehicleService.addVehicles(vehicle);
        return "redirect:/vehicles";
    }

    @GetMapping("/vehicles/updateById")
    @ResponseBody
    public Optional<Vehicle> updateVehicleById(int id) {
        return this.vehicleService.updateVehicleById(id);
    }

    @RequestMapping(value = "/vehicles/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateVehicles(Vehicle vehicle) {
        this.vehicleService.updateVehicles(vehicle);
        return "redirect:/vehicles";
    }

    @RequestMapping(value = "/vehicles/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteVehicle(@PathVariable("id") int id) {
        this.vehicleService.deletevehicle(id);
        return "redirect:/vehicles";
    }

}
