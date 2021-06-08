package com.vehicle.manager.service;

import com.vehicle.manager.data.transfer.object.EmployeeType;
import com.vehicle.manager.data.transfer.object.MessageDto;
import com.vehicle.manager.repositories.EmployeeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeTypeService {

    @Autowired
    private EmployeeTypeRepository employeeTypeRepository;

    @Autowired
    private HttpSession session;


    public void helperAddEmployeeTypes(EmployeeType employeeType)
    {
        try {
            this.employeeTypeRepository.saveAndFlush(employeeType);
            session.setAttribute("message", new MessageDto("EmployeeType details have been added !", "alert-success"));

        }catch (Exception e)
        {
            session.setAttribute("message", new MessageDto("Error uploading EmployeeType !", "alert-danger"));

        }
    }

    public void helperUpdateEmployeeTypes(EmployeeType employeeType)
    {
        this.employeeTypeRepository.saveAndFlush(employeeType);
    }

    public List<EmployeeType> getEmployeeTypes()
    {

        return this.employeeTypeRepository.findAll();
    }

    public void addEmployeeTypes(EmployeeType employeeType)
    {
        helperAddEmployeeTypes(employeeType);
    }

    public Optional<EmployeeType> updateEmployeeTypeById(int id)
    {
        Optional<EmployeeType> employeeType =this.employeeTypeRepository.findById(id);
        return employeeType;
    }

    public void updateEmployeeTypes(EmployeeType employeeType)
    {
        try {

            helperUpdateEmployeeTypes(employeeType);
            session.setAttribute("message", new MessageDto("EmployeeType details have been Updated !", "alert-success"));

        }catch (Exception e)
        {
            session.setAttribute("message", new MessageDto("Error updating EmployeeType !", "alert-danger"));
        }
    }

    public void deleteEmployeeTypes(int id)
    {
        try {

            EmployeeType employeeType =this.employeeTypeRepository.findById(id).get();
            this.employeeTypeRepository.delete(employeeType);
            session.setAttribute("message", new MessageDto("EmployeeType details have been deleted !", "alert-danger"));
        }catch (Exception e)
        {
            session.setAttribute("message", new MessageDto("Error deleting EmployeeType !", "alert-danger"));


        }
    }


}
