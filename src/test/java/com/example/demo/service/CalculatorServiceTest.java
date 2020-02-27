package com.example.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorServiceTest {
    @InjectMocks
    CalculatorService calculatorService;
    @Test
    public void add_ShouldReturn2When1and1IsPassedIn()
    {
        int actual = calculatorService.add(1,1);
        int expected = 2;
        assertEquals(expected,actual);

    }
    @Test
    public void add_shouldReturn4When2and2IsPassedIn(){
        int actual = calculatorService.add(2,2);
        int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    public void add_shouldReturn10When8and2IsPAssedIn(){
        int actual = calculatorService.add(8,2);
        int expected = 10;
        assertEquals(expected, actual);
    }


}
