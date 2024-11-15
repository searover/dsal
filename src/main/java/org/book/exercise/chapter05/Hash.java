package org.book.exercise.chapter05;

/**
 * @author luxz
 * @date 2024/11/15-21:18
 */
public class Hash {

    /**
     * 把字符串中字符的ASCII码值加起来
     *
     * @param key
     * @param tableSize
     * @return
     */
    public static int hash1(String key, int tableSize) {
        int hashVal = 0;
        for (int i = 0; i < key.length(); i++) {
            hashVal += key.charAt(i);
        }
        return hashVal % tableSize;
    }

    public static int hash2(String key, int tableSize) {
        return (key.charAt(0) + key.charAt(1) * 27 + key.charAt(2) * 27 * 27) % tableSize;
    }

    /**
     * A hash routine for String objects.
     *
     * @param key       the String to hash
     * @param tableSize the size of the hash table
     * @return the hash value
     */
    public static int hash3(String key, int tableSize) {
        int hashVal = 0;
        for (int i = 0; i < key.length(); i++) {
            hashVal = 37 * hashVal + key.charAt(i);
        }

        hashVal %= tableSize;
        if (hashVal < 0)
            hashVal += tableSize;
        return hashVal;
    }

    public static void main(String[] args) {
        String str = "Hello World!";
        int tableSize = 1000;
        System.out.println(hash1(str, tableSize));
        System.out.println(hash2(str, tableSize));
        System.out.println(hash3(str, tableSize));
    }
}
