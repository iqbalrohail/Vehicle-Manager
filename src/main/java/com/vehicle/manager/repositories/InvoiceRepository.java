package com.vehicle.manager.repositories;

import com.vehicle.manager.data.transfer.object.Client;
import com.vehicle.manager.data.transfer.object.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
}
