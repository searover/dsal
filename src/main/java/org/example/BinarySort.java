package org.example;

import java.util.Arrays;

/**
 * @author luxz
 * @date 2024/10/26-11:07
 */
public class BinarySort {
    public static void main(String[] args) {
        int[] arr = {41, 31, 39, 2, 16, 49, 2, 32, 17, 10, 22, 7};
        System.out.println(Arrays.toString(arr));
        binarySort(arr, 0, arr.length, 0);
        System.out.println(Arrays.toString(arr));
        int i = 1;
        switch (i){
            case 1:
                System.out.println("111");
            case 0:
                System.out.println("000");
                break;
            default:
                System.out.println("default");
        }
    }

    public static void binarySort(int[] arr, int lo, int hi, int start) {
        if (start == lo) {
            start++;
        }

        for (; start < hi; start++) {
            int pivot = arr[start];

            int left = lo;
            int right = start;

            while (left < right) {
                int mid = (left + right) >>> 1;
                if (pivot < arr[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            int n = start - left;
            switch (n) {
                case 2:
                    arr[left + 2] = arr[left + 1];
                case 1:
                    arr[left + 1] = arr[left];
                    break;
                default:
                    System.arraycopy(arr, left, arr, left + 1, n);
            }
            arr[left] = pivot;
        }
    }
}
