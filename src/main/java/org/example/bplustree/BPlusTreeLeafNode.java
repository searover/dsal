package org.example.bplustree;

/**
 * @author luxz
 * @date 2024/11/7-22:48
 */
public class BPlusTreeLeafNode {
    public static int k = 3;
    public int[] keywords = new int[k]; // 数据的键值
    public long[] dataAddress = new long[k];    // 数据地址

    public BPlusTreeLeafNode prev;  // 这个节点在链表中的前驱节点
    public BPlusTreeLeafNode next;  // 这个节点在链表中的后继节点
}
