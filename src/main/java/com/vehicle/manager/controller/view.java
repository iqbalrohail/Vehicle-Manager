package com.vehicle.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class view {

    @GetMapping("/index")
    public String view()
    {


        return "index";
    }

}
