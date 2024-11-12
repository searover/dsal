package org.book.exercise.chapter02;

/**
 * @author luxz
 * @date 2024/11/12-20:50
 */
public class Pow {
    public static void main(String[] args) {
        long p = pow(2, 11);
        System.out.println(p);
    }

    /**
     * 求幂算法，递归
     *
     * @param x
     * @param n
     * @return
     */
    private static long pow(long x, int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return x;
        if (isEven(n))
            return pow(x * x, n / 2);
        else
            return pow(x * x, n / 2) * x;
    }

    private static boolean isEven(int n) {
        return (n % 2) == 0;
    }
}
