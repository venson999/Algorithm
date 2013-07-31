package com.venson.algorithm.sort;

import java.util.Arrays;

public class InsertionSort {

    /**
     * Insertionsort an int array.
     *
     * @param a an int array that is wanted to sort.
     */
    public void sort(int[] a) {

        int length = a.length;

        for (int i = 1; i < length; i++) {

            int temp = a[i];

            for (int j = i; j > 0; j--) {

                if (a[j - 1] > temp) {

                    a[j] = a[j - 1];

                    if (j - 1 == 0) {

                        a[j - 1] = temp;
                        break;
                    }

                } else if (a[j - 1] < temp) {

                    a[j] = temp;
                    break;
                }
            }
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        InsertionSort insertionSort = new InsertionSort();

        int[] array2 = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };

        System.out.println(Arrays.toString(array2));

        insertionSort.sort(array2);

        System.out.println(Arrays.toString(array2));

    }

}
