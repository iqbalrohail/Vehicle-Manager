package com.vehicle.manager.repositories;

import com.vehicle.manager.data.transfer.object.Client;
import com.vehicle.manager.data.transfer.object.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


    @Query("from Employee e where e.user.id = :employeeId")
    public List<Employee> getEmployeesByUser(@Param("employeeId") int employeeId);
}
