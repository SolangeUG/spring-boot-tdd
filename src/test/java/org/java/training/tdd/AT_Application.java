package org.java.training.tdd;

import org.java.training.tdd.model.Car;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static java.util.Objects.requireNonNull;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class AT_Application {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void return_a_car_details_response() {
        ResponseEntity<Car> response = restTemplate.getForEntity("/cars/prius", Car.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(requireNonNull(response.getBody()).getName()).isEqualTo("prius");
        assertThat(requireNonNull(response.getBody()).getType()).isEqualTo("hybrid");
    }

    @Test
    void return_a_car_not_found_response_when_given_an_uknown_car() {
        ResponseEntity<Car> response = restTemplate.getForEntity("/cars/tesla", Car.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}
