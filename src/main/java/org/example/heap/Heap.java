package org.example.heap;

import java.util.Arrays;

/**
 * @author luxz
 * @date 2024/10/29-17:47
 */
public class Heap {
    private int[] a;    // 数组，从下标1开始存储数据
    private int n;      // 堆可以存储的最大数据个数
    private int count;  // 堆中已经存储的数据个数

    public Heap(int n) {
        a = new int[n + 1];
        this.n = n;
        count = 0;
    }

    public static void main(String[] args) {
        int[] list = {33, 27, 21, 16, 13, 9, 15, 5, 6, 7, 8, 1, 2, 22};
        Heap h = new Heap(list.length);
        System.out.println(Arrays.toString(list));
        for (int i : list) {
            h.insert(i);
        }
        System.out.println(h);
        System.out.println(Arrays.toString(h.a));
        h.delete(h.a[1]);
        System.out.println(h);
        System.out.println();
        h.sort(h.a, h.count);
        System.out.println(h);

    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        for (int i = 1; i <= count; i++) {
            builder.append(a[i]);
            if (i < count)
                builder.append(", ");
        }
        builder.append("]");
        return builder.toString();
    }

    public void insert(int data) {
        if (count >= n)
            return;
        ++count;
        a[count] = data;
        int i = count;

        while (i / 2 > 0 && a[i] > a[i / 2]) {
            // 自下往上堆化
            swap(a, i, i / 2);
            i = i / 2;
        }
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public void delete(int data) {
        int pos = 0;
        for (int i = 1; i < count; i++) {
            if (a[i] == data) {
                pos = i;
            }
        }
        if (pos == 0) {
            System.out.println(data + " not found.");
            return;
        }
        System.out.println("Delete item a[" + pos + "] = " + a[pos]);
//        System.out.println("Swap a[" + pos + "]=" + a[pos] + " & a[" + count + "]=" + a[count]);
        swap(a, pos, count);
//        System.out.println("Swaped: " + this);
//        while (index * 2 < n && a[index] < a[index * 2]) {
//            swap(a, index, index * 2);
//            index *= 2;
//        }
        count--;
        while (true) {
            int maxPos = pos;
            if (pos * 2 <= count && a[pos] < a[pos * 2]) {
                pos = pos * 2;
            }
            if (maxPos * 2 + 1 <= count && a[pos] < a[maxPos * 2 + 1]) {
                pos = maxPos * 2 + 1;
            }
            if (pos == maxPos)
                break;
            swap(a, pos, maxPos);
        }
    }

    private void sort(int[] a, int n) {
        // 将数组原地堆化
        for (int i = n / 2; i > 0; --i) {
            heapify(a, n, i);
        }
        // 排序
        for (int i = n; i > 1; --i) {
            swap(a, i, 1);
            heapify(a, i - 1, 1);
        }
    }

    private void heapify(int[] a, int n, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 <= n && a[i] < a[i * 2])
                maxPos = i * 2;
            if (i * 2 + 1 <= n && a[maxPos] < a[i * 2 + 1])
                maxPos = i * 2 + 1;
            if (maxPos == i)
                break;
            swap(a, i, maxPos);
            i = maxPos;
        }
    }
}
