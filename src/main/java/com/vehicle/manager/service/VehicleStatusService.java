package com.vehicle.manager.service;

import com.vehicle.manager.data.transfer.object.VehicleStatus;
import com.vehicle.manager.data.transfer.object.MessageDto;
import com.vehicle.manager.repositories.VehicleStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleStatusService {

    @Autowired
    private VehicleStatusRepository vehicleStatusRepository;

    @Autowired
    private HttpSession session;


    public void helperAddVehicleStatuss(VehicleStatus vehicleStatus)
    {
        try {
            this.vehicleStatusRepository.saveAndFlush(vehicleStatus );
            session.setAttribute("message", new MessageDto("VehicleStatus details have been added !", "alert-success"));

        }catch (Exception e)
        {
            session.setAttribute("message", new MessageDto("Error uploading VehicleStatus !", "alert-danger"));

        }
    }

    public void helperUpdateVehicleStatuss(VehicleStatus vehicleStatus)
    {
        this.vehicleStatusRepository.saveAndFlush(vehicleStatus );
    }

    public List<VehicleStatus> getVehicleStatuss()
    {

        return this.vehicleStatusRepository.findAll();
    }

    public void addVehicleStatuss(VehicleStatus vehicleStatus)
    {
        helperAddVehicleStatuss(vehicleStatus );
    }

    public Optional<VehicleStatus> updateVehicleStatusById(int id)
    {
        Optional<VehicleStatus>vehicleStatus =this.vehicleStatusRepository.findById(id);
        return vehicleStatus;
    }

    public void updateVehicleStatuss(VehicleStatus vehicleStatus)
    {
        try {

            helperUpdateVehicleStatuss(vehicleStatus );
            session.setAttribute("message", new MessageDto("VehicleStatus details have been Updated !", "alert-success"));

        }catch (Exception e)
        {
            session.setAttribute("message", new MessageDto("Error updating VehicleStatus !", "alert-danger"));
        }
    }

    public void deleteVehicleStatus(int id)
    {
        try {

            VehicleStatus vehicleStatus =this.vehicleStatusRepository.findById(id).get();
            this.vehicleStatusRepository.delete(vehicleStatus );
            session.setAttribute("message", new MessageDto("VehicleStatus details have been deleted !", "alert-danger"));
        }catch (Exception e)
        {
            session.setAttribute("message", new MessageDto("Error deleting VehicleStatus !", "alert-danger"));


        }
    }


}
