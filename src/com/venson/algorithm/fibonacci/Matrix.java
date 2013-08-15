package com.venson.algorithm.fibonacci;

/**
 * Computation fibonacci number by matrix.
 */
public class Matrix {

    /**
     * Computation fibonacci number by matrix.
     *
     * @param n The Nth.
     * @return The Nth number.
     */
    public static int fibonacci(int n) {

        if (n == 1 || n == 2) {
            return 1;
        }

        // The general formula by matrix.
        //                n-2
        // (f(n)  )  (1 1)    (1)
        // (f(n-1))  (1 0)    (1)

        // (1 1)
        // (1 0)
        int m00 = 1, m01 = 1, m10 = 1, m11 = 0;

        // The result matrix and its initial value is for case n=3.
        // (1 0)
        // (0 1)
        int r00 = 1, r01 = 0, r10 = 0, r11 = 1;

        // The temp matrix.
        int t00, t01, t10, t11;

        //       n-2
        // (1 1)
        // (1 0)
        for (int i = 0; i < n - 2; i++) {
            t00 = m00 * r00 + m01 * r10;
            t01 = m00 * r01 + m01 * r11;
            t10 = m10 * r00 + m11 * r10;
            t11 = m10 * r01 + m11 * r11;
            r00 = t00; r01 = t01; r10 = t10; r11 = t11;
        }

        // f(n) = r00 * 1 + r01 * 1
        return r00 + r01;
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(10));
    }
}
