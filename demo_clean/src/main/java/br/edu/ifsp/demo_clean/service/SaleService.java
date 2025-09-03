package br.edu.ifsp.demo_clean.service;

import br.edu.ifsp.demo_clean.DTOs.SaleDTO;
import br.edu.ifsp.demo_clean.model.Car;
import br.edu.ifsp.demo_clean.model.Customer;
import br.edu.ifsp.demo_clean.model.Sale;
import br.edu.ifsp.demo_clean.repository.CarRepository;
import br.edu.ifsp.demo_clean.repository.CustomerRepository;
import br.edu.ifsp.demo_clean.repository.SaleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleService {

    private SaleRepository saleRepository;
    private CarRepository carRepository;
    private CustomerRepository customerRepository;

    public Sale createSale(SaleDTO sale) {

        Optional<Car> car = this.carRepository.findById(sale.buyerCode());

        Optional<Customer> buyer = this.customerRepository.findById(sale.buyerCode());

        if(car.isEmpty() || buyer.isEmpty()) {
            throw new RuntimeException("Car or Customer not found");
        }

        return saleRepository.save(Sale.fromDTO(sale, buyer.get(), car.get()));
    }
    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }
}
