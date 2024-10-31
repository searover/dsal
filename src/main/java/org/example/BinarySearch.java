package org.example;

import java.util.Arrays;

/**
 * @author luxz
 * @date 2024/10/26-18:40
 */
public class BinarySearch {
    public static void main(String[] args) {
//        int[] arr = {41, 31, 39, 2, 16, 49, 2, 32, 17, 10, 22, 7};
//        BinarySort.binarySort(arr, 0, arr.length, 0);
        int[] arr = {1, 1, 4, 5, 6, 7, 8, 8, 8, 8};
        System.out.println(Arrays.toString(arr));
        int value = 9;

        int firstEquals = bsearchFirstEqualsTo(arr, arr.length, value);
        System.out.println("First equals to: " + firstEquals);

        int lastEquals = bsearchLastEqualsTo(arr, arr.length, value);
        System.out.println("Last equals to : " + lastEquals);

        int firstGreaterAndEquals = bsearchFirstGreaterAndEqualsTo(arr, arr.length, value);
        System.out.println("First greater and equals to : " + firstGreaterAndEquals);

        int lastLittleAndEquals = bsearchLastLittleAndEquals(arr, arr.length, value);
        System.out.println("Last little and equals to : " + lastLittleAndEquals);
    }

    private static int bsearchFirstEqualsTo(int[] arr, int low, int high, int value) {
        if (high < low) {
            return -1;
        }
        int mid = low + ((high - low) >> 1);
        if (arr[mid] == value) {
            System.out.println("found: " + mid);
            while (mid > low) {
                if (arr[mid] != arr[mid - 1])
                    break;
                mid--;
            }
            return mid;
        }
        if (arr[mid] < value) {
            return bsearchFirstEqualsTo(arr, mid + 1, high, value);
        } else {
            return bsearchFirstEqualsTo(arr, low, mid - 1, value);
        }
    }

    private static int bsearchFirstEqualsTo(int[] arr, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] >= value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if (low < n && arr[low] == value)
            return low;
        else
            return -1;
    }

    private static int bsearchLastEqualsTo(int[] arr, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] <= value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (high > 0 && arr[high] == value)
            return high;
        else
            return -1;
    }

    private static int bsearchFirstGreaterAndEqualsTo(int[] arr, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] >= value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (low < n)
            return low;
        else
            return -1;
    }

    private static int bsearchLastLittleAndEquals(int[] arr, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] <= value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (high > 0)
            return high;
        else
            return -1;
    }
}
