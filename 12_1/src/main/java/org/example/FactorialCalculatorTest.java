package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;


public class FactorialCalculatorTest {

    @Test
    public void testFactorialPositiveNumber() {
        assertEquals(120, FactorialCalculator.factorial(5));
        assertEquals(1, FactorialCalculator.factorial(0)); // Факториал 0 = 1
    }

    @Test
    public void testFactorialLargeNumber() {
        assertEquals(479001600, FactorialCalculator.factorial(12));
    }

    @Test
    public void testFactorialNegativeNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            FactorialCalculator.factorial(-5);
        });
        assertEquals("Number must be non-negative.", exception.getMessage());
    }
}