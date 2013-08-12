package com.venson.algorithm.sort;

import java.util.Arrays;

/**
 * Heap Sort
 */
public class HeapSort {

    private HeapSortSinker sinker = null;

    public HeapSort(HeapSortSinker sinker) {
        this.sinker = sinker;
    }

    /**
     * Heap sort array in ascending order.
     *
     * @param a The sort array.
     */
    public void sort(int[] a) {

        buildHeap(a);

        for (int i = a.length; i > 1; i--) {

            sinker.swap(a, 1, i);

            sink(a, 1, i - 1);
        }
    }

    /**
     * Build array to a heap.
     *
     * @param a The sort array.
     */
    public void buildHeap(int[] a) {

        int length = a.length;

        for (int i = length / 2; i > 0; i--) {

            sink(a, i, length);
        }
    }

    /**
     * Sink a node to bottom of the heap.
     *
     * @param a The sort array.
     * @param nodeIndex The root index of the subtree.
     * @param nodeNum the number of the tree.
     */
    public void sink(int[] a, int nodeIndex, int nodeNum) {

        if (sinker == null) {
            // TODO
            throw new NullPointerException();
        }

        sinker.sink(a, nodeIndex, nodeNum);
    }

    public static void main(String[] args) {

        HeapSort heapSort = new HeapSort(new NumericHeapSortSinker());

        int[] a = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };

        System.out.println(Arrays.toString(a));

        heapSort.sort(a);

        System.out.println(Arrays.toString(a));

    }
}

abstract class HeapSortSinker {

    /**
     * Sink a node to bottom of the heap.
     *
     * @param a The sort array.
     * @param nodeIndex The root index of the subtree.
     * @param nodeNum The number of the tree.
     */
    abstract public void sink(int[] a, int nodeIndex, int nodeNum);

    /**
     * Swap two items in array.
     *
     * @param a The swap array.
     * @param i The node index.
     * @param j The node index.
     */
    public void swap(int[] a, int i, int j) {

        int swap = a[i - 1];

        a[i - 1] = a[j - 1];

        a[j - 1] = swap;
    }
}

class RecursiveHeapSortSinker extends HeapSortSinker {

    /**
     * Sink a node to bottom with a recursive way.
     *
     * @param a The sort array.
     * @param nodeIndex The root index of the subtree.
     * @param nodeNum The number of the tree.
     */
    public void sink(int[] a, int nodeIndex, int nodeNum) {

        int leftChildIndex = nodeIndex * 2;

        int rightChildIndex = nodeIndex * 2 + 1;

        if (leftChildIndex > nodeNum) {
            return;
        }

        if (rightChildIndex > nodeNum) {

            if (a[nodeIndex - 1] < a[leftChildIndex - 1]) {
                swap(a, nodeIndex, leftChildIndex);
                sink(a, leftChildIndex, nodeNum);
            }

        } else {

            int max = a[nodeIndex - 1] < a[leftChildIndex - 1] ? leftChildIndex
                    : nodeIndex;

            max = a[max - 1] < a[rightChildIndex - 1] ? rightChildIndex : max;

            if (max == nodeIndex) {
                return;
            } else {
                swap(a, nodeIndex, max);
                sink(a, max, nodeNum);
            }
        }
    }
}

class NumericHeapSortSinker extends HeapSortSinker {

    /**
     * Sink a node to bottom with a numeric way.
     *
     * @param a The sort array.
     * @param nodeIndex The root index of the subtree.
     * @param nodeNum The number of the tree.
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

            swap(a, j, i);

            n = i * 2;

            j = i;
        }
    }
}
