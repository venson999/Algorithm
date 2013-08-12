package com.venson.algorithm.sort;

import java.util.Arrays;

/**
 * Merge Sort
 */
public class MergeSort {

    /**
     * Merge sort array in ascending order.
     *
     * @param a The sort array.
     */
    public static void sort(int[] a) {
        mergeSort(a, 0, a.length - 1, new int[a.length]);
    }

    /**
     * Internal merge sort that makes recursive calls.
     *
     * @param a The sort array.
     * @param left The left-most index of the subarray.
     * @param right The right-most index of the subarray.
     * @param temp The work array.
     */
    private static void mergeSort(int[] a, int left, int right, int[] temp) {

        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(a, left, middle, temp);
            mergeSort(a, middle + 1, right, temp);
            mergeArray(a, left, middle, right, temp);
        }
    }

    /**
     * Merge array in ascending order.
     *
     * @param a The sort array.
     * @param left The left-most index of the subarray.
     * @param middle The middle index of the subarray between left and right.
     * @param right The right-most index of the subarray.
     * @param temp The work array.
     */
    private static void mergeArray(int[] a, int left, int middle, int right, int[] temp) {

        int i = left;
        int j = middle + 1;
        int k = left;

        while (i <= middle && j <= right) {

            if (a[i] <= a[j]) {
                temp[k] = a[i];
                i++;
            } else {
                temp[k] = a[j];
                j++;
            }

            k++;
        }

        while (i <= middle) {
            temp[k] = a[i];
            k++;
            i++;
        }

        while (j <= right) {
            temp[k] = a[j];
            k++;
            j++;
        }

        for (k = left; k <= right; k++) {
            a[k] = temp[k];
        }
    }

    public static void main(String[] args) {

        int[] a = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };

        System.out.println(Arrays.toString(a));

        sort(a);

        System.out.println(Arrays.toString(a));
    }

}
