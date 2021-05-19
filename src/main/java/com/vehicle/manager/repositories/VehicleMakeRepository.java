package com.vehicle.manager.repositories;

import com.vehicle.manager.data.transfer.object.Client;
import com.vehicle.manager.data.transfer.object.VehicleMake;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleMakeRepository extends JpaRepository<VehicleMake, Integer> {
}
