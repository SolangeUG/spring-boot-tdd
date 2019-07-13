package org.java.training.tdd.repository;

import org.java.training.tdd.model.Car;
import org.springframework.stereotype.Repository;

@Repository
public class CarRepository {
    public Car find(String name) {
        throw new UnsupportedOperationException();
    }
}
