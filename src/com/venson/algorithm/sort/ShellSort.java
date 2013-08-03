package com.venson.algorithm.sort;

import java.util.Arrays;

/**
 * Shell Sort
 */
public class ShellSort {

    public static void sort(int[] a) {

        int step = a.length;

        while ((step = step / 2) > 0) {

            for (int i = 0; i < step; i++) {

                for (int j = i + step; j < a.length; j += step) {

                    int temp = a[j];

                    int k = j - step;

                    while (k >= 0 && a[k] > temp) {

                        a[k + step] = a[k];
                        k -= step;
                    }

                    a[k + step] = temp;
                }
            }
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        int[] a = { 0, 8, 7, 3, 5, 4, 6, 2, 1, 9 };
        sort(a);

        System.out.println(Arrays.toString(a));
    }
}
