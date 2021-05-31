package com.vehicle.manager.controller;

import com.vehicle.manager.data.transfer.object.Contact;
import com.vehicle.manager.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/contacts")
    public String getContacts(Model model) {

        List<Contact> contacts = this.contactService.getContacts();
        model.addAttribute("contacts" ,  contacts);
        return "blankContact";
    }

    @PostMapping("/contacts/add")
    public String addContacts(Contact contact) {
        this.contactService.addContacts(contact);
        return "redirect:/contacts";
    }

    @GetMapping("/contacts/updateById")
    @ResponseBody
    public Optional<Contact> updateContactById(int id)
    {
        return this.contactService.updateContactById(id);
    }

    @RequestMapping(value = "/contacts/update", method = {RequestMethod.PUT , RequestMethod.GET})
    public String updateContacts(Contact contact)
    {
        this.contactService.updateContacts(contact);
        return "redirect:/contacts";
    }

    @RequestMapping(value = "/contacts/delete/{id}" , method = {RequestMethod.DELETE , RequestMethod.GET})
    public String deleteContacts(@PathVariable("id") int id)
    {
        this.contactService.deleteContacts(id);
        return "redirect:/contacts";
    }
}
