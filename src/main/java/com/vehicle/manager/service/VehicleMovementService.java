package com.vehicle.manager.service;

import com.vehicle.manager.data.transfer.object.VehicleMovement;
import com.vehicle.manager.data.transfer.object.MessageDto;
import com.vehicle.manager.repositories.VehicleMovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleMovementService {


    @Autowired
    private VehicleMovementRepository vehicleMovementRepository;

    @Autowired
    private HttpSession session;


    public void helperAddVehicleMovements(VehicleMovement vehicleMovement)
    {
        try {
            this.vehicleMovementRepository.saveAndFlush(vehicleMovement);
            session.setAttribute("message", new MessageDto("VehicleMovement details have been added !", "alert-success"));

        }catch (Exception e)
        {
            session.setAttribute("message", new MessageDto("Error uploading VehicleMovement !", "alert-danger"));

        }
    }

    public void helperUpdateVehicleMovements(VehicleMovement vehicleMovement)
    {
        this.vehicleMovementRepository.saveAndFlush(vehicleMovement);
    }

    public List<VehicleMovement> getVehicleMovements()
    {

        return this.vehicleMovementRepository.findAll();
    }

    public void addVehicleMovements(VehicleMovement vehicleMovement)
    {
        helperAddVehicleMovements(vehicleMovement);
    }

    public Optional<VehicleMovement> updateVehicleMovementById(int id)
    {
        Optional<VehicleMovement> vehicleMovement =this.vehicleMovementRepository.findById(id);
        return vehicleMovement;
    }

    public void updateVehicleMovements(VehicleMovement vehicleMovement)
    {
        try {

            helperUpdateVehicleMovements(vehicleMovement);
            session.setAttribute("message", new MessageDto("VehicleMovement details have been Updated !", "alert-success"));

        }catch (Exception e)
        {
            session.setAttribute("message", new MessageDto("Error updating VehicleMovement !", "alert-danger"));
        }
    }

    public void deletevehicleMovement(int id)
    {
        try {

            VehicleMovement vehicleMovement =this.vehicleMovementRepository.findById(id).get();
            this.vehicleMovementRepository.delete(vehicleMovement);
            session.setAttribute("message", new MessageDto("VehicleMovement details have been deleted !", "alert-danger"));
        }catch (Exception e)
        {
            session.setAttribute("message", new MessageDto("Error deleting VehicleMovement !", "alert-danger"));


        }
    }


}
