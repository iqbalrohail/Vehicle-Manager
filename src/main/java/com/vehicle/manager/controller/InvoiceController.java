package com.vehicle.manager.controller;

import com.vehicle.manager.data.transfer.object.Client;
import com.vehicle.manager.data.transfer.object.Country;
import com.vehicle.manager.data.transfer.object.Invoice;
import com.vehicle.manager.data.transfer.object.State;
import com.vehicle.manager.service.ClientService;
import com.vehicle.manager.service.CountryService;
import com.vehicle.manager.service.InvoiceService;
import com.vehicle.manager.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class InvoiceController {


    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private ClientService clientService;


    @GetMapping("/invoices")
    public String getInvoices(Model model) {
        List<Client> clientList = this.clientService.getClients();
        List<Invoice> invoices = this.invoiceService.getInvoices();
        model.addAttribute("clients", clientList);
        model.addAttribute("invoices", invoices);
        return "invoice";
    }

    @PostMapping("/invoices/add")
    public String addInvoices(Invoice invoice) {
        this.invoiceService.addInvoices(invoice);
        return "redirect:/invoices";
    }

    @GetMapping("/invoices/updateById")
    @ResponseBody
    public Optional<Invoice> updateInvoiceById(int id) {
        return this.invoiceService.updateInvoiceById(id);
    }

    @RequestMapping(value = "/invoices/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateInvoices(Invoice invoice) {
        this.invoiceService.updateInvoices(invoice);
        return "redirect:/invoices";
    }

    @RequestMapping(value = "/invoices/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteInvoice(@PathVariable("id") int id) {
        this.invoiceService.deleteinvoice(id);
        return "redirect:/invoices";
    }


}
