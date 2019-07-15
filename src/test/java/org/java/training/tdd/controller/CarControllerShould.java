package org.java.training.tdd.controller;

import org.java.training.tdd.model.Car;
import org.java.training.tdd.service.CarService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class CarControllerShould {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarService carService;

    @Test
    void return_a_car_details() throws Exception {
        String name = "prius";
        String type = "hybrid";
        Car prius = new Car(name, type);
        when(carService.detailsFor(name)).thenReturn(prius);

        mockMvc.perform(get("/cars/{name}", name))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value(name))
                .andExpect(jsonPath("type").value(type));
    }

    @Test
    void return_a_car_not_found_response() throws Exception {
        String name = "tesla";
        when(carService.detailsFor(name)).thenReturn(null);

        mockMvc.perform(get("/cars/{name}", name))
                .andExpect(status().isNotFound());
    }
}
