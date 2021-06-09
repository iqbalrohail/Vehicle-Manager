package com.vehicle.manager.service;

import com.vehicle.manager.data.transfer.object.Employee;
import com.vehicle.manager.data.transfer.object.MessageDto;
import com.vehicle.manager.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private HttpSession session;


    public void helperAddEmployees(Employee employee )
    {
        try {





            this.employeeRepository.saveAndFlush(employee);
            session.setAttribute("message", new MessageDto("Employee details have been added !", "alert-success"));

        }catch (Exception e)
        {
            session.setAttribute("message", new MessageDto("Error uploading Employee !", "alert-danger"));

        }
    }

    public void helperUpdateEmployees(Employee employee)
    {
        this.employeeRepository.saveAndFlush(employee);
    }

    public List<Employee> getEmployees()
    {

        return this.employeeRepository.findAll();
    }

    public void addEmployees(Employee employee )
    {
        helperAddEmployees(employee );
    }

    public Optional<Employee> updateEmployeeById(int id)
    {
        Optional<Employee> employee =this.employeeRepository.findById(id);
        return employee;
    }

    public void updateEmployees(Employee employee)
    {
        try {

            helperUpdateEmployees(employee);
            session.setAttribute("message", new MessageDto("Employee details have been Updated !", "alert-success"));

        }catch (Exception e)
        {
            session.setAttribute("message", new MessageDto("Error updating Employee !", "alert-danger"));
        }
    }

    public void deleteEmployee(int id)
    {
        try {

            Employee employee =this.employeeRepository.findById(id).get();
            this.employeeRepository.delete(employee);
            session.setAttribute("message", new MessageDto("Employee details have been deleted !", "alert-danger"));
        }catch (Exception e)
        {
            session.setAttribute("message", new MessageDto("Error deleting Employee !", "alert-danger"));


        }
    }


}
