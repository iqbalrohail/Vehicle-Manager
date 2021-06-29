package com.vehicle.manager.controller;

import com.vehicle.manager.data.transfer.object.MessageDto;
import com.vehicle.manager.data.transfer.object.User;
import com.vehicle.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String getUsers()
    {
        return "user";
    }

    @RequestMapping(value = ("/do_register"), method = RequestMethod.POST)
    public String registerUser(@RequestParam("profileImage") MultipartFile file , User user , Model model , HttpSession session)
    {
        try {
            if (file.isEmpty()) {
                user.setPhoto("defaultPic.jpeg");
            } else {
                user.setPhoto(file.getOriginalFilename());
                File saveFile = new ClassPathResource("static/img").getFile();
                Files.copy(file.getInputStream(), Paths.get(saveFile.getAbsolutePath() + File.separator + file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            }
            userService.addUsers(user);
            model.addAttribute("user" , new User());
            session.setAttribute("message",new MessageDto("user have been registered !" , "alert-warning"));

            return "register";

        }catch (Exception e)
        {
            e.printStackTrace();
            model.addAttribute("user", user);
            session.setAttribute("message",new MessageDto("Something went wrong !" , "alert-danger"));

            return "register";
        }

    }
}
