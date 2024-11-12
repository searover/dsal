package org.book.exercise.chapter03;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author luxz
 * @date 2024/11/13-00:08
 */
public class MyLinkedList<T> implements Iterator<T> {

    private int theSize;
    private int modCount = 0;
    private Node<T> beginMarker;
    private Node<T> endMarker;

    private static class Node<T> {
        public T data;
        public Node<T> prev;
        public Node<T> next;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    public MyLinkedList() {
        doClear();
    }

    public void clear() {
        doClear();
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean add(T x) {
        add(size(), x);
        return true;
    }

    public void add(int idx, T x) {
        addBefore(getNode(idx, 0, size()), x);
    }

    public T get(int idx) {
        return getNode(idx).data;
    }

    public T set(int idx, T newVal) {
        Node<T> p = getNode(idx);
        T oldVal = p.data;
        p.data = newVal;
        return oldVal;
    }

    public T remove(int idx) {
        return remove(getNode(idx));
    }

    private void addBefore(Node<T> p, T x) {
        Node<T> newNode = new Node<>(x, p.prev, p);
        newNode.prev.next = newNode;
        p.prev = newNode;
        theSize++;
        modCount++;
    }

    /**
     * Removes the object contained in Node p
     *
     * @param p the node containing the object
     * @return the item was removed from the collection
     */
    private T remove(Node<T> p) {
        p.prev.next = p.next;
        p.next.prev = p.prev;
        theSize--;
        modCount++;
        return p.data;
    }

    /**
     * Gets the node at position idx, which must range from 0 to size()-1.
     *
     * @param idx index to search at
     * @return internal node corresponding to idx
     * @throws IndexOutOfBoundsException if idx is not between 0 and size()-1, inclusive.
     */
    private Node<T> getNode(int idx) {
        return getNode(idx, 0, size() - 1);
    }

    /**
     * Gets the node at position idx, which must range from lower to upper.
     *
     * @param idx   index to search at
     * @param lower lowest valid index
     * @param upper highest valid index
     * @return internal node corresponding to idx
     * @throws IndexOutOfBoundsException if idx is not between lower to upper, inclusive.
     */
    private Node<T> getNode(int idx, int lower, int upper) {
        Node<T> p;
        if (idx < lower || idx > upper)
            throw new IndexOutOfBoundsException();
        if (idx < size() / 2) {
            p = beginMarker.next;
            for (int i = 0; i < idx; i++) {
                p = p.next;
            }
        } else {
            p = endMarker;
            for (int i = size(); i > idx; i--){
                p = p.prev;
            }
        }
        return p;
    }

    public Iterator<T> iterator(){
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T>{

        private Node<T> current = beginMarker.next;
        private int expectedModCount = modCount;
        private boolean okToRemove = false;

        @Override
        public boolean hasNext() {
            return current != endMarker;
        }

        @Override
        public T next() {
            if(modCount != expectedModCount)
                throw new ConcurrentModificationException();
            if(!hasNext())
                throw new NoSuchElementException();
            T nextItem = current.data;
            current = current.next;
            okToRemove = true;
            return nextItem;
        }

        public void remove(){
            if(modCount != expectedModCount)
                throw new ConcurrentModificationException();
            if(!okToRemove)
                throw new IllegalStateException();
            MyLinkedList.this.remove(current.prev);
            expectedModCount++;
            okToRemove=false;
        }
    }

    private void doClear() {
        beginMarker = new Node<>(null, null, null);
        endMarker = new Node<>(null, beginMarker, null);
        beginMarker.next = endMarker;

        theSize = 0;
        modCount++;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public T next() {
        return null;
    }
}
