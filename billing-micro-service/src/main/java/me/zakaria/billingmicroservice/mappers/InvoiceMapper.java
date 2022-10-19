package me.zakaria.billingmicroservice.mappers;

import me.zakaria.billingmicroservice.DTOS.InvoiceRequestDTO;
import me.zakaria.billingmicroservice.DTOS.InvoiceResponseDTO;
import me.zakaria.billingmicroservice.entities.Invoice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {
    Invoice fromInvoiceRequestDTO(InvoiceRequestDTO invoiceRequestDTO);
    InvoiceResponseDTO fromInvoice(Invoice invoice);
}
