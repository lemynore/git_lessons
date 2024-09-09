package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class FactorialCalculatorTest {

    @Test
    public void testFactorialPositiveNumber() {
        assertEquals(FactorialCalculator.factorial(5), 120);
        assertEquals(FactorialCalculator.factorial(0), 1);
    }

    @Test
    public void testFactorialLargeNumber() {
        assertEquals(FactorialCalculator.factorial(12), 479001600);
    }

    @Test
    public void testFactorialNegativeNumber() {
        // Использование assertThrows для проверки исключений
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            FactorialCalculator.factorial(-5);
        });
        assertEquals(thrown.getMessage(), "Number must be non-negative.");
    }
}
