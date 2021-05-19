package com.vehicle.manager.repositories;

import com.vehicle.manager.data.transfer.object.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
