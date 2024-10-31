package org.example.tree;

/**
 * @author luxz
 * @date 2024/10/28-22:02
 */
public class BinarySearchTree {

    public static void main(String[] args) {
        Node root = new Node(33);

        Node n11 = new Node(17);
        Node n12 = new Node(50);
        root.setLeft(n11);
        root.setRight(n12);

        Node n21 = new Node(13);
        Node n22 = new Node(18);
        n11.setLeft(n21);
        n11.setRight(n22);
        Node n23 = new Node(34);
        Node n24 = new Node(58);
        n12.setLeft(n23);
        n12.setRight(n24);

        Node n31 = new Node(16);
        n21.setRight(n31);
        Node n32 = new Node(25);
        n22.setRight(n32);
        Node n33 = new Node(51);
        Node n34 = new Node(66);
        n24.setLeft(n33);
        n24.setRight(n34);

        Node n41 = new Node(19);
        Node n42 = new Node(27);
        n32.setLeft(n41);
        n32.setRight(n42);
        Node target = binarySearch(root, 15);
        if (target == null)
            System.out.println("Target node not found.");
        else
            System.out.println("Target node: " + target.value);

        int[] arr = {33, 16, 50, 13, 18, 34, 58, 15, 17, 25, 51, 66, 19, 27, 55};
        Node tree = new Node(33);
        for (int i : arr) {
            System.out.println("insert " + i);
            insert(tree, i);
            preOrder(tree);
            System.out.println();
        }
        midOrder(tree);
        delete(tree, 13);
        delete(tree, 18);
//        delete(tree, 25);
        delete(tree, 55);
        System.out.println();
        preOrder(tree);
        System.out.println();
        midOrder(tree);
        System.out.println();
    }

    private static Node binarySearch(Node root, int target) {
        if (root == null)
            return null;
        if (root.value == target)
            return root;
        if (root.value > target) {
            return binarySearch(root.left, target);
        } else {
            return binarySearch(root.right, target);
        }
    }

    private static Node insert(Node root, int data) {
        if (root == null)
            return new Node(data);
        if (root.value == data)
            return root;
        if (root.value > data) {
            if (root.left == null) {
                root.setLeft(new Node(data));
                return root.getLeft();
            } else {
                return insert(root.left, data);
            }
        } else {
            if (root.right == null) {
                root.setRight(new Node(data));
                return root.getRight();
            } else {
                return insert(root.getRight(), data);
            }
        }
    }

    private static void preOrder(Node root) {
        if (root == null)
            return;
        System.out.printf("%s\t", root.value);
        preOrder(root.left);
        preOrder(root.right);
    }

    private static void delete(Node tree, int data) {
        Node toBeDeleted = tree;
        Node parent = null;
        // 查找待删除节点
        while (toBeDeleted != null && toBeDeleted.value != data) {
            if (toBeDeleted.value > data) {
                parent = toBeDeleted;
                toBeDeleted = toBeDeleted.left;
            }
            if (toBeDeleted.value < data) {
                parent = toBeDeleted;
                toBeDeleted = toBeDeleted.right;
            }
        }
        if (toBeDeleted == null) {
            System.out.println(data + " not found.");
            return;
        }
        // 待删除节点没有左右子树
        if (toBeDeleted.getLeft() == null && toBeDeleted.getRight() == null) {
            if (parent.value > toBeDeleted.value) {
                // 是父节点的左节点
                parent.setLeft(null);
            } else {
                // 是父节点的右节点
                parent.setRight(null);
            }
        }
        // 待删除节点存在左子树
        if (toBeDeleted.getLeft() != null && toBeDeleted.getRight() == null) {
            if (parent.value > toBeDeleted.value) {
                // 将待删除节点的左子树给到父节点
                parent.setLeft(toBeDeleted.getLeft());
            } else {
                parent.setRight(toBeDeleted.getLeft());
            }
        }
        // 待删除节点有右子树
        if (toBeDeleted.getLeft() == null && toBeDeleted.getRight() != null) {
            if (parent.value > toBeDeleted.value) {
                parent.setLeft(toBeDeleted.getRight());
            } else {
                parent.setRight(toBeDeleted.getRight());
            }
        }
        // 待删除节点同时有左右子树
        if (toBeDeleted.getLeft() != null && toBeDeleted.getRight() != null) {
            // 查找待删除节点右子树上最小值节点
            Node leftLeaf = toBeDeleted.getRight();
            Node leftLeafParent = toBeDeleted;
            while (leftLeaf.getLeft() != null) {
                leftLeafParent = leftLeaf;
                leftLeaf = leftLeaf.getLeft();
            }
            toBeDeleted.value = leftLeaf.value;
            if (leftLeafParent == toBeDeleted) {
                leftLeafParent.setRight(null);
            } else {
                leftLeafParent.setLeft(null);
            }
        }
    }

    private static void midOrder(Node tree) {
        if (tree == null)
            return;
        midOrder(tree.left);
        System.out.printf("%s\t", tree.value);
        midOrder(tree.right);
    }
}
