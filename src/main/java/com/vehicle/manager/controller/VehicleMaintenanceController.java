package com.vehicle.manager.controller;

import com.vehicle.manager.data.transfer.object.Supplier;
import com.vehicle.manager.data.transfer.object.VehicleMaintenance;
import com.vehicle.manager.service.SupplierService;
import com.vehicle.manager.service.VehicleMaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.tree.VariableHeightLayoutCache;
import java.util.List;
import java.util.Optional;

@Controller
public class VehicleMaintenanceController {

    @Autowired
    private VehicleMaintenanceService vehicleMaintenanceService;

    @Autowired
    private SupplierService supplierService;

    @GetMapping("/vehiclesMaintenance")
    public String getVehicleMaintenances(Model model) {
        List<VehicleMaintenance> vehicleMaintenances = this.vehicleMaintenanceService.getVehicleMaintenance();
        List<Supplier> suppliers = this.supplierService.getSuppliers();
        model.addAttribute("vehicleMaintenances", vehicleMaintenances);
        model.addAttribute("suppliers", suppliers);
        return "vehicleMaintenance";
    }

    @PostMapping("/vehicleMaintenances/add")
    public String addVehicleMaintenance(VehicleMaintenance vehicleMaintenance) {
        this.vehicleMaintenanceService.addVehicleMaintenance(vehicleMaintenance);

        return "redirect:/vehiclesMaintenance";
    }

    @GetMapping("/vehicleMaintenances/updateById")
    @ResponseBody
    public Optional<VehicleMaintenance> updateVehicleMaintenanceById(int id) {
        return this.vehicleMaintenanceService.updateVehicleMaintenanceById(id);
    }

    @RequestMapping(value = "/vehicleMaintenance/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateVehicleMaintenance(VehicleMaintenance vehicleMaintenance) {
        this.vehicleMaintenanceService.updateVehicleMaintenance(vehicleMaintenance);
        return "redirect:/vehiclesMaintenance";
    }

    @RequestMapping(value = "/vehicleMaintenances/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteVehicleMaintenance(@PathVariable("id")  int id) {
        this.vehicleMaintenanceService.deleteVehicleMaintenance(id);
        return "redirect:/vehiclesMaintenance";
    }
}
