package org.example.astar;

import java.util.LinkedList;

/**
 * @author luxz
 * @date 2024/11/7-23:36
 */
public class Graph {
    private LinkedList<Edge> adj[]; // 邻接表
    private int v; // 顶点个数

    private Vertex[] vertices;

    public Graph(int v) {
        this.v = v;
        this.adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            this.adj[i] = new LinkedList<>();
        }
        this.vertices = new Vertex[v];
    }

    // 添加一条边
    public void addEdge(int s, int t, int w) {
        this.adj[s].add(new Edge(s, t, w));
    }

    // 添加顶点坐标
    public void addVertex(int id, int x, int y) {
        vertices[id] = new Vertex(id, x, y);
    }

    // 曼哈顿距离
    private int hManhattan(Vertex v1, Vertex v2) {
        return Math.abs(v1.x - v2.x) + Math.abs(v1.y - v2.y);
    }

    // A*启发式搜索算法
    public void astar(int s, int t) {
        int[] predecessor = new int[this.v];    // 用来还原路径
        // 按照vertex的f值构建小顶堆，而不是按照dist
        PriorityQueue queue = new PriorityQueue(this.v);
        boolean[] inqueue = new boolean[this.v]; // 标记是否进入过队列
        vertices[0].dist = 0;
        vertices[0].f = 0;
        queue.add(vertices[s]);
        inqueue[s] = true;
        while (!queue.isEmpty()) {
            Vertex minVertex = queue.poll();    // 取堆顶元素并删除
            for (int i = 0; i < adj[minVertex.id].size(); i++) {
                Edge e = adj[minVertex.id].get(i);
                Vertex nextVertex = vertices[e.tid];
                if (minVertex.dist + e.w < nextVertex.dist) {
                    // 更新next的dist,f
                    nextVertex.dist = minVertex.dist + e.w;
                    nextVertex.f = nextVertex.dist + hManhattan(nextVertex, vertices[t]);
                    predecessor[nextVertex.id] = minVertex.id;
                    ;
                    if (inqueue[nextVertex.id] == true) {
                        queue.update(nextVertex);
                    } else {
                        queue.add(nextVertex);
                        inqueue[nextVertex.id] = true;
                    }
                }
                if (nextVertex.id == t) { // 只要到达t就可以结束while循环了
                    queue.clear();
                    break;
                }
            }
        }
        // 输出路径
        System.out.print(s);
        print(s, t, predecessor);
    }

    private void print(int s, int t, int[] predecessor) {
        if (s == t) return;
        print(s, predecessor[t], predecessor);
        System.out.print("->" + t);
    }
}
