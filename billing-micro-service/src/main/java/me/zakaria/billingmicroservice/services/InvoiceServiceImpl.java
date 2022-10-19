package me.zakaria.billingmicroservice.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import me.zakaria.billingmicroservice.DTOS.InvoiceRequestDTO;
import me.zakaria.billingmicroservice.DTOS.InvoiceResponseDTO;
import me.zakaria.billingmicroservice.entities.Customer;
import me.zakaria.billingmicroservice.entities.Invoice;
import me.zakaria.billingmicroservice.mappers.InvoiceMapper;
import me.zakaria.billingmicroservice.openfeing.CustomerRestClient;
import me.zakaria.billingmicroservice.repositories.InvoiceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private InvoiceRepository invoiceRepository;
    private InvoiceMapper invoiceMapper;
    private CustomerRestClient customerRestClient;



    @Override
    public InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO) {
        Invoice invoice=invoiceMapper.fromInvoiceRequestDTO(invoiceRequestDTO);
        invoice.setId(UUID.randomUUID().toString());
        invoice.setDate(new Date());
        Invoice savedInvoice=invoiceRepository.save(invoice);
        return invoiceMapper.fromInvoice(savedInvoice);
    }

    @Override
    public InvoiceResponseDTO getInvoice(String invoiceID) {
        Invoice invoice=invoiceRepository.findById(invoiceID).orElse(null);
        Customer customer = customerRestClient.getCsutomer(invoice.getClientId());
        //print customer name
        System.out.println(customer.getEmail());

        invoice.setCustomer(customer);
        return invoiceMapper.fromInvoice(invoice);
    }
    @Override
    public List<InvoiceResponseDTO> invoicesByCustomerId(String id) {
        List<Invoice> invoices=invoiceRepository.findByClientId(id);
        return invoices.stream().map(invoice -> invoiceMapper.fromInvoice(invoice)).toList();
    }

    @Override
    public List<InvoiceResponseDTO> allInvoices() {
        List<Invoice> invoices = invoiceRepository.findAll();
        invoices.forEach(invoice -> {
            Customer customer = customerRestClient.getCsutomer(invoice.getClientId());
            invoice.setCustomer(customer);
        });
        return invoices.stream().map(invoice -> invoiceMapper.fromInvoice(invoice)).toList();
    }

}
