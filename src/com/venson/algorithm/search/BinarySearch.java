package com.venson.algorithm.search;

/**
 * Binary Search
 */
public class BinarySearch {

    /**
     * Binary search target in array.
     *
     * @param a The search array.
     * @param b The search target.
     * @return The result index.
     */
    public static int search(int[] a, int b) {

        int left = 0;
        int right = a.length - 1;
        int middle = 0;

        if (b < a[left] || b > a[right]) {
            return -1;
        }

        while (left <= right) {

            // The same meaning with "middle = (left + right) / 2;",
            // but more effective and will not overflow.
            middle = left + ((right - left) >> 1);

            if (b < a[middle]) {

                right = middle - 1;

            } else if (b > a[middle]) {

                left = middle + 1;

            } else {

                return middle;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] a = { 1, 3, 5, 7, 8, 9, 10 };
        int b = 10;

        System.out.println(search(a, b));
    }
}
