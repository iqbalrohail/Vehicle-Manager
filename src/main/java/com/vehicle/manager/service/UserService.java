package com.vehicle.manager.service;

import com.vehicle.manager.data.transfer.object.User;
import com.vehicle.manager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUsers(User user)
    {
        userRepository.saveAndFlush(user);
    }



}
