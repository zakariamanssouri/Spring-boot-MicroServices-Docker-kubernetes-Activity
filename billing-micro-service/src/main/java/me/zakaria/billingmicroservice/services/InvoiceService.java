package me.zakaria.billingmicroservice.services;

import me.zakaria.billingmicroservice.DTOS.InvoiceRequestDTO;
import me.zakaria.billingmicroservice.DTOS.InvoiceResponseDTO;

import java.util.List;

public interface InvoiceService {
    InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO);
    InvoiceResponseDTO getInvoice(String invoiceID);
    List<InvoiceResponseDTO> invoicesByCustomerId(String id);

    List<InvoiceResponseDTO> allInvoices();
}
