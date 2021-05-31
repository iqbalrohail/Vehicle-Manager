package com.vehicle.manager.service;


import com.vehicle.manager.data.transfer.object.MessageDto;
import com.vehicle.manager.data.transfer.object.VehicleMaintenance;
import com.vehicle.manager.repositories.VehicleMaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleMaintenanceService {

    @Autowired
    private VehicleMaintenanceRepository vehicleMaintenanceRepository;

    @Autowired
    private HttpSession session;


    public List<VehicleMaintenance> getVehicleMaintenance() {
      return this.vehicleMaintenanceRepository.findAll();
    }

    public void addVehicleMaintenance(VehicleMaintenance vehicleMaintenance) {
        try {
            this.vehicleMaintenanceRepository.saveAndFlush(vehicleMaintenance);
            session.setAttribute("message", new MessageDto("Vehicle maintenance is added !", "alert-success"));

        } catch (Exception e) {
            session.setAttribute("message", new MessageDto("Vehicle maintenance cannot be added", "alert-danger"));
        }
    }

    public void updateVehicleMaintenance(VehicleMaintenance vehicleMaintenance) {
        try {
            this.vehicleMaintenanceRepository.saveAndFlush(vehicleMaintenance);
            session.setAttribute("message", new MessageDto("Vehicle maintenance is Updated", "alert-success"));


        } catch (Exception e) {
            session.setAttribute("message", new MessageDto("Vehicle maintenance cannot be Updated", "alert-danger"));
        }
    }

    public Optional<VehicleMaintenance> updateVehicleMaintenanceById(int id) {
        Optional<VehicleMaintenance> vehicleMaintenance = this.vehicleMaintenanceRepository.findById(id);
        return vehicleMaintenance;

    }

    public void deleteVehicleMaintenance(int id) {
        try {
            VehicleMaintenance vehicleMaintenance = this.vehicleMaintenanceRepository.findById(id).get();
            this.vehicleMaintenanceRepository.delete(vehicleMaintenance);
            session.setAttribute("message", new MessageDto("Vehicle maintenance is deleted", "alert-danger"));


        } catch (Exception e) {
            session.setAttribute("message", new MessageDto("Vehicle maintenance cannot be deleted", "alert-danger"));
        }
    }


}
