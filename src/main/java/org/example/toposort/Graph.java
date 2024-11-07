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

    public void topoSortByDFS() {
        // 构造逆邻接表
        LinkedList<Integer>[] inversedAdj = new LinkedList[v];
        for (int i = 0; i < inversedAdj.length; i++) {
            inversedAdj[i] = new LinkedList<>();
        }
        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                int w = adj[i].get(j);
                inversedAdj[w].add(i);
            }
        }
        boolean[] visited = new boolean[v];
        for (int i = 0; i < inversedAdj.length; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                dfs(i, inversedAdj, visited);
            }
        }
    }

    private void dfs(int vertex, LinkedList<Integer>[] inversedAdj, boolean[] visited) {
        for (int i = 0; i < inversedAdj[vertex].size(); i++) {
            int w = inversedAdj[vertex].get(i);
            if (visited[w] == false) {
                visited[w] = true;
                dfs(w, inversedAdj, visited);
            }
        }
        System.out.print("->" + vertex);
    }

    public static void main(String[] args) {
        Graph g = new Graph(8)
                .addEdge(0, 1).addEdge(0, 3)
                .addEdge(1, 2).addEdge(1, 4)
                .addEdge(2, 5)
                .addEdge(3, 4)
                .addEdge(5, 4).addEdge(5, 7)
                .addEdge(7, 6);
        g.topoSortByKahn();
        System.out.println("\n-----");
        g.topoSortByDFS();
        System.out.println("\n-----");
        g.topoSortByBFS();
    }

    private void topoSortByBFS() {
        boolean[] visited = new boolean[v];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); i++) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    visited[q] = true;
                    queue.add(q);
                }
            }
            System.out.print("->" + w);
        }
    }
}