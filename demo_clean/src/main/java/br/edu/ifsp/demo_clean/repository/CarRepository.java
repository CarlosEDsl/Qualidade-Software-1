package br.edu.ifsp.demo_clean.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifsp.demo_clean.model.Car;

public interface CarRepository extends JpaRepository<Car,Integer>{}
