package com.vehicle.manager.service;

import com.vehicle.manager.data.transfer.object.VehicleHire;
import com.vehicle.manager.data.transfer.object.VehicleHire;
import com.vehicle.manager.data.transfer.object.MessageDto;
import com.vehicle.manager.repositories.VehicleHireRepository;
import com.vehicle.manager.repositories.VehicleHireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleHireService {

    @Autowired
    private VehicleHireRepository vehicleHireRepository;

    @Autowired
    private HttpSession session;


    public void helperAddVehicleHires(VehicleHire vehicleHire) {
        try {
            this.vehicleHireRepository.saveAndFlush(vehicleHire);
            session.setAttribute("message", new MessageDto("VehicleHire details have been added !", "alert-success"));

        } catch (Exception e) {
            session.setAttribute("message", new MessageDto("Error uploading VehicleHire !", "alert-danger"));

        }
    }

    public void helperUpdateVehicleHires(VehicleHire vehicleHire) {
        this.vehicleHireRepository.saveAndFlush(vehicleHire);
    }

    public List<VehicleHire> getVehicleHires() {

        return this.vehicleHireRepository.findAll();
    }

    public void addVehicleHires(VehicleHire vehicleHire) {
        helperAddVehicleHires(vehicleHire);
    }

    public Optional<VehicleHire> updateVehicleHireById(int id) {
        Optional<VehicleHire> vehicleHire = this.vehicleHireRepository.findById(id);
        return vehicleHire;
    }

    public void updateVehicleHires(VehicleHire vehicleHire) {
        try {

            helperUpdateVehicleHires(vehicleHire);
            session.setAttribute("message", new MessageDto("VehicleHire details have been Updated !", "alert-success"));

        } catch (Exception e) {
            session.setAttribute("message", new MessageDto("Error updating VehicleHire !", "alert-danger"));
        }
    }

    public void deletevehicleHire(int id) {
        try {

            VehicleHire vehicleHire = this.vehicleHireRepository.findById(id).get();
            this.vehicleHireRepository.delete(vehicleHire);
            session.setAttribute("message", new MessageDto("VehicleHire details have been deleted !", "alert-danger"));
        } catch (Exception e) {
            session.setAttribute("message", new MessageDto("Error deleting VehicleHire !", "alert-danger"));


        }
    }


}
