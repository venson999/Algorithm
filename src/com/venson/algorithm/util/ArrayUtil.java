package com.venson.algorithm.util;

/**
 * Array utility
 */
public class ArrayUtil {

    /**
     * Swap the given index of value in array.
     *
     * @param a The swap array.
     * @param i The given index.
     * @param j The given index.
     */
    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * Initiate array with the specified value.
     *
     * @param a The initial array.
     * @param value The initial value.
     */
    public static void init(int[] a, int value) {
        for (int i = 0; i < a.length; i++) {
            a[i] = value;
        }
    }
}
