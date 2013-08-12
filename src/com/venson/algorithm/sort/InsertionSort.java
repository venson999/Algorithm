package com.venson.algorithm.sort;

import java.util.Arrays;

/**
 * Insertion Sort
 */
public class InsertionSort {

    /**
     * Insertion sort array in ascending order.
     *
     * @param a The sort array.
     */
    public static void sort(int[] a) {

        int length = a.length;

        for (int i = 1; i < length; i++) {

            int temp = a[i];
            int j = i - 1;

            while (j >= 0 && a[j] > temp) {

                a[j + 1] = a[j];
                j--;
            }

            a[j + 1] = temp;
        }
    }

    public static void main(String[] args) {

        int[] a = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };

        System.out.println(Arrays.toString(a));

        sort(a);

        System.out.println(Arrays.toString(a));

    }
}
