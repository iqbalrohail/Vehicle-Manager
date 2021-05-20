package com.vehicle.manager.controller;

import com.vehicle.manager.data.transfer.object.Country;
import com.vehicle.manager.data.transfer.object.Client;
import com.vehicle.manager.data.transfer.object.State;
import com.vehicle.manager.service.CountryService;
import com.vehicle.manager.service.ClientService;
import com.vehicle.manager.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private StateService stateService;

    @Autowired
    private CountryService countryService;

    @GetMapping("/clients")
    public String getClients(Model model) {
        List<State> stateList = this.stateService.getStates();
        List<Country> countryList = this.countryService.getCountries();
        List<Client> clients = this.clientService.getClients();
        model.addAttribute("countries" , countryList);
        model.addAttribute("states", stateList);
        model.addAttribute("clients", clients);
        return "client";
    }

    @PostMapping("/clients/add")
    public String addClients(Client client) {
        this.clientService.addClients(client);
        return "redirect:/clients";
    }

    @GetMapping("/clients/updateById")
    @ResponseBody
    public Optional<Client> updateClientById(int id)
    {
        return this.clientService.updateClientById(id);
    }

    @RequestMapping(value = "/clients/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateClients(Client client)
    {
        this.clientService.updateClients(client);
        return "redirect:/clients";
    }

    @RequestMapping(value = "/clients/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteClient(@PathVariable("id") int id)
    {
        this.clientService.deleteClient(id);
        return "redirect:/clients";
    }


}
