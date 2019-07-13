package org.java.training.tdd.service;

import org.java.training.tdd.model.Car;
import org.java.training.tdd.repository.CarRepository;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class CarServiceShould {

    private CarService carService;
    private CarRepository carRepository;

    @Before
    public void setUp() {
        carRepository = mock(CarRepository.class);
        carService = new CarService(carRepository);
    }

    @Test
    public void return_a_car_given_its_name() {
        String name = "tesla";
        Car expected = new Car(name, "electric");
        when(carRepository.findByName(name)).thenReturn(expected);

        Car actual = carService.detailsFor(name);

        assertThat(actual).isEqualTo(expected);
    }
}