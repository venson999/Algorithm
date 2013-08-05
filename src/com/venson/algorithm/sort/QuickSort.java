package com.venson.algorithm.sort;

import static com.venson.algorithm.util.ArrayUtil.swap;

import java.util.Arrays;

public class QuickSort {

    /**
     * Quicksort an int array.
     *
     * @param a an int array that is wanted to sort.
     */
    public void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    /**
     * Internal quicksort that makes recursive calls.
     *
     * @param a an int array that is wanted to sort.
     * @param low the left-most index of the subarray.
     * @param high the right-most index of the subarray.
     */
    public void sort(int[] a, int low, int high) {

        if (low >= high) {
            return;
        }

        int pivot = partition(a, low, high);

        sort(a, low, pivot - 1);

        sort(a, pivot + 1, high);
    }

    /**
     * Partition an int array into two part by returning a index pivot, left
     * part is not greater than pivot and right part is not less than pivot.
     *
     * Another way to explain Partition the subarray a[low .. high] by returning
     * an index pivot So that a[low .. pivot-1] <= a[pivot] <= a[pivot+1 ..
     * high]
     *
     * @param a an int array that is wanted to partition.
     * @param low the left-most index of the subarray.
     * @param high the right-most index of the subarray.
     * @return a partitioned int array.
     */
    private int partition(int[] a, int low, int high) {

        // choose a key to compare
        int key = a[low];

        int i = low;

        int j = high;

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

    /**
     * @param args
     */
    public static void main(String[] args) {

        QuickSort quickSort = new QuickSort();

        // int[] array = { 3, 4, 1, 2, 5, 7, 8, 0, 9 };

        // int[] array1 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        // int[] array2 = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };

        int[] array2 = { 0, 1, 2, 8, 8, 7, 7, 6, 6, 9 };

        System.out.println(Arrays.toString(array2));

        quickSort.sort(array2);

        System.out.println(Arrays.toString(array2));
    }
}
