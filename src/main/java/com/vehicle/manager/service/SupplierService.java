package com.vehicle.manager.service;

import com.vehicle.manager.data.transfer.object.Supplier;
import com.vehicle.manager.data.transfer.object.MessageDto;
import com.vehicle.manager.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {


    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private HttpSession session;


    public void helperAddSuppliers(Supplier supplier)
    {
        try {
            this.supplierRepository.saveAndFlush(supplier);
            session.setAttribute("message", new MessageDto("Supplier details have been added !", "alert-success"));

        }catch (Exception e)
        {
            session.setAttribute("message", new MessageDto("Error uploading Supplier !", "alert-danger"));

        }
    }

    public void helperUpdateSuppliers(Supplier supplier)
    {
        this.supplierRepository.saveAndFlush(supplier);
    }

    public List<Supplier> getSuppliers()
    {

        return this.supplierRepository.findAll();
    }

    public void addSuppliers(Supplier supplier)
    {
        helperAddSuppliers(supplier);
    }

    public Optional<Supplier> updateSupplierById(int id)
    {
        Optional<Supplier> supplier =this.supplierRepository.findById(id);
        return supplier;
    }

    public void updateSuppliers(Supplier supplier)
    {
        try {

            helperUpdateSuppliers(supplier);
            session.setAttribute("message", new MessageDto("Supplier details have been Updated !", "alert-success"));

        }catch (Exception e)
        {
            session.setAttribute("message", new MessageDto("Error updating Supplier !", "alert-danger"));
        }
    }

    public void deleteSupplier(int id)
    {
        try {

            Supplier supplier =this.supplierRepository.findById(id).get();
            this.supplierRepository.delete(supplier);
            session.setAttribute("message", new MessageDto("Supplier details have been deleted !", "alert-danger"));
        }catch (Exception e)
        {
            session.setAttribute("message", new MessageDto("Error deleting Supplier !", "alert-danger"));

        }
    }
}
