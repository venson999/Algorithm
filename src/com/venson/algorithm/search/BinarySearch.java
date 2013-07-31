package com.venson.algorithm.search;

/**
 * Binary Search
 */
public class BinarySearch {

    public static boolean search(int[] a, int b) {

        int left = 0;
        int right = a.length - 1;
        int middle = 0;

        if (a[left] > b && b > a[right]) {
            return false;
        }

        while (left <= right) {

            middle = (left + right) / 2;

            if (b == a[middle]) {

                return true;

            } else if (b < a[middle]) {

                right = middle - 1;

            } else if (b > a[middle]) {

                left = middle + 1;
            }
        }

        return false;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        int[] a = { 1, 3, 5, 7, 8, 9, 10 };
        int b = 10;

        System.out.println(search(a, b));
    }
}
