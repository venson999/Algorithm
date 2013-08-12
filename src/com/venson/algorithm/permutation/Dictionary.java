package com.venson.algorithm.permutation;

import static com.venson.algorithm.util.ArrayUtil.swap;

import java.util.Arrays;

import com.venson.algorithm.sort.SelectionSort;

/**
 * Permutate by dictionary order
 */
public class Dictionary {

    /**
     * Permutate array by dictionary order.
     *
     * @param a The permutate array.
     */
    public static void perm(int[] a) {

        sort(a);

        while (true) {

            System.out.println(Arrays.toString(a));

            int i, j;
            for (i = a.length - 2; i >= 0; i--) {
                if (a[i] < a[i + 1]) {
                    break;
                }
                if (i == 0) {
                    return;
                }
            }

            for (j = a.length - 1; j > i; j--) {
                if (a[j] > a[i]) {
                    break;
                }
            }

            swap(a, i, j);
            reverse(a, i + 1, a.length - 1);
        }
    }

    public static void sort(int[] a) {

        SelectionSort.sort(a);
    }

    public static void reverse(int[] a, int i, int j) {

        for (; i < j; i++, j--) {
            swap(a, i, j);
        }
    }

    public static void main(String[] args) {

        int[] a = { 2, 1, 4, 5, 3 };
        perm(a);
    }
}
