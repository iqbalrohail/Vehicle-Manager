package com.vehicle.manager.service;

import com.vehicle.manager.data.transfer.object.Location;
import com.vehicle.manager.data.transfer.object.MessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vehicle.manager.repositories.LocationRepository;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private HttpSession session;


    public void helperAddLocations(Location location)
    {
       try {
           this.locationRepository.saveAndFlush(location);
           session.setAttribute("message", new MessageDto("Location details have been added !", "alert-success"));

       }catch (Exception e)
       {
           session.setAttribute("message", new MessageDto("Error uploading Location !", "alert-danger"));

       }
    }

    public void helperUpdateLocations(Location location)
    {
        this.locationRepository.saveAndFlush(location);
    }

    public List<Location> getLocations()
    {

        return this.locationRepository.findAll();
    }

    public void addLocations(Location location)
    {
            helperAddLocations(location);
    }

    public Optional<Location> updateLocationById(int id)
    {
        Optional<Location> location =this.locationRepository.findById(id);
        return location;
    }

    public void updateLocations(Location location)
    {
        try {

            helperUpdateLocations(location);
            session.setAttribute("message", new MessageDto("Location details have been Updated !", "alert-success"));

        }catch (Exception e)
        {
            session.setAttribute("message", new MessageDto("Error updating Location !", "alert-danger"));
        }
    }

    public void deletelocation(int id)
    {
        try {

            Location location =this.locationRepository.findById(id).get();
            this.locationRepository.delete(location);
            session.setAttribute("message", new MessageDto("Location details have been deleted !", "alert-danger"));
        }catch (Exception e)
        {
            session.setAttribute("message", new MessageDto("Error deleting Location !", "alert-danger"));


        }
    }





}
