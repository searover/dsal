package org.example.string;

import java.util.Arrays;

/**
 * @author luxz
 * @date 2024/11/1-13:21
 */
public class BM {
    private static final int SIZE = 256; // 散列表长度

    /**
     * @param b  模式串数组
     * @param m  模式串长度
     * @param bc 散列表，用于快递查找坏字符在模式串中的位置
     */
    private void generateBC(char[] b, int m, int[] bc) {
        Arrays.fill(bc, -1);
        for (int i = 0; i < m; i++) {
            int ascii = (int) b[i];
            bc[ascii] = i;
        }
    }

    public int bm(char[] a, int n, char[] b, int m) {
        int[] bc = new int[SIZE]; // 散列表，记录模式串中每个字符最后出现的位置（下标）
        generateBC(b, m, bc);
        int i = 0; // i表示主串a与模式串b首字符对齐的位置
        while (i <= n - m) {
            int j = m - 1;  // j表示模式串从后往前匹配的字符位置
            // 从后往前查找坏字符,a[i+j]表示模式串的字符在主串中对齐的字符
            for (; j >= 0; --j) {
                if (b[j] != a[i + j])
                    break;
            }
            // 遍历完整个模式串后没找到坏字符，说明模式串匹配成功，返回主串与模式串第一个匹配的字符的位置
            if (j < 0) {
                System.out.println("found.");
                return i;
            }
            // 计算滑动位数并后移
            i = i + (j - bc[(int) a[i + j]]);
        }
        return -1;
    }
}
