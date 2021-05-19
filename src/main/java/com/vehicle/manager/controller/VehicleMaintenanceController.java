package com.vehicle.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VehicleMaintenanceController {

    @GetMapping("/vehiclesMaintenance")
    public String getVehicleMaintenances()
    {

        return "vehicleMaintenance";
    }
}
