package com.venson.algorithm.sort;

import static com.venson.algorithm.util.ArrayUtil.swap;

import java.util.Arrays;

/**
 * Quick Sort
 */
public class QuickSort {

    /**
     * Quick sort array in ascending order.
     *
     * @param a The sort array.
     */
    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    /**
     * Internal quick sort that makes recursive calls.
     *
     * @param a The sort array.
     * @param left The left-most index of the subarray.
     * @param right The right-most index of the subarray.
     */
    private static void sort(int[] a, int left, int right) {

        if (left >= right) {
            return;
        }

        int pivot = partition(a, left, right);

        sort(a, left, pivot - 1);

        sort(a, pivot + 1, right);
    }

    /**
     * Partition an int array into two part by returning a index pivot, left
     * part is not greater than pivot and right part is not less than pivot.
     *
     * Another way to explain Partition the subarray a[low .. high] by returning
     * an index pivot So that a[low .. pivot-1] <= a[pivot] <= a[pivot+1 ..
     * high]
     *
     * @param a The sort array.
     * @param left The left-most index of the subarray.
     * @param right The right-most index of the subarray.
     * @return The pivot between left and right.
     */
    private static int partition(int[] a, int left, int right) {

        // choose a key to compare
        int key = a[left];

        int i = left;

        int j = right;

        while (i < j) {

            // find the items that are less than key from high to low
            while (i < j) {

                if (key > a[j]) {
                    swap(a, i, j);
                    break;
                }

                j--;
            }

            // find the items that are greater than key from low to high
            while (i < j) {

                if (key < a[i]) {
                    swap(a, i, j);
                    break;
                }

                i++;
            }
        }

        return j;
    }

    public static void main(String[] args) {

        int[] a = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };

        System.out.println(Arrays.toString(a));

        sort(a);

        System.out.println(Arrays.toString(a));
    }
}
