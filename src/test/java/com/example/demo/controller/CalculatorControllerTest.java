package com.example.demo.controller;

import com.example.demo.service.CalculatorService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorControllerTest {

    @Mock
    CalculatorService mockCalculatorService;

    @InjectMocks
    CalculatorController calculatorController;

    @Before
    public void setup() throws Exception {
        when(mockCalculatorService.add(anyInt(), anyInt())).thenReturn(2);
        when(mockCalculatorService.subtract(anyInt(), anyInt())).thenReturn(2);
        when(mockCalculatorService.multiply(anyInt(), anyInt())). thenReturn(2);
        when(mockCalculatorService.divide(anyInt(), anyInt())).thenThrow(Exception.class);
    }


    @Test
    public void add_shouldReturn2when1and1arePassedIN() {
        int actual = calculatorController.add(1, 1);
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void add_shouldCallCalculatorServiceWithCorrectParameters() {
        calculatorController.add(2, 3);
        verify(mockCalculatorService).add(2, 3);
//        verify(mockCalculatorService, times(1)).add(2,3);
//        verify(mockCalculatorService).add(anyInt(), eq(3));
        verifyNoMoreInteractions(mockCalculatorService);
    }

    @Test
    public void add_shouldReturnWhatCalculatorServiceReturns() {
        int actual = calculatorController.add(0, 0);
        int expected = 5;
        assertEquals(expected, actual);
    }



    @Test
    public void subtract_shouldReturn1when3and2arePassedIN() {
        int actual = calculatorController.subtract(3, 2);
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void subtract_shouldCallCalculatorServiceWithCorrectParameters() {
        calculatorController.subtract(2, 3);
        verify(mockCalculatorService).subtract(2, 3);verifyNoMoreInteractions(mockCalculatorService);
    }

    @Test
    public void subtract_shouldReturnWhatCalculatorServiceReturns() {
        int actual = calculatorController.subtract(5, 0);
        int expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    public void multiply_shouldReturn6when3and2arePassedIN() {
        int actual = calculatorController.multiply(3, 2);
        int expected = 6;
        assertEquals(expected, actual);
    }

    @Test
    public void multiply_shouldCallCalculatorServiceWithCorrectParameters() {
        calculatorController.multiply(2, 3);
        verify(mockCalculatorService).multiply(2, 3);verifyNoMoreInteractions(mockCalculatorService);
    }

    @Test
    public void multiply_shouldReturnWhatCalculatorServiceReturns() {
        int actual = calculatorController.multiply(5, 0);
        int expected = 0;
        assertEquals(expected, actual);
    }

}