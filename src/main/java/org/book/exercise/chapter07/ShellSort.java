package org.book.exercise.chapter07;

import java.util.Arrays;

/**
 * @author luxz
 * @date 2024/11/16-22:03
 */
public class ShellSort {

    public static <T extends Comparable<? super T>> void insertionSort(T[] a) {
        int j;
        for (int p = 1; p < a.length; p++) {
            T tmp = a[p];
            for (j = p; j > 0 && tmp.compareTo(a[j - 1]) < 0; j--)
                a[j] = a[j - 1];
            a[j] = tmp;
        }
    }

    /**
     * Shelsort, using Shell's (poor) increments.
     *
     * @param a
     * @param <T>
     */
    public static <T extends Comparable<? super T>> void shellsort(T[] a) {
        int j;
        for (int gap = a.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < a.length; i++) {
                T tmp = a[i];
                for (j = i; j >= gap && tmp.compareTo(a[j - gap]) < 0; j -= gap)
                    a[j] = a[j - gap];
                a[j] = tmp;
                System.out.println(gap + ": " + Arrays.toString(a));
            }
        }
    }

    public static void main(String[] args) {
        Integer[] a = {34, 8, 64, 51, 32, 21};
//        Integer[] a = {81, 94, 11, 96, 12, 35, 17, 95, 28, 58, 41, 75, 15};
        System.out.println(Arrays.toString(a));
        shellsort(a);
        System.out.println(Arrays.toString(a));
    }
}
