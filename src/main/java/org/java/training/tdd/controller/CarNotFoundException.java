package org.java.training.tdd.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
class CarNotFoundException extends RuntimeException {
    CarNotFoundException() {}
}
