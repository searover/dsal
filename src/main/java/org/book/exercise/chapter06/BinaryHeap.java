package org.book.exercise.chapter06;

/**
 * @author luxz
 * @date 2024/11/16-08:05
 */
public class BinaryHeap<T extends Comparable<? super T>> {
    public BinaryHeap() {
    }

    public BinaryHeap(int capacity) {

    }

    public BinaryHeap(T[] items) {
        currentSize = items.length;
        array = (T[]) new Comparable[(currentSize + 2) * 11 / 10];

        int i = 1;
        for (T item : items)
            array[i++] = item;
        buildHeap();
    }

    /**
     * Insert into priority queue, maintaining heap order.
     * Duplicates are allowed.
     *
     * @param x
     */
    public void insert(T x) {
        if (currentSize == array.length - 1) {
            enlargeArray(array.length * 2 + 1);
        }
        // Percolate up
        int hole = ++currentSize;
        // array[0] = x，把对被插入对象的引用放到数组0的位置，以便当hole=1时跳出循环
        for (array[0] = x; x.compareTo(array[hole / 2]) < 0; hole /= 2) {
            array[hole] = array[hole / 2];
        }
        array[hole] = x;
    }

    public T findMin() {
        throw new UnsupportedOperationException();
    }

    public T deleteMin() {
        if (isEmpty())
            throw new RuntimeException();
        T minItem = findMin();
        array[1] = array[currentSize--];
        percolateDown(1);
        return minItem;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public void makeEmpty() {
        throw new UnsupportedOperationException();
    }

    private static final int DEFAULT_CAPATICY = 10;

    private int currentSize;
    private T[] array;

    private void percolateDown(int hole) {
        T tmp = array[hole];
        int child = hole * 2;
        for (; hole <= currentSize; hole = child) {
            if (child != currentSize && array[child + 1].compareTo(array[child]) < 0) {
                child++;
            }
            if (array[child].compareTo(tmp) < 0)
                array[hole] = array[child];
            else
                break;
        }
        array[hole] = tmp;
    }

    private void buildHeap() {
        for (int i = currentSize / 2; i > 0; i--) {
            percolateDown(i);
        }
    }

    private void enlargeArray(int newSize) {

    }
}
