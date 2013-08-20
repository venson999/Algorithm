package com.venson.algorithm.integerpartition;

/**
 * Integer partition by generating function.
 */
public class GeneratingFunction {

    /**
     * Integer partition by generating function.
     *
     * @param sum The partition number.
     * @return The partition count.
     */
    public static int partition(int sum) {

        if (sum == 1) {
            return 1;
        }

        int[] a = new int[sum + 1];
        int[] b = new int[sum + 1];
        int[] c = new int[sum + 1];

        // g(x, 1) = x^0 + x^1 + x^2 + x^3 + ...
        initArray(a, 1);

        for (int i = 2; i <= sum; i++) {

            initArray(b, 0);

            // g(x, i) = x^(i*0) + x^(i*1) + x^(i*2) + x^(i*3) + ...
            for (int j = 0; j < b.length; j += i) {
                b[j] = 1;
            }

            polyMulti(a, b, c);
            System.arraycopy(c, 0, a, 0, c.length);

        }

        System.out.println(c[2]);
        System.out.println(c[4]);

        return c[sum];
    }

    /**
     * Initiate array with the specified value.
     *
     * @param a The initial array.
     * @param value The initial value.
     */
    private static void initArray(int[] a, int value) {
        for (int i = 0; i < a.length; i++) {
            a[i] = value;
        }
    }

    /**
     * The polynomial multiplication.
     *
     * @param a The polynomial a.
     * @param b The polynomial b.
     * @param c The result of multiplication.
     */
    private static void polyMulti(int[] a, int[] b, int[] c) {

        initArray(c, 0);
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j + i < c.length; j++) {
                c[i+j] += a[i] * b[j];
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(partition(6));
    }
}
