package com.vehicle.manager.controller;

import com.vehicle.manager.data.transfer.object.Country;
import com.vehicle.manager.data.transfer.object.VehicleMake;
import com.vehicle.manager.data.transfer.object.State;
import com.vehicle.manager.service.CountryService;
import com.vehicle.manager.service.VehicleMakeService;
import com.vehicle.manager.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleMakeController {


    @Autowired
    private VehicleMakeService vehicleMakeService;

    @GetMapping("/vehicleMakes")
    public String getVehicleMakes(Model model) {
        List<VehicleMake> vehicleMakes = this.vehicleMakeService.getVehicleMakes();
        model.addAttribute("vehicleMakes", vehicleMakes);
        return "vehicleMake";
    }

    @PostMapping("/vehicleMakes/add")
    public String addVehicleMakes(VehicleMake vehicleMake) {
        this.vehicleMakeService.addVehicleMakes(vehicleMake);
        return "redirect:/vehicleMakes";
    }

    @GetMapping("/vehicleMakes/updateById")
    @ResponseBody
    public Optional<VehicleMake> updateVehicleMakeById(int id) {
        return this.vehicleMakeService.updateVehicleMakeById(id);
    }

    @RequestMapping(value = "/vehicleMakes/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateVehicleMakes(VehicleMake vehicleMake) {
        this.vehicleMakeService.updateVehicleMakes(vehicleMake);
        return "redirect:/vehicleMakes";
    }

    @RequestMapping(value = "/vehicleMakes/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteVehicleMakes(@PathVariable("id") int id) {
        this.vehicleMakeService.deleteVehicleMakes(id);
        return "redirect:/vehicleMakes";
    }


}
