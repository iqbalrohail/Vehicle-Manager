package com.vehicle.manager.service;

import com.vehicle.manager.data.transfer.object.Contact;
import com.vehicle.manager.data.transfer.object.MessageDto;
import com.vehicle.manager.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private HttpSession session;

    public List<Contact> getContacts()
    {
       return this.contactRepository.findAll();
    }

    public void addContacts(Contact contact)
    {
        this.contactRepository.saveAndFlush(contact);
    }

    public Optional<Contact> updateContactById(int id)
    {
        Optional<Contact> contact = this.contactRepository.findById(id);
        return contact;
    }

    public void updateContacts(Contact contact)
    {
        try {
            this.contactRepository.saveAndFlush(contact);
            session.setAttribute("message" , new MessageDto("Your Contact have been updated" , "alert-success"));

        }catch (Exception e)
        {
            session.setAttribute("message" , new MessageDto("Your Contact have been updated" , "alert-danger"));

        }
    }

    public void deleteContacts(int id)
    {
        try {
            Contact contact = this.contactRepository.findById(id).get();
            this.contactRepository.delete(contact);
            session.setAttribute("message" , new MessageDto("your contact have been deleted!" , "alert-danger"));
        }catch (Exception e)
        {
            session.setAttribute("message" , new MessageDto("Error in deleting  contact !" , "alert-danger"));


        }

    }


}
