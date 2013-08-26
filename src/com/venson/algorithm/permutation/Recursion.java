package com.venson.algorithm.permutation;

import static com.venson.algorithm.util.ArrayUtil.swap;

import java.util.Arrays;

/**
 * Permute by recursion
 */
public class Recursion {

    /**
     * Permutate array by recursion.
     *
     * @param a The permute array.
     */
    public static void perm(int[] a) {
        perm(a, 0, a.length - 1);
    }

    /**
     * Internal permute that makes recursive calls.
     *
     * @param a The permute array.
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
