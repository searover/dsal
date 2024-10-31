package org.example.tree;

import java.util.*;

/**
 * @author luxz
 * @date 2024/10/28-19:28
 */
public class TreeIterate {
    public static void main(String[] args) {
        Node n1 = new Node("A");
        Node n2 = new Node("B");
        Node n3 = new Node("C");
        Node n4 = new Node("D");
        Node n5 = new Node("E");
        Node n6 = new Node("F");
        Node n7 = new Node("G");

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        preOrder(n1);
        System.out.println();
        midOrder(n1);
        System.out.println();
        postOrder(n1);
        System.out.println();
        levelOrder(n1);
        System.out.println();
        LinkedList<Node> nodes = new LinkedList<>();
        nodes.add(n1);
        layerOrder(nodes);
        System.out.println();
    }

    private static void preOrder(Node root) {
        if (root == null)
            return;
        System.out.printf("%s\t", root.name);
        preOrder(root.left);
        preOrder(root.right);
    }

    private static void midOrder(Node root) {
        if (root == null)
            return;
        midOrder(root.left);
        System.out.printf("%s\t", root.name);
        midOrder(root.right);
    }

    private static void postOrder(Node root) {
        if (root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.printf("%s\t", root.name);
    }

    private static void levelOrder(Node root) {
        if (root == null)
            return;
        HashMap<Integer, List<Node>> nodes = new LinkedHashMap<>();
        preOrder(root, 0, nodes);
        for (Map.Entry<Integer, List<Node>> entry : nodes.entrySet()) {
            for (Node node : entry.getValue()) {
                System.out.printf("%s\t", node.name);
            }
        }
    }

    private static void preOrder(Node root, int depth, HashMap<Integer, List<Node>> nodeMap) {
        if (root == null)
            return;
        if (!nodeMap.containsKey(depth))
            nodeMap.put(depth, new ArrayList<>());
        nodeMap.get(depth).add(root);
        depth++;
        preOrder(root.left, depth, nodeMap);
        preOrder(root.right, depth, nodeMap);
    }

    private static void layerOrder(LinkedList<Node> nodes) {
        if(nodes.isEmpty())
            return;
        Node node = nodes.pop();
        System.out.printf("%s\t", node.name);
        if (node.left != null)
            nodes.add(node.left);
        if (node.right != null)
            nodes.add(node.right);
        layerOrder(nodes);
    }
}
