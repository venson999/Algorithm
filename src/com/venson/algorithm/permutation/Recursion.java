package com.venson.algorithm.permutation;

import static com.venson.algorithm.util.ArrayUtil.swap;

import java.util.Arrays;

/**
 * Permutate by recursion
 */
public class Recursion {

    /**
     * Permutate array by recursion.
     *
     * @param a The permutate array.
     */
    public static void perm(int[] a) {
        perm(a, 0, a.length - 1);
    }

    /**
     * Internal permutate that makes recursive calls.
     *
     * @param a The permutate array.
     * @param left The left-most index of subarray.
     * @param right The right-most index of subarray.
     */
    private static void perm(int[] a, int left, int right) {

        if (left == right) {
            System.out.println(Arrays.toString(a));
        } else {

            for (int i = left; i <= right; i++) {
                swap(a, left, i);
                perm(a, left + 1, right);
                swap(a, left, i);
            }
        }
    }

    public static void main(String[] args) {

        int[] a = { 1, 2, 4, 5 };
        perm(a);
    }
}
