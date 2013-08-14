package com.venson.algorithm.fibonacci;

/**
 * Computation fibonacci number by iteration.
 */
public class Iteration {

    /**
     * Computation fibonacci number by iteration.
     *
     * @param n The Nth.
     * @return The Nth number.
     */
    public static int fibonacci(int n) {

        if (n == 1 || n == 2) {
            return 1;
        }

        int first = 1;
        int second = 1;
        for (int i = 2; i < n; i++) {
            second = first + second;
            first = second - first;
        }

        return second;
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(10));
    }
}
