package com.vehicle.manager.controller;

import com.vehicle.manager.data.transfer.object.*;
import com.vehicle.manager.service.*;
import com.vehicle.manager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private StateService stateService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private EmployeeTypeService employeeTypeService;

    @Autowired
    private JobTitleService jobTitleService;

    @GetMapping("/employees")
    public String getEmployees(Model model) {
        List<Employee> employees = this.employeeService.getEmployees();
        List<EmployeeType> employeeTypes = this.employeeTypeService.getEmployeeTypes();
        List<JobTitle> jobTitles = this.jobTitleService.getJobTitles();
        List<State> stateList = this.stateService.getStates();
        List<Country> countryList = this.countryService.getCountries();
        model.addAttribute("employees", employees);
        model.addAttribute("employeeTypes", employeeTypes);
        model.addAttribute("jobTitles", jobTitles);
        model.addAttribute("countries" , countryList);
        model.addAttribute("states", stateList);
        return "employee";
    }

    @PostMapping("/employees/add")
    public String addEmployees(Employee employee  , @RequestParam("EmployeePhoto") MultipartFile file) throws IOException {

        if (file.isEmpty()) {
            employee.setPhoto("defaultPic.jpeg");
        } else {
            employee.setPhoto(file.getOriginalFilename());
            File saveFile = new ClassPathResource("static/img").getFile();
            Files.copy(file.getInputStream(), Paths.get(saveFile.getAbsolutePath() + File.separator + file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
        }

        this.employeeService.addEmployees(employee);
        return "redirect:/employees";
    }

    @GetMapping("/employees/updateById")
    @ResponseBody
    public Optional<Employee> updateEmployeeById(int id)
    {
        return this.employeeService.updateEmployeeById(id);
    }

    @RequestMapping(value = "/employees/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateEmployees(Employee employee)
    {
        this.employeeService.updateEmployees(employee);
        return "redirect:/employees";
    }

    @RequestMapping(value = "/employees/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteEmployee(@PathVariable("id") int id)
    {
        this.employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }
}
