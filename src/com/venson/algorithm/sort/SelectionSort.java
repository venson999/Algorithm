package com.venson.algorithm.sort;

import static com.venson.algorithm.util.ArrayUtil.swap;

import java.util.Arrays;

/**
 * Selection Sort
 */
public class SelectionSort {

    /**
     * Selection sort array in ascending order.
     *
     * @param a The sort array.
     */
    public static void sort(int[] a) {

        for (int i = 0; i < a.length; i++) {

            for (int j = i + 1; j < a.length; j++) {

                if (a[i] > a[j]) {
                    swap(a, i, j);
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
