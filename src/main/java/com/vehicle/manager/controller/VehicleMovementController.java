package com.vehicle.manager.controller;

import com.vehicle.manager.data.transfer.object.Client;
import com.vehicle.manager.data.transfer.object.Location;
import com.vehicle.manager.data.transfer.object.VehicleMovement;
import com.vehicle.manager.service.ClientService;
import com.vehicle.manager.service.LocationService;
import com.vehicle.manager.service.VehicleMovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleMovementController {
    @Autowired
    private VehicleMovementService vehicleMovementService;

    @Autowired
    private LocationService locationService;


    @GetMapping("/vehicleMovements")
    public String getVehicleMovements(Model model) {
        List<Location> locations = this.locationService.getLocations();
        List<VehicleMovement> vehicleMovements = this.vehicleMovementService.getVehicleMovements();
        model.addAttribute("locations", locations);
        model.addAttribute("vehicleMovements", vehicleMovements);
        return "vehicleMovement";
    }

    @PostMapping("/vehicleMovements/add")
    public String addVehicleMovements(VehicleMovement vehicleMovement) {
        this.vehicleMovementService.addVehicleMovements(vehicleMovement);
        return "redirect:/vehicleMovements";
    }

    @GetMapping("/vehicleMovements/updateById")
    @ResponseBody
    public Optional<VehicleMovement> updateVehicleMovementById(int id) {
        return this.vehicleMovementService.updateVehicleMovementById(id);
    }

    @RequestMapping(value = "/vehicleMovements/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateVehicleMovements(VehicleMovement vehicleMovement) {
        this.vehicleMovementService.updateVehicleMovements(vehicleMovement);
        return "redirect:/vehicleMovements";
    }

    @RequestMapping(value = "/vehicleMovements/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteVehicleMovement(@PathVariable("id") int id) {
        this.vehicleMovementService.deletevehicleMovement(id);
        return "redirect:/vehicleMovements";
    }

}
