package com.venson.algorithm.sort;

import static com.venson.algorithm.util.ArrayUtil.swap;

import java.util.Arrays;

/**
 * Bubble Sort
 */
public class BubbleSort {

    /**
     * Bubble sort array in ascending order.
     *
     * @param a The sort array.
     */
    public static void sort(int[] a) {

        for (int i = 0; i < a.length - 1; i++) {

            for (int j = a.length - 1; j > i; j--) {

                if (a[j] < a[j - 1]) {
                    swap(a, j - 1, j);
                }
            }
        }
    }

    public static void main(String[] args) {

        int[] a = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };

        System.out.println(Arrays.toString(a));

        sort(a);

        System.out.println(Arrays.toString(a));
    }
}
