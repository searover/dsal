package org.example.dijkstra;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.LinkedList;

/**
 * @author luxz
 * @date 2024/11/7-19:11
 */
public class Graph { // 有向有权图的邻接表表示

    private LinkedList<Edge> adj[]; // 邻接表
    private int v; // 顶点个数

    public Graph(int v) {
        this.v = v;
        this.adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            this.adj[i] = new LinkedList<>();
        }
    }

    // 添加一条边
    public void addEdge(int s, int t, int w) {
        this.adj[s].add(new Edge(s, t, w));
    }

    private class Edge {
        public int sid; // 边的起始顶点编号
        public int tid; // 边的终止顶点编号
        public int w;   // 权重

        public Edge(int sid, int tid, int w) {
            this.sid = sid;
            this.tid = tid;
            this.w = w;
        }
    }

    // 为了 dijkstra实现用的
    private class Vertex {
        public int id;  // 顶点编号ID
        public int dist; //  从起始顶点到这个顶点的距离

        public Vertex(int id, int dist) {
            this.id = id;
            this.dist = dist;
        }
    }

    // 因为Java提供的优先级队列，没有显露更新数据的接口，所以我们需要重新实现一个
    // 根据 vertex.dist构建小顶堆
    private class PriorityQueue {
        private Vertex[] nodes;
        private int count;

        public PriorityQueue(int v) {
            this.nodes = new Vertex[v + 1];
            this.count = v;
        }

        public Vertex poll() {
            throw new NotImplementedException();
        }

        public void add(Vertex vertex) {

        }

        // 更新节点的值，并且从下往上堆化，重新符合堆的定义
        // 时间复杂度O(logn)
        public void update(Vertex vertex) {

        }

        public boolean isEmpty() {
            throw new NotImplementedException();
        }
    }

    // 计算从顶点s到顶点t的最短路径
    public void dijkstra(int s, int t) {
        int[] predecessor = new int[this.v];    // 用来还原最短路径
        Vertex[] vertexes = new Vertex[this.v];
        for (int i = 0; i < this.v; i++) {
            vertexes[i] = new Vertex(i, Integer.MAX_VALUE);
        }
        PriorityQueue queue = new PriorityQueue(this.v); // 小顶堆
        boolean[] inqueue = new boolean[this.v]; // 标记是否进入过队列
        vertexes[s].dist = 0;
        queue.add(vertexes[s]);
        inqueue[s] = true;
        while (!queue.isEmpty()) {
            Vertex minVertex = queue.poll();
            if (minVertex.id == t) {
                // 最短路径产生了
                break;
            }
            for (int i = 0; i < adj[minVertex.id].size(); i++) {
                Edge e = adj[minVertex.id].get(i);  // 取出一条minVertex相连的边
                Vertex nextVertex = vertexes[e.tid];    // minVertex --> nextVertex
                if (minVertex.dist + e.w < nextVertex.dist) {
                    // 更新next的dist
                    nextVertex.dist = minVertex.dist + e.w;
                    predecessor[nextVertex.id] = minVertex.id;
                    if (inqueue[nextVertex.id] == true) {
                        queue.update(nextVertex);
                    } else {
                        queue.add(nextVertex);
                        inqueue[nextVertex.id] = true;
                    }
                }
            }
            // 输出最短路径
            System.out.print(s);
            print(s, t, predecessor);
        }
    }

    private void print(int s, int t, int[] predecessor) {
        if (s == t) return;
        print(s, predecessor[t], predecessor);
        System.out.print("->" + t);
    }
}
