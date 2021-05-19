package com.vehicle.manager.repositories;

import com.vehicle.manager.data.transfer.object.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

    @Query("delete from State s where s.countryid=:countryid")
    State deleteByCountryId(@Param("countryid") int countryId);


}
