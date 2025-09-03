package br.edu.ifsp.demo_clean.controller;

import br.edu.ifsp.demo_clean.DTOs.CustomerDTO;
import br.edu.ifsp.demo_clean.model.Customer;
import br.edu.ifsp.demo_clean.service.CustomerService;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("customers")
@Schema(title = "Rota de usuários")
public class CustomerController {

    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<Void> createCustomer(@RequestBody CustomerDTO customer) {
        Customer saved = customerService.createCustomer(customer);

        URI location = URI.create("/customers/" + saved.getCode());
        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getllCustomers();

        return ResponseEntity.ok(customers);
    }

}
