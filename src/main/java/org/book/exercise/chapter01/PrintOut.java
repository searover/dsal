package org.book.exercise.chapter01;

/**
 * @author luxz
 * @date 2024/11/10-13:18
 */
public class PrintOut {

    public static void main(String[] args) {
        printOut(76234);
    }

    public static void printOut(int n) {
        if (n >= 10) {
            printOut(n / 10);
        }
        printDigit(n % 10);
    }

    private static void printDigit(int n) {
        System.out.print(n + " ");
    }
}
