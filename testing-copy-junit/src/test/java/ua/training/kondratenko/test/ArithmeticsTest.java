package ua.training.kondratenko.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

class ArithmeticsTest {

    private Arithmetics arithmetics;

    @BeforeEach
    public void runT(){
        arithmetics = new Arithmetics();
    }

    @Test
    public void testAdd(){
        double res = arithmetics.add(3, 7);
        Assertions.assertEquals(res, 10.0);
    }

    @Test
    public void testDeduct(){
        double res = arithmetics.deduct(3, 7);
        Assertions.assertEquals(res, -4.0);
    }

    @Test
    public void testMultiply(){
        double res = arithmetics.multiply(3, 7);
        Assertions.assertEquals(res, 21.0);
    }

    @Test
    public void testDiv(){
        double res = arithmetics.divide(10, 5);
        Assertions.assertEquals(res, 2.0);
    }

    @Test
    public void testDivException(){
        Assertions.assertThrows(ArithmeticException.class, () -> {
            arithmetics.divide(10.0, 0.0);
        });
    }

    @Test
    @Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
    public void testN(){
        arithmetics.divide(10.0, 10.0);
    }
}