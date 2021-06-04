package com.vehicle.manager.controller;

import com.vehicle.manager.data.transfer.object.Client;
import com.vehicle.manager.data.transfer.object.Location;
import com.vehicle.manager.data.transfer.object.VehicleHire;
import com.vehicle.manager.service.ClientService;
import com.vehicle.manager.service.LocationService;
import com.vehicle.manager.service.VehicleHireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleHireController {


    @Autowired
    private VehicleHireService vehicleHireService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private LocationService locationService;


    @GetMapping("/vehicleHires")
    public String getVehicleHires(Model model) {
        List<Client> clientList = this.clientService.getClients();
        List<Location> locations= this.locationService.getLocations();
        List<VehicleHire> vehicleHires = this.vehicleHireService.getVehicleHires();
        model.addAttribute("clients", clientList);
        model.addAttribute("locations", locations);
        model.addAttribute("vehicleHires", vehicleHires);
        return "vehicleHire";
    }

    @PostMapping("/vehicleHires/add")
    public String addVehicleHires(VehicleHire vehicleHire) {
        this.vehicleHireService.addVehicleHires(vehicleHire);
        return "redirect:/vehicleHires";
    }

    @GetMapping("/vehicleHires/updateById")
    @ResponseBody
    public Optional<VehicleHire> updateVehicleHireById(int id) {
        return this.vehicleHireService.updateVehicleHireById(id);
    }

    @RequestMapping(value = "/vehicleHires/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateVehicleHires(VehicleHire vehicleHire) {
        this.vehicleHireService.updateVehicleHires(vehicleHire);
        return "redirect:/vehicleHires";
    }

    @RequestMapping(value = "/vehicleHires/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteVehicleHire(@PathVariable("id") int id) {
        this.vehicleHireService.deletevehicleHire(id);
        return "redirect:/vehicleHires";
    }


}
