package com.naveencodes;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void testAddition() {
        assertEquals(5, calculator.add(2, 3), "2 + 3 should equal 5");
    }

    @Test
    void testSubtraction() {
        assertEquals(1, calculator.subtract(3, 2), "3 - 2 should equal 1");
    }

    @Test
    void testMultiplication() {
        assertEquals(6, calculator.multiply(2, 3), "2 * 3 should equal 6");
    }

    @Test
    void testDivision() {
        assertEquals(2, calculator.divide(6, 3), "6 / 3 should equal 2");
    }

    @Test
    void testDivisionByZero() {
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(6, 0),
                "Division by zero should throw IllegalArgumentException");
    }

    @Test
    void testNegativeNumbers() {
        assertEquals(-5, calculator.add(-2, -3));
    }


    @Test
    void testPerformance() {
        assertTimeout(Duration.ofMillis(10), () -> {
            calculator.add(100, 200);
        });
    }

}
