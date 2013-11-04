package com.venson.algorithm.trappingrainwater;

/**
 * Trapping rain water by opposite traverse.
 */
public class OppositeTraverse {

    /**
     * Trapping rain water by opposite traverse.
     *
     * @param a The array represent the wall to trap rain water.
     * @return The trapped water volume.
     */
    public static int trap(int[] a) {

        int leftMax = 0, rightMax = a.length - 1;
        int leftPoint = leftMax + 1, rightPoint = rightMax, volume = 0;

        while (leftPoint < rightPoint) {

            if (a[leftPoint] <= a[rightPoint]) {

                if (a[leftMax] < a[leftPoint]) {
                    leftMax = leftPoint;
                } else {
                    volume += a[leftMax] - a[leftPoint];
                }
                leftPoint++;

            } else {

                if (a[rightMax] <= a[rightPoint]) {
                    rightMax = rightPoint;
                } else {
                    volume += a[rightMax] - a[rightPoint];
                }
                rightPoint--;
            }
        }

        return volume;
    }

    public static void main(String[] args) {

        int[] testcase1 = { 2, 5, 1, 2, 3, 4, 7, 7, 6 };
        int[] testcase2 = { 2, 5, 1, 3, 1, 2, 1, 7, 7, 6 };
        int[] testcase3 = { 6, 1, 4, 6, 7, 5, 1, 6, 4 };

        System.out.println(trap(testcase1));
        System.out.println(trap(testcase2));
        System.out.println(trap(testcase3));
    }
}
