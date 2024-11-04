package org.example.string;

/**
 * @author luxz
 * @date 2024/11/1-21:05
 */
public class Trie {
    private TrieNode root = new TrieNode('/');

    public void insert(char[] text){
        TrieNode p = root;
        for (int i = 0; i < text.length; i++) {
            int idx = text[i] - 'a';
            if(p.children[idx] == null){
                p.children[idx] = new TrieNode(text[i]);
            }
            p = p.children[idx];
        }
        p.isEndingChar = true;
    }

    public boolean find(char[] pattern){
        TrieNode p = root;
        for (int i = 0; i < pattern.length; i++) {
            int idx = pattern[i] - 'a';
            if(p.children[idx] == null){
                System.out.println("Not found.");
                return false;
            }
            p = p.children[idx];
        }
        if(p.isEndingChar == false){
            System.out.println("Found prefix.");
            return false;
        }
        System.out.println("Found.");
        return true;
    }

    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("how".toCharArray());
        t.insert("hi".toCharArray());
        t.insert("her".toCharArray());
        t.insert("hello".toCharArray());
        t.insert("so".toCharArray());
        t.insert("see".toCharArray());

        t.find("ht".toCharArray());
    }
}
