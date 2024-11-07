package org.example.bplustree;

/**
 * @author luxz
 * @date 2024/11/7-22:46
 * B+树非叶子节点的定义
 */
public class BPlusTreeNode {
    public static int m = 5;
    public int[] keywords = new int[m - 1];   // 键值，用来划分数据区间
    public BPlusTreeNode[] children = new BPlusTreeNode[m]; // 保存子节点指针
}
