package me.zakaria.billingmicroservice.services;

import me.zakaria.billingmicroservice.DTOS.InvoiceRequestDTO;
import me.zakaria.billingmicroservice.DTOS.InvoiceResponseDTO;
import me.zakaria.billingmicroservice.exceptions.CustomerNotFoundException;

import java.util.List;

public interface InvoiceService {
    InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO) throws CustomerNotFoundException;
    InvoiceResponseDTO getInvoice(String invoiceID);
    List<InvoiceResponseDTO> invoicesByCustomerId(String id);

    List<InvoiceResponseDTO> allInvoices();
}
