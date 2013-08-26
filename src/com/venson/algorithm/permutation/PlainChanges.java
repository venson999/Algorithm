package com.venson.algorithm.permutation;

import static com.venson.algorithm.util.ArrayUtil.swap;
import static com.venson.algorithm.util.ArrayUtil.init;

import java.util.Arrays;

import com.venson.algorithm.sort.QuickSort;

/**
 * Permutate by plain changes
 */
public class PlainChanges {

    /**
     * Permutate array by plain changes.
     *
     * @param a The permutate array.
     */
    public static void perm(int[] a) {

        sort(a);

        int[] direction = new int[a.length];

        init(direction, -1);

        while (true) {

            System.out.println(Arrays.toString(a));
            System.out.println(Arrays.toString(direction));

            int maxMovable = findMaxMovable(a, direction);

            if (maxMovable < 0) {
                break;
            }

            int value = a[maxMovable];

            swap(a, maxMovable, maxMovable + direction[maxMovable]);
            swap(direction, maxMovable, maxMovable + direction[maxMovable]);

            reverseDirection(a, direction, value);
        }
    }

    /**
     * Sort array in ascending order.
     *
     * @param a The sort array.
     */
    public static void sort(int[] a) {

        QuickSort.sort(a);
    }

    /**
     * Find the max movable index.
     *
     * @param a The permutate array.
     * @param direction The direction array.
     * @return The max movable index.
     */
    private static int findMaxMovable(int[] a, int[] direction) {

        int maxIndex = -1;

        for (int i = 0; i < a.length; i++) {

            int directedIndex = i + direction[i];
            if (directedIndex >= 0 && directedIndex < a.length) {
                if (a[directedIndex] < a[i] && (maxIndex == -1 || a[maxIndex] < a[i])) {
                    maxIndex = i;
                }
            }
        }

        return maxIndex;
    }

    /**
     * Reverse direction which value is greater then the given max movable value.
     *
     * @param a The permutate array.
     * @param direction The direction array.
     * @param value The max movable value.
     */
    private static void reverseDirection(int[] a,
            int[] direction, int value) {

        for (int i = 0; i < a.length; i++) {
            if (a[i] > value) {
                direction[i] = -1 * direction[i];
            }
        }
    }

    public static void main(String[] args) {

        int[] a = { 2, 1, 4, 5 };
        perm(a);
    }
}
