package org.example.astar;


/**
 * @author luxz
 * @date 2024/11/7-23:45
 */
public class PriorityQueue {
    private Vertex[] nodes;
    private int count;

    public PriorityQueue(int v) {
        this.nodes = new Vertex[v + 1];
        this.count = v;
    }

    public Vertex poll() {
        throw new UnsupportedOperationException();
    }

    public void add(Vertex vertex) {

    }

    // 更新节点的值，并且从下往上堆化，重新符合堆的定义
    // 时间复杂度O(logn)
    public void update(Vertex vertex) {

    }

    public boolean isEmpty() {
        throw new UnsupportedOperationException();
    }

    public void clear() {
    }
}
