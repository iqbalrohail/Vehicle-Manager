package com.vehicle.manager.controller;

import com.vehicle.manager.data.transfer.object.VehicleType;
import com.vehicle.manager.service.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleTypeController {


    @Autowired
    private VehicleTypeService vehicleTypeService;

    @GetMapping("/vehicleTypes")
    public String getVehicleTypes(Model model) {
        List<VehicleType> vehicleTypes = this.vehicleTypeService.getVehicleTypes();
        model.addAttribute("vehicleTypes", vehicleTypes);
        return "vehicleType";
    }

    @PostMapping("/vehicleTypes/add")
    public String addVehicleTypes(VehicleType vehicleType) {
        this.vehicleTypeService.addVehicleTypes(vehicleType);
        return "redirect:/vehicleTypes";
    }

    @GetMapping("/vehicleTypes/updateById")
    @ResponseBody
    public Optional<VehicleType> updateVehicleTypeById(int id) {
        return this.vehicleTypeService.updateVehicleTypeById(id);
    }

    @RequestMapping(value = "/vehicleTypes/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateVehicleTypes(VehicleType vehicleType) {
        this.vehicleTypeService.updateVehicleTypes(vehicleType);
        return "redirect:/vehicleTypes";
    }

    @RequestMapping(value = "/vehicleTypes/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteVehicleTypes(@PathVariable("id") int id) {
        this.vehicleTypeService.deleteVehicleTypes(id);
        return "redirect:/vehicleTypes";
    }


}
