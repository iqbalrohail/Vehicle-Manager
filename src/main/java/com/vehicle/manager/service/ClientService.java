package com.vehicle.manager.service;

import com.vehicle.manager.data.transfer.object.Client;
import com.vehicle.manager.data.transfer.object.MessageDto;
import com.vehicle.manager.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {


    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private HttpSession session;


    public void helperAddClients(Client client)
    {
        try {
            this.clientRepository.saveAndFlush(client);
            session.setAttribute("message", new MessageDto("Client details have been added !", "alert-success"));

        }catch (Exception e)
        {
            session.setAttribute("message", new MessageDto("Error uploading Client !", "alert-danger"));

        }
    }

    public void helperUpdateClients(Client client)
    {
        this.clientRepository.saveAndFlush(client);
    }

    public List<Client> getClients()
    {

        return this.clientRepository.findAll();
    }

    public void addClients(Client client)
    {
        helperAddClients(client);
    }

    public Optional<Client> updateClientById(int id)
    {
        Optional<Client> client =this.clientRepository.findById(id);
        return client;
    }

    public void updateClients(Client client)
    {
        try {

            helperUpdateClients(client);
            session.setAttribute("message", new MessageDto("Client details have been Updated !", "alert-success"));

        }catch (Exception e)
        {
            session.setAttribute("message", new MessageDto("Error updating Client !", "alert-danger"));
        }
    }

    public void deleteClient(int id)
    {
        try {

            Client client =this.clientRepository.findById(id).get();
            this.clientRepository.delete(client);
            session.setAttribute("message", new MessageDto("Client details have been deleted !", "alert-danger"));
        }catch (Exception e)
        {
            session.setAttribute("message", new MessageDto("Error deleting Client !", "alert-danger"));


        }
    }


}
