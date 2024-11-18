package org.book.exercise.chapter07;

import java.util.Arrays;

/**
 * @author luxz
 * @date 2024/11/18-13:35
 */
public class QuickSort {
    public static void main(String[] args) {
        Integer[] a = {81, 94, 11, 96, 12, 35, 17, 95, 28, 58, 41, 75, 15};
        quicksort(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * Quicksort algorithm.
     *
     * @param a
     * @param <T>
     */
    public static <T extends Comparable<? super T>> void quicksort(T[] a) {
        quicksort(a, 0, a.length - 1);
    }

    private static int CUTOFF = 10;

    private static <T extends Comparable<? super T>> void quicksort(T[] a, int left, int right) {
        if (left + CUTOFF <= right) {
//        if (left >= right)
//            return;
            T pivot = median3(a, left, right);
            System.out.println("Pivot: " + pivot);

            // Begin partitioning
            int i = left, j = right - 1;
            for (; ; ) {
                while (a[++i].compareTo(pivot) < 0) {
                }
                while (a[--j].compareTo(pivot) > 0) {
                }
                if (i < j)
                    swapReferences(a, i, j);
                else break;
            }
            swapReferences(a, i, right - 1);
            quicksort(a, left, i - 1);  // Sort small elements.
            quicksort(a, i + 1, right);// Sort large elements.
        } else
            insertionSort(a, left, right);
    }

    private static <T extends Comparable<? super T>> void insertionSort(T[] a, int left, int right) {
        int j;
        for (int i = left + 1; i <= right; i++) {
            T tmp = a[i];
            for (j = i; j > left && tmp.compareTo(a[j - 1]) < 0; j--)
                a[j] = a[j - 1];
            a[j] = tmp;
        }
    }

    /**
     * Return median of left, center, and right.
     * Order these and hide the pivot.
     *
     * @param a
     * @param left
     * @param right
     * @param <T>
     * @return
     */
    private static <T extends Comparable<? super T>> T median3(T[] a, int left, int right) {
        int center = (left + right) / 2;
        if (a[center].compareTo(a[left]) < 0)
            swapReferences(a, left, center);
        if (a[right].compareTo(a[left]) < 0)
            swapReferences(a, left, right);
        if (a[right].compareTo(a[center]) < 0)
            swapReferences(a, center, right);

        // Place pivot at position right-1
//        System.out.println(center + ", " + (right - 1));
        swapReferences(a, center, right - 1);
        return a[right - 1];
    }

    private static <T extends Comparable<? super T>> void swapReferences(T[] a, int center, int i) {
        T tmp = a[center];
        a[center] = a[i];
        a[i] = tmp;
    }
}
