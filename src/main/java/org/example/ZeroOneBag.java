package org.example;

/**
 * @author luxz
 * @date 2024/11/4-13:52
 */
public class ZeroOneBag {
    private static int maxW = Integer.MIN_VALUE;

    // cw表示当前已经装进背包的物品总重量和;
    // i表示考察到哪个物品了
    // w表示背包的承载重量
    // items[]表示物品的重要数组，n表示物品个数
    public static void f(int i, int cw, int[] items, int n, int w) {
        if (cw == w || i == n) {
            // 背包承重已达上限或物品遍历完毕
            if (cw > maxW)
                maxW = cw;
            return;
        }
        // 当前物品不加入背包
        f(i + 1, cw, items, n, w);
        if (cw + items[i] <= w) {
            // 当前物品加入背包
            f(i + 1, cw + items[i], items, n, w);
        } else {
            // 搜索剪枝
            // cw+items[i] 已经超过背包承重，就不装了
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 2, 4, 6, 3};
        f(0, 0, a, 5, 9);
        System.out.println(maxW);
    }
}
