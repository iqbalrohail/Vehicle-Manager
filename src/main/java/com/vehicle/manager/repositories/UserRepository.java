package com.vehicle.manager.repositories;

import com.vehicle.manager.data.transfer.object.Client;
import com.vehicle.manager.data.transfer.object.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByUsername(String username);
}
