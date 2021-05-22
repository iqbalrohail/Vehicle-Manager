package com.vehicle.manager.service;

import com.vehicle.manager.data.transfer.object.Invoice;
import com.vehicle.manager.data.transfer.object.MessageDto;
import com.vehicle.manager.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private HttpSession session;


    public void helperAddInvoices(Invoice invoice)
    {
        try {
            this.invoiceRepository.saveAndFlush(invoice);
            session.setAttribute("message", new MessageDto("Invoice details have been added !", "alert-success"));

        }catch (Exception e)
        {
            session.setAttribute("message", new MessageDto("Error uploading Invoice !", "alert-danger"));

        }
    }

    public void helperUpdateInvoices(Invoice invoice)
    {
        this.invoiceRepository.saveAndFlush(invoice);
    }

    public List<Invoice> getInvoices()
    {

        return this.invoiceRepository.findAll();
    }

    public void addInvoices(Invoice invoice)
    {
        helperAddInvoices(invoice);
    }

    public Optional<Invoice> updateInvoiceById(int id)
    {
        Optional<Invoice> invoice =this.invoiceRepository.findById(id);
        return invoice;
    }

    public void updateInvoices(Invoice invoice)
    {
        try {

            helperUpdateInvoices(invoice);
            session.setAttribute("message", new MessageDto("Invoice details have been Updated !", "alert-success"));

        }catch (Exception e)
        {
            session.setAttribute("message", new MessageDto("Error updating Invoice !", "alert-danger"));
        }
    }

    public void deleteinvoice(int id)
    {
        try {

            Invoice invoice =this.invoiceRepository.findById(id).get();
            this.invoiceRepository.delete(invoice);
            session.setAttribute("message", new MessageDto("Invoice details have been deleted !", "alert-danger"));
        }catch (Exception e)
        {
            session.setAttribute("message", new MessageDto("Error deleting Invoice !", "alert-danger"));


        }
    }



}
