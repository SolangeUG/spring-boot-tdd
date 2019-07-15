package org.java.training.tdd.service;

import org.java.training.tdd.model.Car;
import org.java.training.tdd.repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CarServiceShould {

    private CarService carService;
    private CarRepository carRepository;

    @BeforeEach
    void setUp() {
        carRepository = mock(CarRepository.class);
        carService = new CarService(carRepository);
    }

    @Test
    void return_a_car_given_its_name() {
        String name = "tesla";
        Car expected = new Car(name, "electric");
        when(carRepository.findByName(name)).thenReturn(expected);

        Car actual = carService.detailsFor(name);

        assertThat(actual).isEqualTo(expected);
    }
}