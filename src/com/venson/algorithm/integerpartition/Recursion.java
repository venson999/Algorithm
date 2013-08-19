package com.venson.algorithm.integerpartition;

/**
 * Integer partition by recursion.
 */
public class Recursion {

    /**
     * Integer partition by recursion.
     *
     * @param sum The partition number.
     * @param largestNumber The largest Number.
     * @return The partition count.
     */
    public static int partition(int sum, int largestNumber) {

        if (sum == 1 || largestNumber == 1) {
            return 1;
        }

        if (sum < largestNumber) {
            return partition(sum, sum);
        }

        if (sum == largestNumber) {
            return 1 + partition(sum, largestNumber - 1);
        }

        return partition(sum, largestNumber - 1) + partition(sum - largestNumber, largestNumber);
    }

    public static void main(String[] args) {

        System.out.println(partition(6, 6));
    }
}
