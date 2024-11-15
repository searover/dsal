package org.book.exercise.chapter04;

/**
 * @author luxz
 * @date 2024/11/14-15:36
 */
public class BinarySearchTree<T extends Comparable<? super T>> {
    private static class BinaryNode<T> {
        T element; // The data int the node
        BinaryNode<T> left;
        BinaryNode<T> right;

        public BinaryNode(T element) {
            this(element, null, null);
        }

        public BinaryNode(T element, BinaryNode<T> left, BinaryNode<T> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }

    private BinaryNode<T> root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void makeEmpty() {
        this.root = null;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public boolean contains(T x) {
        return contains(x, root);
    }

    public T findMin() {
        if (isEmpty())
            throw new RuntimeException();
        return findMin(root).element;
    }

    public T findMax() {
        if (isEmpty())
            throw new RuntimeException();
        return findMax(root).element;
    }

    public void insert(T x) {
        insert(x, root);
    }

    public void remove(T x) {
        remove(x, root);
    }

    public void printTree() {
        if (isEmpty())
            System.out.println("Empty tree.");
        else
            printTree(this.root);
    }

    /**
     * Internal method to find an item in a subtree.
     *
     * @param x is item to search for.
     * @param t the node that roots the subtree.
     * @return true if the item is found; false otherwise.
     */
    private boolean contains(T x, BinaryNode<T> t) {
        if (t == null)
            return false;
        int result = x.compareTo(t.element);
        if (result < 0) {
            return contains(x, t.left);
        } else if (result > 0) {
            return contains(x, t.right);
        } else {
            return true;    // Match
        }
    }

    /**
     * Internal method to find the smallest item in a subtree.
     *
     * @param t is the node that roots the subtree.
     * @return node containing the smallest item.
     */
    private BinaryNode<T> findMin(BinaryNode<T> t) {
        if (t == null)
            return null;
        else if (t.left == null)
            return t;
        else
            return findMin(t.left);
    }

    /**
     * Internal method to find the largest item in a subtree.
     *
     * @param t is the node that roots the subtree
     * @return node containing the largest item.
     */
    private BinaryNode<T> findMax(BinaryNode<T> t) {
        if (t != null)
            while (t.right != null) {
                t = t.right;
            }
        return t;
    }

    /**
     * Internal method to insert into a subtree.
     *
     * @param x is the item to insert.
     * @param t is the node that roots the subtree.
     * @return the new root of the subtree.
     */
    private BinaryNode<T> insert(T x, BinaryNode<T> t) {
        if (t == null)
            return new BinaryNode<>(t.element, t.left, t.right);
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0)
            t.left = insert(x, t.left);
        else if (compareResult > 0)
            t.right = insert(x, t.right);
        return t;
    }

    /**
     * Internal method to remove item from a subtree.
     *
     * @param x is the item to be removed.
     * @param t is the node that roots the subtree.
     * @return a new root of the subtree.
     */
    private BinaryNode<T> remove(T x, BinaryNode<T> t) {
        if (t == null)
            return t;   // Item not found, do nothing.

        int compareResult = x.compareTo(t.element);
        if (compareResult < 0)
            t.left = remove(x, t.left);
        else if (compareResult > 0)
            t.right = remove(x, t.right);
        else if (t.left != null && t.right != null) {
            // Two children
            t.element = findMin(t.right).element;
            t.right = remove(t.element, t.right);
        } else {
            t = (t.left != null) ? t.left : t.right;
        }
        return t;
    }

    /**
     * Internal method to print a subtree in sorted order
     *
     * @param t
     */
    private void printTree(BinaryNode<T> t) {
        if (t == null)
            return;
        printTree(t.left);
        System.out.println(t.element);
        printTree(t.right);
    }

    /**
     * Internal method to compute the height of a subtree.
     * @param t
     * @return
     */
    private int height(BinaryNode<T> t) {
        if (t == null)
            return -1;
        return 1 + Math.max(height(t.left), height(t.right));
    }
}
