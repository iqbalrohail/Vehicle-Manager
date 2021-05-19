package com.vehicle.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {

        @GetMapping("/contacts")
        public String getContacts()
        {

            return "blankContact";
        }
}
