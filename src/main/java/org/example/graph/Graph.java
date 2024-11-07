package org.example.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author luxz
 * @date 2024/10/31-09:12
 */
public class Graph {    // 无向图
    private int v; // 顶点的个数

    private LinkedList<Integer> adj[]; // 邻接表

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public Graph addEdge(int s, int t) {
        // 无向图一条边存两次
        adj[s].add(t);
        adj[t].add(s);
        return this;
    }

    public void bfs(int s, int t) {
        boolean[] visited = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();
        int[] prev = new int[v];
        for (int i = 0; i < prev.length; i++) {
            prev[i] = -1;
        }
        int w = s;
        queue.add(s);
        while (!queue.isEmpty()) {
            w = queue.poll();
            for (int i = 0; i < adj[w].size(); i++) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    visited[q] = true;
                    queue.add(q);
                    if (q == t) {
                        print(prev, s, q);
                        return;
                    }
                }
            }
        }
    }

    public void dfs(int s, int t) {
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        Arrays.fill(prev, -1);
        visited[s] = true;
        dfs_internal(prev, visited, s, t);
        if (found) {
            print(prev, s, t);
        }
    }

    private boolean found;

    private void dfs_internal(int[] prev, boolean[] visited, int w, int t) {
        if (found)
            return;
        for (int i = 0; i < adj[w].size(); i++) {
            int q = adj[w].get(i);
            if (!visited[q]) {
                prev[q] = w;
                visited[q] = true;
                if (q == t) {
                    System.out.println("found.");
                    found = true;
                    return;
                }
                dfs_internal(prev, visited, q, t);
            }
        }
    }

    private void print(int[] prev, int s, int t) {
        // 递归打印s->t的路径
        if (t != s && prev[t] != -1) {
            print(prev, s, prev[t]);
        }
        System.out.printf("%d ", t);
    }

    public static void main(String[] args) {
        Graph g = new Graph(8)
                .addEdge(0, 1).addEdge(0, 3)
                .addEdge(1, 0).addEdge(1, 2).addEdge(1, 4)
                .addEdge(2, 1).addEdge(2, 5)
                .addEdge(3, 0).addEdge(3, 4)
                .addEdge(4, 1).addEdge(4, 3).addEdge(4, 5).addEdge(4, 6)
                .addEdge(5, 2).addEdge(5, 4).addEdge(5, 7)
                .addEdge(6, 4).addEdge(6, 7)
                .addEdge(7, 5).addEdge(7, 6);
        g.bfs(0, 7);
        System.out.println();
        g.bfs(7, 0);
        System.out.println();
        System.out.println();
        System.out.println();

        Graph dg = new Graph(9)
                .addEdge(1, 2).addEdge(1, 4)
                .addEdge(2, 5).addEdge(2, 3).addEdge(2, 1)
                .addEdge(3, 6).addEdge(3, 2)
                .addEdge(4, 1).addEdge(4, 5)
                .addEdge(5, 4).addEdge(5, 2).addEdge(5, 6).addEdge(5, 7)
                .addEdge(6, 3).addEdge(6, 8).addEdge(6, 5)
                .addEdge(7, 5).addEdge(7, 8)
                .addEdge(8, 6).addEdge(8, 7);
        dg.dfs(1, 7);
    }
}
