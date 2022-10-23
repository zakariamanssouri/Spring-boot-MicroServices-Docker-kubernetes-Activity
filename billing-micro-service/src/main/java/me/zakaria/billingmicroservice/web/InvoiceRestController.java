package me.zakaria.billingmicroservice.web;

import me.zakaria.billingmicroservice.DTOS.InvoiceRequestDTO;
import me.zakaria.billingmicroservice.DTOS.InvoiceResponseDTO;
import me.zakaria.billingmicroservice.exceptions.CustomerNotFoundException;
import me.zakaria.billingmicroservice.services.InvoiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InvoiceRestController {
  private InvoiceService invoiceService;


  public InvoiceRestController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }
    @GetMapping("/invoices/{id}")
    public InvoiceResponseDTO getInvoice(@PathVariable(name = "id") String id){
        return invoiceService.getInvoice(id);
    }


    @GetMapping("/invoicesByCustomer/{customerId}")
    public List<InvoiceResponseDTO> getInvoicesByCustomerId(@PathVariable(name = "customerId") String customerId){
        return invoiceService.invoicesByCustomerId(customerId);
    }


    @PostMapping("/invoices")
    public InvoiceResponseDTO saveInvoice(@RequestBody InvoiceRequestDTO invoiceRequestDTO) throws CustomerNotFoundException {
        return invoiceService.save(invoiceRequestDTO);
    }

    @GetMapping("/invoices")
    public List<InvoiceResponseDTO> allInvoices(){
        return invoiceService.allInvoices();
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception e) {
        return new ResponseEntity<>(e.getMessage(), null, 500);
    }

}
