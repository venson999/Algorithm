package com.venson.algorithm.sort;

import java.util.Arrays;

public class HeapSort {

    private HeapSortSinker sinker = null;

    public HeapSort(HeapSortSinker sinker) {
        this.sinker = sinker;
    }

    /**
     * Heapsort an int array.
     *
     * @param a an int array that is wanted to sort.
     */
    public void sort(int[] a) {

        buildHeap(a);

        for (int i = a.length; i > 1; i--) {

            sinker.exchange(a, 1, i);

            sink(a, 1, i - 1);
        }
    }

    /**
     * build a heap.
     *
     * @param a an int array that is wanted to build to a heap.
     */
    public void buildHeap(int[] a) {

        int length = a.length;

        for (int i = length / 2; i > 0; i--) {

            sink(a, i, length);
        }
    }

    /**
     * sink a node to bottom
     *
     * @param a an int array
     * @param nodeIndex the root index of the subtree
     * @param nodeNum the number of the tree
     */
    public void sink(int[] a, int nodeIndex, int nodeNum) {

        if (sinker == null) {
            // TODO
            throw new NullPointerException();
        }

        sinker.sink(a, nodeIndex, nodeNum);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        HeapSort heapSort = new HeapSort(new NumericHeapSortSinker());

        int[] array2 = { 0, 1, 2, 8, 8, 7, 7, 6, 6, 9 };

        System.out.println(Arrays.toString(array2));

        heapSort.sort(array2);

        System.out.println(Arrays.toString(array2));

    }
}

abstract class HeapSortSinker {

    /**
     * sink a node to bottom
     *
     * @param a an int array
     * @param nodeIndex the root index of the subtree
     * @param nodeNum the number of the tree
     */
    abstract public void sink(int[] a, int nodeIndex, int nodeNum);

    /**
     * exchange two items in the int array
     *
     * @param a an int array
     * @param i node index
     * @param j node index
     */
    public void exchange(int[] a, int i, int j) {

        int swap = a[i - 1];

        a[i - 1] = a[j - 1];

        a[j - 1] = swap;
    }
}

class RecursiveHeapSortSinker extends HeapSortSinker {

    /**
     * sink a node to bottom with a recursive way
     *
     * @param a an int array
     * @param nodeIndex the root index of the subtree
     * @param nodeNum the number of the tree
     */
    public void sink(int[] a, int nodeIndex, int nodeNum) {

        int leftChildIndex = nodeIndex * 2;

        int rightChildIndex = nodeIndex * 2 + 1;

        if (leftChildIndex > nodeNum) {
            return;
        }

        if (rightChildIndex > nodeNum) {

            if (a[nodeIndex - 1] < a[leftChildIndex - 1]) {
                exchange(a, nodeIndex, leftChildIndex);
                sink(a, leftChildIndex, nodeNum);
            }

        } else {

            int max = a[nodeIndex - 1] < a[leftChildIndex - 1] ? leftChildIndex
                    : nodeIndex;

            max = a[max - 1] < a[rightChildIndex - 1] ? rightChildIndex : max;

            if (max == nodeIndex) {
                return;
            } else {
                exchange(a, nodeIndex, max);
                sink(a, max, nodeNum);
            }
        }
    }
}

class NumericHeapSortSinker extends HeapSortSinker {

    /**
     * sink a node to bottom with a numeric way
     *
     * @param a an int array
     * @param nodeIndex the root index of the subtree
     * @param nodeNum the number of the tree
     */
    public void sink(int[] a, int nodeIndex, int nodeNum) {

        int n = nodeIndex * 2;

        int i = nodeIndex;

        int j = nodeIndex;

        while (n <= nodeNum) {

            if (a[i - 1] < a[n - 1]) {
                i = n;
            }

            if (n + 1 <= nodeNum && a[i - 1] < a[n + 1 - 1]) {
                i = n + 1;
            }

            if (i == j) {
                return;
            }

            exchange(a, j, i);

            n = i * 2;

            j = i;
        }
    }
}
