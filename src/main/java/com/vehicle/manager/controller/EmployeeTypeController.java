package com.vehicle.manager.controller;

import com.vehicle.manager.data.transfer.object.EmployeeType;
import com.vehicle.manager.service.EmployeeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeTypeController {


    @Autowired
    private EmployeeTypeService employeeTypeService;

    @GetMapping("/employeeTypes")
    public String getEmployeeTypes(Model model) {
        List<EmployeeType> employeeTypes = this.employeeTypeService.getEmployeeTypes();
        model.addAttribute("employeeTypes", employeeTypes);
        return "employeeType";
    }

    @PostMapping("/employeeTypes/add")
    public String addEmployeeTypes(EmployeeType employeeType) {
        this.employeeTypeService.addEmployeeTypes(employeeType);
        return "redirect:/employeeTypes";
    }

    @GetMapping("/employeeTypes/updateById")
    @ResponseBody
    public Optional<EmployeeType> updateEmployeeTypeById(int id) {
        return this.employeeTypeService.updateEmployeeTypeById(id);
    }

    @RequestMapping(value = "/employeeTypes/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateEmployeeTypes(EmployeeType employeeType) {
        this.employeeTypeService.updateEmployeeTypes(employeeType);
        return "redirect:/employeeTypes";
    }

    @RequestMapping(value = "/employeeTypes/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteEmployeeTypes(@PathVariable("id") int id) {
        this.employeeTypeService.deleteEmployeeTypes(id);
        return "redirect:/employeeTypes";
    }

}
