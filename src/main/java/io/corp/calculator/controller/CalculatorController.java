package io.corp.calculator.controller;

import io.corp.calculator.TracerImpl;
import io.corp.calculator.service.CalculatorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author erondon (1.0)
 * @version 1.0
 */
@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    @Autowired
    private CalculatorService servicioCalculator;

    private TracerImpl tracer = new TracerImpl();


    @GetMapping(value = "/calculate")
    public ResponseEntity<Double> calcula(@RequestParam(name = "salary") double salary,
                                            @RequestParam(name = "hours") int hours,
                                            @RequestParam(name = "operation") String operation) {

        double result = this.servicioCalculator.calculator(salary, hours, operation);
        tracer.trace(result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
