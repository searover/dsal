package org.example.tree;

/**
 * @author luxz
 * @date 2024/10/28-19:27
 */
public class Node {
    String name;
    Integer value;
    Node left;
    Node right;

    public Node(String name) {
        this.name = name;
    }

    public Node(Integer value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
