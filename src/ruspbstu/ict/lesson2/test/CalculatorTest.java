package ruspbstu.ict.lesson2.test;

import org.junit.jupiter.api.Test;
import ruspbstu.ict.lesson2.calculator.Calculator;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void exp() throws Exception {
        String testStr = "((5+4)*(135/32))";
        Calculator calc = new Calculator();
        calc.exp(testStr);
        double epsilon = 0.0000001d;
        assertEquals(37.96875d, calc.pop(), epsilon);
    }

}