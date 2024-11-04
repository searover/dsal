package org.example.string;

/**
 * @author luxz
 * @date 2024/11/1-21:05
 */
public class TrieNode {
    char data;
    TrieNode[] children = new TrieNode[26];

    boolean isEndingChar;

    public TrieNode(char data) {
        this.data = data;
    }
}
