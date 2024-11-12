package org.book.exercise.chapter02;

/**
 * @author luxz
 * @date 2024/11/12-18:02
 */
public class BinarySearch {

    private static final int NOT_FOUND = -1;

    // 运行时间 O(logN)
    public static <T extends Comparable<? super T>> int binarySearch(T[] a, T x) {
        int low = 0, high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid].compareTo(x) < 0) {
                low = mid + 1;
            }
            else if (a[mid].compareTo(x) > 0) {
                high = mid - 1;
            }
            else {
                return mid; // Found
            }
        }
        return NOT_FOUND;
    }
}
