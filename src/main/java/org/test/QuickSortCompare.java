package org.test;

import org.example.QuickSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author luxz
 * @date 2024/11/18-17:51
 */
public class QuickSortCompare {
    public static void main(String[] args) {
        int size = 10000000;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        int[] a = new int[size];
        for (int i = 0; i < a.length; i++) {
            a[i] = list.get(i);
        }
//        System.out.println(Arrays.toString(a));

        Integer[] arr = new Integer[size];
        list.toArray(arr);

        long startTime = System.nanoTime();
        QuickSort.quickSort(arr);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;
//        System.out.println(Arrays.toString(a));
        System.out.println("QuickSort 1 duration: " + duration + " ms.");

        startTime = System.nanoTime();
        org.book.exercise.chapter07.QuickSort.quicksort(arr);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000000;
        System.out.println("QuickSort 2 duration: " + duration + " ms.");
    }
}
