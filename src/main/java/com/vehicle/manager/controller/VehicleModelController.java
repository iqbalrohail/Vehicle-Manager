package com.vehicle.manager.controller;

import com.vehicle.manager.data.transfer.object.VehicleModel;
import com.vehicle.manager.service.VehicleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleModelController {

    @Autowired
    private VehicleModelService vehicleModelService;

    @GetMapping("/vehicleModels")
    public String getVehicleModels(Model model) {
        List<VehicleModel>vehicleModels = this.vehicleModelService.getVehicleModels();
        model.addAttribute("vehicleModels",vehicleModels);
        return "vehicleModel";
    }

    @PostMapping("/vehicleModels/add")
    public String addVehicleModels(VehicleModel vehicleModel) {
        this.vehicleModelService.addVehicleModels(vehicleModel );
        return "redirect:/vehicleModels";
    }

    @GetMapping("/vehicleModels/updateById")
    @ResponseBody
    public Optional<VehicleModel> updateVehicleModelById(int id) {
        return this.vehicleModelService.updateVehicleModelById(id);
    }

    @RequestMapping(value = "/vehicleModels/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateVehicleModels(VehicleModel vehicleModel) {
        this.vehicleModelService.updateVehicleModels(vehicleModel );
        return "redirect:/vehicleModels";
    }

    @RequestMapping(value = "/vehicleModels/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteVehicleModels(@PathVariable("id") int id) {
        this.vehicleModelService.deleteVehicleModel(id);
        return "redirect:/vehicleModels";
    }

}
