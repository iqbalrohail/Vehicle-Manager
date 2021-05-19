package com.vehicle.manager.service;

import com.vehicle.manager.data.transfer.object.VehicleModel;
import com.vehicle.manager.data.transfer.object.MessageDto;
import com.vehicle.manager.repositories.VehicleModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleModelService {

    @Autowired
    private VehicleModelRepository vehicleModelRepository;

    @Autowired
    private HttpSession session;


    public void helperAddVehicleModels(VehicleModel vehicleModel)
    {
        try {
            this.vehicleModelRepository.saveAndFlush(vehicleModel );
            session.setAttribute("message", new MessageDto("VehicleModel details have been added !", "alert-success"));

        }catch (Exception e)
        {
            session.setAttribute("message", new MessageDto("Error uploading VehicleModel !", "alert-danger"));

        }
    }

    public void helperUpdateVehicleModels(VehicleModel vehicleModel)
    {
        this.vehicleModelRepository.saveAndFlush(vehicleModel );
    }

    public List<VehicleModel> getVehicleModels()
    {

        return this.vehicleModelRepository.findAll();
    }

    public void addVehicleModels(VehicleModel vehicleModel)
    {
        helperAddVehicleModels(vehicleModel );
    }

    public Optional<VehicleModel> updateVehicleModelById(int id)
    {
        Optional<VehicleModel> vehicleModel =this.vehicleModelRepository.findById(id);
        return vehicleModel;
    }

    public void updateVehicleModels(VehicleModel vehicleModel)
    {
        try {

            helperUpdateVehicleModels(vehicleModel );
            session.setAttribute("message", new MessageDto("VehicleModel details have been Updated !", "alert-success"));

        }catch (Exception e)
        {
            session.setAttribute("message", new MessageDto("Error updating VehicleModel !", "alert-danger"));
        }
    }

    public void deleteVehicleModel(int id)
    {
        try {

            VehicleModel vehicleModel =this.vehicleModelRepository.findById(id).get();
            this.vehicleModelRepository.delete(vehicleModel );
            session.setAttribute("message", new MessageDto("VehicleModel details have been deleted !", "alert-danger"));
        }catch (Exception e)
        {
            session.setAttribute("message", new MessageDto("Error deleting VehicleModel !", "alert-danger"));


        }
    }



}
