package com.vehicle.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonObjectController {

    @GetMapping("/commonObjects")
    public String getCommonObjects()
    {

        return "commonObject";
    }
}
