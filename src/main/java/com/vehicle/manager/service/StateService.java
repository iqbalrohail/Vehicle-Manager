package com.vehicle.manager.service;

import com.vehicle.manager.data.transfer.object.Location;
import com.vehicle.manager.data.transfer.object.MessageDto;
import com.vehicle.manager.data.transfer.object.State;
import com.vehicle.manager.repositories.LocationRepository;
import com.vehicle.manager.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Service
public class StateService {


    @Autowired
    private HttpSession session;

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private LocationRepository locationRepository;

    public List<State> getStates() {
        return stateRepository.findAll();
    }

    // helper methods

    public State helperAddStates(State state) {
        return stateRepository.saveAndFlush(state);
    }

    public State helperUpdateStates(State state) {
        return stateRepository.saveAndFlush(state);
    }


    public void addStates(State state) {
        try {
            helperAddStates(state);
            session.setAttribute("message", new MessageDto("State details have been added !", "alert-success"));

        } catch (Exception e) {

            session.setAttribute("message", new MessageDto("Error adding State details!", "alert-danger"));
        }
    }

    public Optional<State> updateStateById(int id) {
        return this.stateRepository.findById(id);

    }

    public void updateStates(State state) {
        try {
            helperUpdateStates(state);
            session.setAttribute("message", new MessageDto("State details have been Uploaded !", "alert-success"));
        } catch (Exception e) {
            session.setAttribute("message", new MessageDto("Error uploading State details ! !", "alert-danger"));
        }
    }

    public void deleteStates(int id) {
        try {
            State state = this.stateRepository.findById(id).get();
            List<Location> locations = this.locationRepository.findAll();

            for (Location location:
                    locations) {
                if(state.getId() == location.getStateid())
                {
                    this.locationRepository.delete(location);
                }

            }

            this.stateRepository.delete(state);
            session.setAttribute("message", new MessageDto("State details have been deleted !", "alert-danger"));

        } catch (Exception e) {
            session.setAttribute("message", new MessageDto("Error deleting your State details !", "alert-danger"));
        }
    }

    public State getStatesByCountryId(int countryId)
    {

        return this.stateRepository.findById(countryId).get();

    }



}
