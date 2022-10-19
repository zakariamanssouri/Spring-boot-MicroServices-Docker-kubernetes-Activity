package me.zakaria.billingmicroservice.openfeing;

import me.zakaria.billingmicroservice.entities.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping("/api/customers/{id}")
    Customer getCsutomer(@PathVariable(name = "id") String id);

    @GetMapping("/api/customers")
    List<Customer> allCustomers();
}
