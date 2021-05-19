package com.vehicle.manager.repositories;

import com.vehicle.manager.data.transfer.object.Client;
import com.vehicle.manager.data.transfer.object.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
}
