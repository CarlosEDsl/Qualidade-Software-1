package br.edu.ifsp.demo_clean.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifsp.demo_clean.model.Sale;


public interface SaleRepository extends JpaRepository<Sale,Integer>{}
