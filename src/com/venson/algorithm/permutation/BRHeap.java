package com.venson.algorithm.permutation;

import static com.venson.algorithm.util.ArrayUtil.swap;

import java.util.Arrays;

/**
 * Permute by B. R. Heap's algorithm.
 */
public class BRHeap {

    /**
     * Permute array by B. R. Heap's algorithm.
     *
     * @param a The permute array.
     */
    public static void perm(int[] a) {
        perm(a, a.length);
    }

    /**
     * Internal permute that makes recursive calls.
     *
     * @param a The permute array.
     */
    public static void perm(int[] a, int n) {

        if (n == 1) {
            System.out.println(Arrays.toString(a));
        } else {
            for (int i = 0; i < n; i++) {
                perm(a, n - 1);
                swap(a, n % 2 == 1 ? 0 : i, n - 1);
            }
        }
    }

    public static void main(String[] args) {

        int[] a = { 1, 2, 3 };
        perm(a);
    }
}
