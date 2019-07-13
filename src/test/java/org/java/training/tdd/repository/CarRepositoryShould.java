package org.java.training.tdd.repository;

import org.java.training.tdd.model.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@DataJpaTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = NONE)
public class CarRepositoryShould {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void return_a_car_given_its_name() {
        Car expected = new Car("audi 5", "petrol");
        testEntityManager.persistFlushFind(expected);

        Car actual = carRepository.findByName("audi 5");

        assertThat(actual).isEqualTo(expected);
    }
}