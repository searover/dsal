package org.book.exercise.chapter01;

/**
 * @author luxz
 * @date 2024/11/10-13:02
 */
public class Recursive {
    public static void main(String[] args) {
        System.out.println("f(0)=" + f(0));
        System.out.println("f(1)=" + f(1));
        System.out.println("f(2)=" + f(2));
        System.out.println("f(3)=" + f(3));
        System.out.println("f(4)=" + f(4));
        System.out.println("f(5)=" + f(5));
    }

    public static int f(int x) {
        if (x == 0) {
            return 0;
        }
        return 2 * f(x - 1) + x * x;
    }
}
