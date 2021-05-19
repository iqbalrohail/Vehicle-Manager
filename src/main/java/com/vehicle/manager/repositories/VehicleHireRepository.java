package com.vehicle.manager.repositories;

import com.vehicle.manager.data.transfer.object.Client;
import com.vehicle.manager.data.transfer.object.VehicleHire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleHireRepository extends JpaRepository<VehicleHire, Integer> {
}
