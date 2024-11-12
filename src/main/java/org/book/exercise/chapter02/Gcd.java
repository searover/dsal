package org.book.exercise.chapter02;

/**
 * @author luxz
 * @date 2024/11/12-20:34
 */
public class Gcd {
    public static void main(String[] args) {
        long g = gcd(1989,1590);
        System.out.println(g);
    }

    // 求最大公因数，欧几里得算法
    // 算法连续计算余数直到余数为0为止，最后得到的非0余数就是最大公因数
    private static long gcd(long m, long n) {
        while (n != 0) {
            long rem = m % n;
            System.out.println("rem: " + rem);
            m = n;
            n = rem;
        }
        return m;
    }
}
