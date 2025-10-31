package com.example;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

/**
 * Unit tests for Calculator class
 */
public class CalculatorTest {
    
    private Calculator calculator;
    
    @Before
    public void setUp() {
        calculator = new Calculator();
    }
    
    @Test
    public void testAdd() {
        assertEquals("2 + 3 should equal 5", 5, calculator.add(2, 3));
        assertEquals("10 + 20 should equal 30", 30, calculator.add(10, 20));
    }
    
    @Test
    public void testSubtract() {
        assertEquals("5 - 3 should equal 2", 2, calculator.subtract(5, 3));
        assertEquals("10 - 5 should equal 5", 5, calculator.subtract(10, 5));
    }
    
    @Test
    public void testMultiply() {
        assertEquals("3 * 4 should equal 12", 12, calculator.multiply(3, 4));
        assertEquals("5 * 5 should equal 25", 25, calculator.multiply(5, 5));
    }
    
    @Test
    public void testDivide() {
        assertEquals("10 / 2 should equal 5", 5, calculator.divide(10, 2));
        assertEquals("20 / 4 should equal 5", 5, calculator.divide(20, 4));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZero() {
        calculator.divide(10, 0);
    }
@Test
   public void testPower() {
       assertEquals("2^3 should equal 8", 8, calculator.power(2, 3));
       assertEquals("5^2 should equal 25", 25, calculator.power(5, 2));
   }
}