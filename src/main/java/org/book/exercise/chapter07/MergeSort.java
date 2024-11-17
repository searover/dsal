package org.book.exercise.chapter07;

import java.util.Arrays;

/**
 * @author luxz
 * @date 2024/11/17-17:55
 */
public class MergeSort {

    public static void mergeSort(int[] a, int[] tmpArray, int left, int right) {
        if (left >= right)
            return;
        int center = (left + right) / 2;
        mergeSort(a, tmpArray, left, center);
        mergeSort(a, tmpArray, center + 1, right);

        merge(a, tmpArray, left, center + 1, right);
    }

    private static void merge(int[] a, int[] tmpArray, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (a[leftPos] < a[rightPos])
                tmpArray[tmpPos++] = a[leftPos++];
            else
                tmpArray[tmpPos++] = a[rightPos++];
        }
        while (leftPos <= leftEnd)
            tmpArray[tmpPos++] = a[leftPos++];
        while (rightPos <= rightEnd) {
            tmpArray[tmpPos++] = a[rightPos++];
        }

        for (int i = 0; i < numElements; i++, rightEnd--) {
            a[rightEnd] = tmpArray[rightEnd];
        }
    }

    public static void main(String[] args) {
        int[] a = {81, 94, 11, 96, 12, 35, 17, 95, 28, 58, 41, 75, 15};
        int[] tmpArray = new int[a.length];
        mergeSort(a, tmpArray, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
