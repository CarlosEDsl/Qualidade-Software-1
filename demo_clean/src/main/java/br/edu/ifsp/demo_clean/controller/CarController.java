package br.edu.ifsp.demo_clean.controller;

import br.edu.ifsp.demo_clean.DTOs.CarDTO;
import br.edu.ifsp.demo_clean.model.Car;
import br.edu.ifsp.demo_clean.service.CarService;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cars")
@Schema(title = "Rota de carro")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public ResponseEntity<Void> createCar(@RequestBody CarDTO car) {
        Car saved = carService.createCar(car);
        URI location = URI.create("/cars/" + saved.getCode());
        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public ResponseEntity<List<Car>> getAllCars() {
        List<Car> cars = carService.getAllCars();
        return ResponseEntity.ok(cars);
    }
}
