package com.vehicle.manager.controller;

import com.vehicle.manager.data.transfer.object.User;
import com.vehicle.manager.repositories.UserRepository;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.Console;
import java.security.Principal;

@Controller
public class view {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/index")
    public String view(Model model , Principal principal)
    {
        String currentUserName =principal.getName();
       User user =  userRepository.findByUsername(currentUserName);
        System.out.println(user);
       model.addAttribute("user" , user);
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

    @GetMapping("/register")
    public String register(Model model)
    {
        model.addAttribute("user" , new User());
        return "register";
    }




}
