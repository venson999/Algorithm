package com.venson.algorithm.sort;

import java.util.Arrays;

public class BubbleSort {

    public int[] sort(int[] original) {

        int[] sort = original.clone();

        int length = original.length;

        for (int i = 0; i < length - 1; i++) {

            for (int j = length - 1; j > i; j--) {

                if (sort[j] < sort[j - 1]) {

                    int temp = sort[j - 1];

                    sort[j - 1] = sort[j];

                    sort[j] = temp;
                }
            }
        }

        return sort;
    }

    public static void main(String[] args) {

        BubbleSort bubbleSort = new BubbleSort();

        int[] array = { 3, 4, 1, 2, 5, 7, 8, 0, 9 };

        // int[] array1 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        System.out.println(Arrays.toString(bubbleSort.sort(array)));
    }
}
