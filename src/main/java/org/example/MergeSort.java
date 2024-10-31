package org.example;

import java.util.Arrays;

/**
 * @author luxz
 * @date 2024/10/25-15:08
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {41, 31, 39, 2, 16, 49, 2, 32, 17, 10, 22, 7};
        int n = 12;

        int[] arr1 = {2, 12, 34, 45, 67, 70};
        int[] arr2 = {3, 5, 9, 22, 40, 78};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr, 0, n - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void mergeSort(int[] arr, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = (p + r) / 2;
        // 分治递归
        mergeSort(arr, p, q);
        mergeSort(arr, q + 1, r);
        // 合并数组
        int[] tmp = new int[r - p + 1];
        merge(tmp, Arrays.copyOfRange(arr, p, q + 1), Arrays.copyOfRange(arr, q + 1, r + 1));
        for (int i = 0, j = p; i < tmp.length; i++, j++) {
            arr[j] = tmp[i];
        }
    }

    static void merge(int arr[], int arr1[], int arr2[]) {
        int j = 0, k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (j < arr1.length && k < arr2.length) {
                if (arr1[j] <= arr2[k]) {
                    arr[i] = arr1[j];
                    ++j;
                } else {
                    arr[i] = arr2[k];
                    ++k;
                }
            } else if (j < arr1.length) {
                arr[i] = arr1[j];
                ++j;
            } else if (k < arr2.length) {
                arr[i] = arr2[k];
                ++k;
            } else {
                break;
            }
        }
    }
}
