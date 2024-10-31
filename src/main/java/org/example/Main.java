package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println(upstails(7));
        System.out.println(f(7));
        System.out.println((5/2));
    }

    static int upstails(int n) {
        // 终止条件
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        return upstails(n - 1) + upstails(n - 2);
    }

    static int f(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        int ret = 0;
        int pre = 2;
        int prepre = 1;
        for (int i = 3; i <= n; i++) {
            ret = pre + prepre;
            prepre = pre;
            pre = ret;
        }
        return ret;
    }
}