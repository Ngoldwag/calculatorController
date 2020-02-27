package com.example.demo.service;


import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public int add (int i, int j) {

        return i+j;
    }

    public int subtract (int i, int j) {

        return i-j;
    }

    public int multiply(int i, int j) {
        return i*j;
    }

    public int divide(int i, int j) throws Exception {
        throw new NullPointerException();
    }
}
