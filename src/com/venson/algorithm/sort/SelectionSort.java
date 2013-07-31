package com.venson.algorithm.sort;

import java.util.Arrays;

import static com.venson.algorithm.util.ArrayUtil.swap;

/**
 * Selection Sort
 */
public class SelectionSort {

    public static void sort(int[] a) {

        for (int i = 0; i < a.length; i++) {

            for (int j = i + 1; j < a.length; j++) {

                if (a[i] > a[j]) {
                    swap(a, i, j);
                }
            }
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        int[] a = { 5, 4, 3, 2, 1 };
        sort(a);

        System.out.println(Arrays.toString(a));
    }
}
