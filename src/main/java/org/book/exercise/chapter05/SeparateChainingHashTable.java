package org.book.exercise.chapter05;

import java.util.LinkedList;
import java.util.List;

/**
 * @author luxz
 * @date 2024/11/15-21:51
 */
public class SeparateChainingHashTable<T> {

    public SeparateChainingHashTable() {
        this(DEFAULT_TABLE_SIZE);
    }

    public SeparateChainingHashTable(int size) {
        theLists = new LinkedList[nextPrime(size)];
        for (int i = 0; i < theLists.length; i++) {
            theLists[i] = new LinkedList<>();
        }
    }

    /**
     * Insert into the hash table. If the item is already present,
     * then do nothing.
     *
     * @param x the item to insert.
     */
    public void insert(T x) {
        List<T> whichList = theLists[myhash(x)];
        if (!whichList.contains(x)) {
            whichList.add(x);
            // Rehash
            if (++currentSize > theLists.length)
                rehash();
        }
    }

    public void remove(T x) {
        List<T> whichList = theLists[myhash(x)];
        if (whichList.contains(x)) {
            whichList.remove(x);
            currentSize--;
        }
    }

    /**
     * Find an item in the hash table
     *
     * @param x the item to search for
     * @return true if x is found
     */
    public boolean contains(T x) {
        List<T> whichList = theLists[myhash(x)];
        return whichList.contains(x);
    }

    /**
     * Make the hashtable logically empty
     */
    public void makeEmpty() {
        for (int i = 0; i < theLists.length; i++) {
            theLists[i].clear();
        }
        currentSize = 0;
    }


    private static final int DEFAULT_TABLE_SIZE = 101;

    private List<T>[] theLists;
    private int currentSize;

    private void rehash() {
    }

    private int myhash(T x) {
        int hashVal = x.hashCode();
        hashVal %= theLists.length;
        if (hashVal < 0)
            hashVal += theLists.length;
        return hashVal;
    }

    private static int nextPrime(int n) {
        throw new UnsupportedOperationException();
    }

    private static boolean isPrime(int n) {
        throw new UnsupportedOperationException();
    }
}
