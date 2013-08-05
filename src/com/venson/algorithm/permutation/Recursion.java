package com.venson.algorithm.permutation;

import static com.venson.algorithm.util.ArrayUtil.swap;

import java.util.Arrays;

/**
 * Permutate by recursion
 */
public class Recursion {

    public static void perm(int[] a, int k, int m) {

        if (k == m) {
            System.out.println(Arrays.toString(a));
        } else {

            for (int i = k; i <= m; i++) {
                swap(a, k, i);
                perm(a, k + 1, m);
                swap(a, k, i);
            }
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        int[] a = { 1, 2, 4, 5 };
        perm(a, 0, 3);
    }
}
