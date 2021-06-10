package com.vehicle.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.Console;

@Controller
public class view {

    @GetMapping("/index")
    public String view()
    {
        return "index";
    }

    @GetMapping("/login")
    public String login()
    {
        return "login";
    }

    @GetMapping("/logout")
    public String logout()
    {
        return "login";
    }

}
