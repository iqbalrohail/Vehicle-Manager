package com.vehicle.manager.repositories;

import com.vehicle.manager.data.transfer.object.Client;
import com.vehicle.manager.data.transfer.object.CommonObject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommonObjectRepository extends JpaRepository<CommonObject, Integer> {
}
