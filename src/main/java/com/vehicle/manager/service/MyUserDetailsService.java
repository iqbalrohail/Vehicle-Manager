package com.vehicle.manager.service;

import com.vehicle.manager.data.transfer.object.User;
import com.vehicle.manager.data.transfer.object.UserPrincipal;
import com.vehicle.manager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

       User user = userRepository.findByUsername(username);
       if(user == null)
       {
           throw new UsernameNotFoundException("can't find the user!");
       }
        return new UserPrincipal(user);
    }
}
