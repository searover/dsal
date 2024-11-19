package org.book.exercise.chapter07;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author luxz
 * @date 2024/11/18-22:31
 */
public class RadixSort {

    /**
     * Radix sort an array of Strings.
     * Assume all are all ASCII.
     * Assume all are have length.
     * @param arr
     * @param stringLen
     */
    public static void radixSortA(String[] arr, int stringLen) {
        final int BUCKETS = 256;
        ArrayList<String>[] buckets = new ArrayList[BUCKETS];

        for (int i = 0; i < BUCKETS; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (int pos = stringLen - 1; pos >= 0; pos--) {
            for (String s : arr) {
                buckets[s.charAt(pos)].add(s);
            }
            int idx = 0;
            for (ArrayList<String> thisBucket : buckets) {
                for (String s : thisBucket)
                    arr[idx++] = s;
                thisBucket.clear();
            }
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        String[] arr = {"hello", "world", "hilly", "worry", "abbcd", "maine", "quick", "class"};
        radixSortA(arr, arr[0].length());
        System.out.println(Arrays.toString(arr));
    }
}
