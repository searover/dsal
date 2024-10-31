package org.example;

import java.util.Arrays;

/**
 * @author luxz
 * @date 2024/10/25-18:07
 */
public class QuickSort {
    public static void main(String[] args) {
//        int[] arr = {1, 3, 3, 5, 9, 2, 7, 6, 9, 0, 3, 2, 5, 2, 6, 7, 2, 9, 8, 1, 8, 0, 6, 6, 5, 1, 5, 8, 7, 2};
        int[] arr = {1, 3, 5, 6, 8};
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
//        System.out.println("pivo t: " + pivot + ", p: " + p + ", r: " + r);
        int i = p, j = p;
        for (; j < r; j++) {
            if (arr[j] < pivot) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                ++i;
            }
        }
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
//        System.out.println(Arrays.toString(arr));
        return i;
    }
}
