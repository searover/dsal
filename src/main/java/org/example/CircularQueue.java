package org.example;

/**
 * @author luxz
 * @date 2024/10/22-20:36
 */
public class CircularQueue {
    private String[] items;
    private int n;
    // head 表示头下标，tail 表示尾下标
    private int head = 0;
    private int tail = 0;

    // 申请一个大小为 capacity 的数组
    public CircularQueue(int capacity) {
        items = new String[capacity];
        this.n = capacity;
    }

    // 入队
    public boolean enqueue(String item) {
        // 判断队列是否满
        if ((tail + 1) % n == head) {
            return false;
        }
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    // 出队
    public String dequeue() {
        // 判断队列是否空
        if (tail == head) {
            return null;
        }
        String ret = items[head];
        head = (head + 1) % n;
        return ret;
    }
}
