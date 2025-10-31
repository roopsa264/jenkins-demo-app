package com.example;

/**
 * Simple Calculator class for demonstration
 */
public class Calculator {
    
    /**
     * Adds two numbers
     */
    public int add(int a, int b) {
        return a + b;
    }
    
    /**
     * Subtracts two numbers
     */
    public int subtract(int a, int b) {
        return a - b;
    }
    
    /**
     * Multiplies two numbers
     */
    public int multiply(int a, int b) {
        return a * b;
    }
    
    /**
     * Divides two numbers
     */
    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }
}