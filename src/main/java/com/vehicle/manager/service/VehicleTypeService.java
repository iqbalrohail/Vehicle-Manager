package com.vehicle.manager.service;

import com.vehicle.manager.data.transfer.object.VehicleType;
import com.vehicle.manager.data.transfer.object.MessageDto;
import com.vehicle.manager.repositories.VehicleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleTypeService {

    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;

    @Autowired
    private HttpSession session;


    public void helperAddVehicleTypes(VehicleType vehicleType)
    {
        try {
            this.vehicleTypeRepository.saveAndFlush(vehicleType);
            session.setAttribute("message", new MessageDto("VehicleType details have been added !", "alert-success"));

        }catch (Exception e)
        {
            session.setAttribute("message", new MessageDto("Error uploading VehicleType !", "alert-danger"));

        }
    }

    public void helperUpdateVehicleTypes(VehicleType vehicleType)
    {
        this.vehicleTypeRepository.saveAndFlush(vehicleType);
    }

    public List<VehicleType> getVehicleTypes()
    {

        return this.vehicleTypeRepository.findAll();
    }

    public void addVehicleTypes(VehicleType vehicleType)
    {
        helperAddVehicleTypes(vehicleType);
    }

    public Optional<VehicleType> updateVehicleTypeById(int id)
    {
        Optional<VehicleType> vehicleType =this.vehicleTypeRepository.findById(id);
        return vehicleType;
    }

    public void updateVehicleTypes(VehicleType vehicleType)
    {
        try {

            helperUpdateVehicleTypes(vehicleType);
            session.setAttribute("message", new MessageDto("VehicleType details have been Updated !", "alert-success"));

        }catch (Exception e)
        {
            session.setAttribute("message", new MessageDto("Error updating VehicleType !", "alert-danger"));
        }
    }

    public void deleteVehicleTypes(int id)
    {
        try {

            VehicleType vehicleType =this.vehicleTypeRepository.findById(id).get();
            this.vehicleTypeRepository.delete(vehicleType);
            session.setAttribute("message", new MessageDto("VehicleType details have been deleted !", "alert-danger"));
        }catch (Exception e)
        {
            session.setAttribute("message", new MessageDto("Error deleting VehicleType !", "alert-danger"));


        }
    }


}
