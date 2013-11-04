package com.venson.algorithm.trappingrainwater;

/**
 * Trapping rain water by convex hull.
 */
public class ConvexHull {

    /**
     * Trapping rain water by convex hull.
     *
     * @param a The array represent the wall to trap rain water.
     * @return The trapped water volume.
     */
    public static int trap(int[] a) {

        int middle = 0;
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > a[middle]) {
                middle = i;
            }
            sum += a[i];
        }

        int left = 0;
        int point = 0;
        for (int i = 1; i <= middle; i++) {
            if (a[i] >= a[point]) {
                left += a[point] * (i - point);
                point = i;
            }
        }

        int right = 0;
        point = a.length - 1;
        for (int i = a.length - 2; i >= middle; i--) {
            if (a[i] >= a[point]) {
                right += a[point] * (point - i);
                point = i;
            }
        }

        return left + right + a[middle] - sum;
    }

    public static void main(String[] args) {

        int[] testcase_1 = { 2, 5, 1, 2, 3, 4, 7, 7, 6 };
        int[] testcase_2 = { 2, 5, 1, 3, 1, 2, 1, 7, 7, 6 };
        int[] testcase_3 = { 6, 1, 4, 6, 7, 5, 1, 6, 4 };

        System.out.println(trap(testcase_1));
        System.out.println(trap(testcase_2));
        System.out.println(trap(testcase_3));
    }
}
