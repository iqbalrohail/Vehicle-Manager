package com.vehicle.manager.service;

import com.vehicle.manager.data.transfer.object.Vehicle;
import com.vehicle.manager.data.transfer.object.MessageDto;
import com.vehicle.manager.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private HttpSession session;


    public void helperAddVehicles(Vehicle vehicle)
    {
        try {
            this.vehicleRepository.saveAndFlush(vehicle);
            session.setAttribute("message", new MessageDto("Vehicle details have been added !", "alert-success"));

        }catch (Exception e)
        {
            session.setAttribute("message", new MessageDto("Error uploading Vehicle !", "alert-danger"));

        }
    }

    public void helperUpdateVehicles(Vehicle vehicle)
    {
        this.vehicleRepository.saveAndFlush(vehicle);
    }

    public List<Vehicle> getVehicles()
    {

        return this.vehicleRepository.findAll();
    }

    public void addVehicles(Vehicle vehicle)
    {
        helperAddVehicles(vehicle);
    }

    public Optional<Vehicle> updateVehicleById(int id)
    {
        Optional<Vehicle> vehicle =this.vehicleRepository.findById(id);
        return vehicle;
    }

    public void updateVehicles(Vehicle vehicle)
    {
        try {

            helperUpdateVehicles(vehicle);
            session.setAttribute("message", new MessageDto("Vehicle details have been Updated !", "alert-success"));

        }catch (Exception e)
        {
            session.setAttribute("message", new MessageDto("Error updating Vehicle !", "alert-danger"));
        }
    }

    public void deletevehicle(int id)
    {
        try {

            Vehicle vehicle =this.vehicleRepository.findById(id).get();
            this.vehicleRepository.delete(vehicle);
            session.setAttribute("message", new MessageDto("Vehicle details have been deleted !", "alert-danger"));
        }catch (Exception e)
        {
            session.setAttribute("message", new MessageDto("Error deleting Vehicle !", "alert-danger"));


        }
    }
}
