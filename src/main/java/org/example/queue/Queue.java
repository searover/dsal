package org.example.queue;

/**
 * @author luxz
 * @date 2024/11/8-22:16
 */
public class Queue {
    private Long[] data;
    private int size = 0, head = 0, tail = 0;

    public Queue(int size) {
        this.data = new Long[size];
        this.size = size;
    }

    public boolean add(Long element) {
        // 判断队列是否已满
        if ((tail + 1) % size == head) {
            return false;
        }
        data[tail] = element;
        // tail 后移
        tail = (tail + 1) % size;
        return true;
    }

    public Long poll() {
        // 判断队列是否已空
        if (tail == head) {
            return null;
        }
        // 取head指向的数据，head后移
        Long ret = data[head];
        head = (head + 1) % size;
        return ret;
    }
}
