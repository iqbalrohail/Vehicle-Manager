package com.vehicle.manager.controller;

import com.vehicle.manager.data.transfer.object.VehicleStatus;
import com.vehicle.manager.service.VehicleStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleStatusController {

    @Autowired
    private VehicleStatusService vehicleStatusService;

    @GetMapping("/vehicleStatus")
    public String getVehicleStatuss(Model model) {
        List<VehicleStatus>vehicleStatuss = this.vehicleStatusService.getVehicleStatuss();
        model.addAttribute("vehicleStatuss",vehicleStatuss);
        return "vehicleStatuss";
    }

    @PostMapping("/vehicleStatus/add")
    public String addVehicleStatuss(VehicleStatus vehicleStatus) {
        this.vehicleStatusService.addVehicleStatuss(vehicleStatus );
        return "redirect:/vehicleStatus";
    }

    @GetMapping("/vehicleStatus/updateById")
    @ResponseBody
    public Optional<VehicleStatus> updateVehicleStatusById(int id) {
        return this.vehicleStatusService.updateVehicleStatusById(id);
    }

    @RequestMapping(value = "/vehicleStatus/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateVehicleStatuss(VehicleStatus vehicleStatus) {
        this.vehicleStatusService.updateVehicleStatuss(vehicleStatus);
        return "redirect:/vehicleStatus";
    }

    @RequestMapping(value = "/vehicleStatus/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteVehicleStatuss(@PathVariable("id") int id) {
        this.vehicleStatusService.deleteVehicleStatus(id);
        return "redirect:/vehicleStatus";
    }


}
