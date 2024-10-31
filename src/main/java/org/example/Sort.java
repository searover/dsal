package org.example;

import java.util.Random;

/**
 * @author luxz
 * @date 2024/10/23-20:03
 */
public class Sort {
    public static void main(String[] args) {
        int n = 10000;
        int m = 200;
        int[][] a = new int[n][m];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = r.nextInt(1000);
            }
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
//            bubbleSort(m,a[i]);
//            insertionSort(m, a[i]);
            selectionSort(m, a[i]);
        }
        long stop = System.currentTimeMillis();
        long cost = stop - start;


//        selectionSort(m, a[0]);
//        for (int i = 0; i < a[0].length; i++) {
//            System.out.printf("%d ", a[0][i]);
//        }
        System.out.println("Total costs: " + cost);
    }

    private static void bubbleSort(int n, int[] a) {
        if (n <= 1)
            return;
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    flag = true;
                }
            }
            if (!flag)
                break;
        }
    }

    private static void insertionSort(int n, int[] a) {
        for (int i = 1; i < n; i++) {
            int value = a[i];
            int j = i - 1;
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = value;
        }
    }

    private static void selectionSort(int n, int[] a) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[i]) {
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
        }
    }

}
