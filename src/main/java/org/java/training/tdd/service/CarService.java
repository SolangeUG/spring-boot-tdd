package org.java.training.tdd.service;

import org.java.training.tdd.model.Car;
import org.java.training.tdd.repository.CarRepository;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car detailsFor(String name) {
        return carRepository.findByName(name);
    }
}
