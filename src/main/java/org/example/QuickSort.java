package org.example;

import java.util.Arrays;

/**
 * @author luxz
 * @date 2024/10/25-18:07
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {81, 94, 11, 96, 12, 35, 17, 95, 28, 58, 41, 75, 15, 7};
        int n = arr.length;
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, n - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void quickSort(int[] arr, int p, int r) {
        if (p >= r)
            return;
        int q = partition(arr, p, r);
        quickSort(arr, p, q - 1);
        quickSort(arr, q + 1, r);
    }

    private static int partition(int[] arr, int p, int r) {
        int pivot = arr[r];
        int i = p, j = p;
        for (; j < r; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                ++i;
            }
        }
        swap(arr, i, j);
        return i;
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
