package com.vehicle.manager.controller;

import com.vehicle.manager.data.transfer.object.Supplier;
import com.vehicle.manager.data.transfer.object.Country;
import com.vehicle.manager.data.transfer.object.State;
import com.vehicle.manager.service.SupplierService;
import com.vehicle.manager.service.CountryService;
import com.vehicle.manager.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class SupplierController {


    @Autowired
    private SupplierService supplierService;

    @Autowired
    private StateService stateService;

    @Autowired
    private CountryService countryService;

    @GetMapping("/suppliers")
    public String getSuppliers(Model model) {
        List<State> stateList = this.stateService.getStates();
        List<Country> countryList = this.countryService.getCountries();
        List<Supplier> suppliers = this.supplierService.getSuppliers();
        model.addAttribute("countries" , countryList);
        model.addAttribute("states", stateList);
        model.addAttribute("suppliers", suppliers);
        return "supplier";
    }

    @PostMapping("/suppliers/add")
    public String addSuppliers(Supplier supplier) {
        this.supplierService.addSuppliers(supplier);
        return "redirect:/suppliers";
    }

    @GetMapping("/suppliers/updateById")
    @ResponseBody
    public Optional<Supplier> updateSupplierById(int id)
    {
        return this.supplierService.updateSupplierById(id);
    }

    @RequestMapping(value = "/suppliers/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateSuppliers(Supplier supplier)
    {
        this.supplierService.updateSuppliers(supplier);
        return "redirect:/suppliers";
    }

    @RequestMapping(value = "/suppliers/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteSupplier(@PathVariable("id") int id)
    {
        this.supplierService.deleteSupplier(id);
        return "redirect:/suppliers";
    }

}
