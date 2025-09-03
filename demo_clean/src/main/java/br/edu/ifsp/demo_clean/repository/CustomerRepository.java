package br.edu.ifsp.demo_clean.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifsp.demo_clean.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer>{}
