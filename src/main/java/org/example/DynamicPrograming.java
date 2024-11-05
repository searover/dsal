package org.example;

/**
 * @author luxz
 * @date 2024/11/4-14:50
 */
public class DynamicPrograming {

    // weight[] 物品重量
    // n 物品个数
    // w 背包承重
    public int knapsack(int[] weight, int n, int w) {
        boolean[][] states = new boolean[n][w + 1];
        states[0][0] = true;
        if (weight[0] < w) {
            states[0][weight[0]] = true;
        }

        for (int i = 1; i < n; ++i) {
            // 不把第i个物品放入背包
            for (int j = 0; j <= w; ++j) {
                if (states[i - 1][j])
                    states[i][j] = states[i - 1][j];
            }
            // 把第i个物品放入背包
            for (int j = 0; j <= w - weight[i]; ++j) {
                if (states[i - 1][j])
                    states[i][j + weight[i]] = true;
            }
        }
        for (int i = w; i >= 0; --i) {
            if (states[n - 1][i])
                return i;
        }
        return 0;
    }

    public int knapsack2(int[] weight, int n, int w) {
        boolean[] states = new boolean[w + 1];
        states[0] = true;
        if (weight[0] < w) {
            states[weight[0]] = true;
        }
        for (int i = 1; i < n; ++i) {
            for (int j = w - weight[i]; j >= 0; --j) {
                if (states[j])
                    states[j + weight[i]] = true;
            }
        }
        for (int i = w; i >= 0; --i) {
            if (states[i])
                return i;
        }
        return 0;
    }

    public int knapsack3(int[] weight, int[] value, int n, int w) {
        int[][] states = new int[n][w + 1];
        // 初始化states
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < w + 1; ++j) {
                states[i][j] = -1;
            }
        }

        states[0][0] = 0;
        if (weight[0] <= w) {
            states[0][weight[0]] = value[0];
        }
        for (int i = 1; i < n; i++) {
            // 不选择第i个物品
            for (int j = 0; j <= w; j++) {
                if (states[i - 1][j] >= 0) {
                    states[i][j] = states[i - 1][j];
                }
            }
            // 选择第i个物品
            for (int j = 0; j <= w - weight[i]; j++) {
                if (states[i - 1][j] >= 0) {
                    int v = states[i - 1][j] + value[i];
                    if (v > states[i][j + weight[i]]) {
                        states[i][j + weight[i]] = v;
                    }
                }
            }
        }
        // 找出最大值
        int maxValue = -1;
        for (int j = 0; j <= w; j++){
            if(states[n-1][j] > maxValue)
                maxValue = states[n-1][j];
        }
        return maxValue;
    }
}
