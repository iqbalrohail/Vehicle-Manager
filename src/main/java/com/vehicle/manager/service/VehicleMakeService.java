package com.vehicle.manager.service;

import com.vehicle.manager.data.transfer.object.VehicleMake;
import com.vehicle.manager.data.transfer.object.MessageDto;
import com.vehicle.manager.repositories.VehicleMakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleMakeService {
    @Autowired
    private VehicleMakeRepository vehicleMakeRepository;

    @Autowired
    private HttpSession session;


    public void helperAddVehicleMakes(VehicleMake vehicleMake)
    {
        try {
            this.vehicleMakeRepository.saveAndFlush(vehicleMake);
            session.setAttribute("message", new MessageDto("VehicleMake details have been added !", "alert-success"));

        }catch (Exception e)
        {
            session.setAttribute("message", new MessageDto("Error uploading VehicleMake !", "alert-danger"));

        }
    }

    public void helperUpdateVehicleMakes(VehicleMake vehicleMake)
    {
        this.vehicleMakeRepository.saveAndFlush(vehicleMake);
    }

    public List<VehicleMake> getVehicleMakes()
    {

        return this.vehicleMakeRepository.findAll();
    }

    public void addVehicleMakes(VehicleMake VehicleMake)
    {
        helperAddVehicleMakes(VehicleMake);
    }

    public Optional<VehicleMake> updateVehicleMakeById(int id)
    {
        Optional<VehicleMake> vehicleMake =this.vehicleMakeRepository.findById(id);
        return vehicleMake;
    }

    public void updateVehicleMakes(VehicleMake vehicleMake)
    {
        try {

            helperUpdateVehicleMakes(vehicleMake);
            session.setAttribute("message", new MessageDto("VehicleMake details have been Updated !", "alert-success"));

        }catch (Exception e)
        {
            session.setAttribute("message", new MessageDto("Error updating VehicleMake !", "alert-danger"));
        }
    }

    public void deleteVehicleMakes(int id)
    {
        try {

            VehicleMake vehicleMake =this.vehicleMakeRepository.findById(id).get();
            this.vehicleMakeRepository.delete(vehicleMake);
            session.setAttribute("message", new MessageDto("VehicleMake details have been deleted !", "alert-danger"));
        }catch (Exception e)
        {
            session.setAttribute("message", new MessageDto("Error deleting VehicleMake !", "alert-danger"));


        }
    }



}
