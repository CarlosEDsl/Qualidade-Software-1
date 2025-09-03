package br.edu.ifsp.demo_clean.service;

import br.edu.ifsp.demo_clean.DTOs.CarDTO;
import br.edu.ifsp.demo_clean.model.Car;
import br.edu.ifsp.demo_clean.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private CarRepository carRepository;

    public Car createCar(CarDTO car) {
        return carRepository.save(Car.fromDTO(car));
    }
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

}
