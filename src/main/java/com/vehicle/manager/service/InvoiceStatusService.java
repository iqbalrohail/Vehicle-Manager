package com.vehicle.manager.service;

import com.vehicle.manager.data.transfer.object.InvoiceStatus;
import com.vehicle.manager.data.transfer.object.MessageDto;
import com.vehicle.manager.repositories.InvoiceStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceStatusService {

    @Autowired
    private InvoiceStatusRepository invoiceStatusRepository;

    @Autowired
    private HttpSession session;


    public void helperAddInvoiceStatuss(InvoiceStatus invoiceStatus)
    {
        try {
            this.invoiceStatusRepository.saveAndFlush(invoiceStatus);
            session.setAttribute("message", new MessageDto("InvoiceStatus details have been added !", "alert-success"));

        }catch (Exception e)
        {
            session.setAttribute("message", new MessageDto("Error uploading InvoiceStatus !", "alert-danger"));

        }
    }

    public void helperUpdateInvoiceStatuss(InvoiceStatus invoiceStatus)
    {
        this.invoiceStatusRepository.saveAndFlush(invoiceStatus);
    }

    public List<InvoiceStatus> getInvoiceStatuss()
    {

        return this.invoiceStatusRepository.findAll();
    }

    public void addInvoiceStatuss(InvoiceStatus invoiceStatus)
    {
        helperAddInvoiceStatuss(invoiceStatus);
    }

    public Optional<InvoiceStatus> updateInvoiceStatusById(int id)
    {
        Optional<InvoiceStatus> invoiceStatus =this.invoiceStatusRepository.findById(id);
        return invoiceStatus;
    }

    public void updateInvoiceStatuss(InvoiceStatus invoiceStatus)
    {
        try {

            helperUpdateInvoiceStatuss(invoiceStatus);
            session.setAttribute("message", new MessageDto("InvoiceStatus details have been Updated !", "alert-success"));

        }catch (Exception e)
        {
            session.setAttribute("message", new MessageDto("Error updating InvoiceStatus !", "alert-danger"));
        }
    }

    public void deleteinvoiceStatus(int id)
    {
        try {

            InvoiceStatus invoiceStatus =this.invoiceStatusRepository.findById(id).get();
            this.invoiceStatusRepository.delete(invoiceStatus);
            session.setAttribute("message", new MessageDto("InvoiceStatus details have been deleted !", "alert-danger"));
        }catch (Exception e)
        {
            session.setAttribute("message", new MessageDto("Error deleting InvoiceStatus !", "alert-danger"));


        }
    }



}
