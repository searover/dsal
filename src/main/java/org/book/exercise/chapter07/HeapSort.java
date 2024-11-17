package org.book.exercise.chapter07;

import java.util.Arrays;

/**
 * @author luxz
 * @date 2024/11/17-16:42
 */
public class HeapSort {

    /**
     * Standard heapsort.
     *
     * @param a
     * @param <T>
     */
    public static <T extends Comparable<? super T>> void heapsort(T[] a) {
        // build heap
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            percDown(a, i, a.length);
        }

        // delete max
        for (int i = a.length - 1; i > 0; i--) {
            swapReference(a, 0, i);
            percDown(a, 0, i);
        }
    }

    private static <T> void swapReference(T[] a, int i, int j) {
        T tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    /**
     * Internal method for heapsort.
     *
     * @param i
     * @return
     */
    private static int leftChild(int i) {
        return 2 * i + 1;
    }

    /**
     * Internal method for heapsort that is used in deleteMax and buildHeap.
     *
     * @param a   an array of Comparable items.
     * @param i   the position from which to percolate down.
     * @param n   the logical size of the binary heap.
     * @param <T>
     */
    private static <T extends Comparable<? super T>> void percDown(T[] a, int i, int n) {
        int child;
        T tmp;
        for (tmp = a[i]; leftChild(i) < n; i = child) {
            child = leftChild(i);
            if (child != n - 1 && a[child].compareTo(a[child + 1]) < 0)
                child++;
            if (tmp.compareTo(a[child]) < 0)
                a[i] = a[child];
            else break;
        }
        a[i] = tmp;
    }

    public static void main(String[] args) {
        Integer[] a = {34, 8, 64, 51, 32, 21};
        System.out.println(Arrays.toString(a));
        heapsort(a);
        System.out.println(Arrays.toString(a));
    }
}