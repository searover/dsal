package org.example.toposort;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author luxz
 * @date 2024/11/6-13:42
 */
public class Graph {
    private int v;  // 顶点个数
    private LinkedList<Integer>[] adj; // 邻接表

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public Graph addEdge(int s, int t) {
        // s先于t，边s->t
        adj[s].add(t);
        return this;
    }

    public void topoSortByKahn() {
        // 统计每个顶点的入度
        int[] inDegrees = new int[v];
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                int w = adj[i].get(j);
                inDegrees[w]++;
            }
        }

        LinkedList<Integer> queue = new LinkedList<>();
        // 扫描顶点，将入度为0的顶点"删除"
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }
        System.out.println(Arrays.toString(inDegrees));

        // 将该顶点可达的所有顶点的入度减一
        while (!queue.isEmpty()) {
            int i = queue.remove();
            System.out.print("->" + i);
            for (int j = 0; j < adj[i].size(); j++) {
                int w = adj[i].get(j);
                inDegrees[w]--;
                if (inDegrees[w] == 0) {
                    queue.add(w);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(8)
                .addEdge(0, 1).addEdge(0, 3)
                .addEdge(1, 2).addEdge(1, 4)
                .addEdge(2, 5)
                .addEdge(3, 4)
                .addEdge(4, 3).addEdge(4, 5).addEdge(4, 6)
                .addEdge(5, 2).addEdge(5, 4).addEdge(5, 7)
                .addEdge(6, 4).addEdge(6, 7)
                .addEdge(7, 5).addEdge(7, 6);
        g.topoSortByKahn();
    }
}