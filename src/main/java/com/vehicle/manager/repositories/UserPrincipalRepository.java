package com.vehicle.manager.repositories;

import com.vehicle.manager.data.transfer.object.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPrincipalRepository extends JpaRepository<User, Integer> {
}
