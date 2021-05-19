package com.vehicle.manager.service;
import com.vehicle.manager.data.transfer.object.Country;
import com.vehicle.manager.data.transfer.object.Country;
import com.vehicle.manager.data.transfer.object.MessageDto;
import com.vehicle.manager.data.transfer.object.State;
import com.vehicle.manager.repositories.CountryRepository;
import com.vehicle.manager.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private HttpSession session;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private StateService stateService;

    public List<Country> getCountries() {
        return countryRepository.findAll();
    }

    // helper methods

    public Country helperAddCountries(Country country) {
        return countryRepository.saveAndFlush(country);
    }

    public Country helperUpdateCountries(Country country) {
        return countryRepository.saveAndFlush(country);
    }


    public void addCountries(Country country) {
        try {
            helperAddCountries(country);
            session.setAttribute("message", new MessageDto("Country details have been added !", "alert-success"));

        } catch (Exception e) {

            session.setAttribute("message", new MessageDto("Error adding country details!", "alert-danger"));
        }
    }

    public Optional<Country> updateCountryById(int id) {
        return this.countryRepository.findById(id);

    }

    public void updateCountries(Country country) {
        try {
            helperUpdateCountries(country);
            session.setAttribute("message", new MessageDto("Country details have been Uploaded !", "alert-success"));
        } catch (Exception e) {
            session.setAttribute("message", new MessageDto("Error uploading country details ! !", "alert-danger"));
        }
    }

    public void deleteCountries(int id) {
        try {
            Country country = this.countryRepository.findById(id).get();
            List<State> states = stateRepository.findAll();


            for (State s:
                    states) {
                if(country.getId() == s.getCountryid())
                {
                    this.stateService.deleteStates(s.getId());
                }

            }

            this.countryRepository.delete(country);
            session.setAttribute("message", new MessageDto("Country details have been deleted !", "alert-danger"));

        } catch (Exception e) {
            session.setAttribute("message", new MessageDto("Error deleting your Country details !", "alert-danger"));
        }
    }

    public Optional<Country> getCountryById(int id)
    {
        return this.countryRepository.findById(id);
    }





}
