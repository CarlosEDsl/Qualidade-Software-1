package br.edu.ifsp.demo_clean.service;

import br.edu.ifsp.demo_clean.DTOs.CustomerDTO;
import br.edu.ifsp.demo_clean.model.Customer;
import br.edu.ifsp.demo_clean.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(CustomerDTO customer) {
        return customerRepository.save(Customer.fromDTO(customer));
    }

    public List<Customer> getllCustomers() {
        return customerRepository.findAll();
    }

}
