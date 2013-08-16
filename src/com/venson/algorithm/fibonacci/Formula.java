package com.venson.algorithm.fibonacci;

import static java.lang.Math.pow;
import static java.lang.Math.rint;
import static java.lang.Math.sqrt;

/**
 * Computation fibonacci number by math formula.
 */
public class Formula {

    /**
     * Computation fibonacci number by math formula.
     *
     * @param n The Nth.
     * @return The Nth number.
     */
    public static int fibonacci(int n) {

        double sqrt5 = sqrt(5);
        return (int) rint((pow((1 + sqrt5) / 2, n) - pow((1 - sqrt5) / 2, n)) / sqrt5);
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(10));
    }
}
