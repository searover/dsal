package org.example.astar;

/**
 * @author luxz
 * @date 2024/11/7-23:37
 */
public class Vertex {
    public int id;  // 顶点编号ID
    public int dist;    // 从起始顶点到当前所在顶点的距离，g(i)
    public int f;   // 估价函数 f(i) = g(i) + h(i)
    public int x,y; // 顶点在地图中的二维坐标(x,y)

    public Vertex(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.f = Integer.MAX_VALUE;
        this.dist = Integer.MAX_VALUE;
    }
}
