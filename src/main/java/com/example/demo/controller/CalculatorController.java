package com.example.demo.controller;

import com.example.demo.service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")

public class CalculatorController {
    private final CalculatorService calculatorService;
    public CalculatorController(CalculatorService calculatorService){
                this.calculatorService = calculatorService;
            }
@GetMapping(" /add/{first}/{second}")
    public int add(@PathVariable("first") int  i, @PathVariable("second") int i1) {
        return calculatorService.add(i,i1);
        //return 2;
    }
    @GetMapping(" /subtract/{first}/{second}")
    public int subtract(@PathVariable("first") int  i, @PathVariable("second") int i1) {
        return i-i1;
    }
    //unit for service, controller, and integration test and implement
    //divide should return a 501 not implemented and an exception thrown in service
    @GetMapping(" /multiply/{first}/{second}")
    public int multiply(@PathVariable("first") int  i, @PathVariable("second") int i1) {
        return i*i1;
    }
    @GetMapping(" /divide/{first}/{second}")
    public int divide(@PathVariable("first") int  i, @PathVariable("second") int i1)throws Exception {
        return calculatorService.divide(i, i1);

    }
}

