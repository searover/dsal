package org.book.exercise.chapter07;

/**
 * @author luxz
 * @date 2024/11/18-18:38
 */
public class QuickSelect {

    private static final int CUTOFF = 10;

    private static <T extends Comparable<? super T>> void quickSelect(T[] a, int left, int right, int k) {
        if (left + CUTOFF <= right) {
            T pivot = median3(a, left, right);
            int i = left, j = right - 1;
            for (; ; ) {
                while (a[++i].compareTo(pivot) < 0) {
                }
                while (a[++j].compareTo(pivot) > 0) {
                }
                if (i < j)
                    swapReference(a, i, j);
                else break;
            }
            swapReference(a, i, right - 1);
            if (k <= i)
                quickSelect(a, left, i - 1, k);
            else if (k > i + 1)
                quickSelect(a, i + 1, right, k);
        } else {
            // do insertion sort.
        }
    }

    private static <T extends Comparable<? super T>> T median3(T[] a, int left, int right) {
        throw new UnsupportedOperationException();
    }

    private static <T extends Comparable<? super T>> void swapReference(T[] a, int i, int j) {
    }
}
