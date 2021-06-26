package ua.training.kondratenko.test;

public class Arithmetics {

    public double add(double a, double b){
        return a + b;
    }

    public double deduct(double a, double b){
        return a - b;
    }

    public double multiply(double a, double b){
        return a * b;
    }

    public double divide(double a, double b){
        if (b == 0) throw new ArithmeticException();
        return a / b;
    }
}
