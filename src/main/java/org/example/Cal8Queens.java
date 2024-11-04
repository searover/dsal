package org.example;

import java.util.Arrays;

/**
 * @author luxz
 * @date 2024/11/4-13:08
 */
public class Cal8Queens {
    private int[] result = new int[8];

    public void cal8queens(int row) {
        if (row == 8) {
            System.out.println(Arrays.toString(result));
            printQueens(result);
            return;
        }
        for (int col = 0; col < 8; ++col) {
            if (isOK(row, col)) {
                result[row] = col; // 第row行棋子放第col列
                cal8queens(row + 1);
            }
        }
    }

    private boolean isOK(int row, int col) {
        int leftup = col - 1, rightup = col + 1;
        for (int i = row - 1; i >= 0; --i) {
            if (result[i] == col)
                return false;
            if (leftup > 0) {
                // 左上对角线上是否有棋子
                if (result[i] == leftup)
                    return false;
            }
            if (rightup < 8) {
                // 右上对角线是否有棋子
                if (result[i] == rightup)
                    return false;
            }
            leftup--;
            rightup++;
        }
        return true;
    }

    private void printQueens(int[] result) {
        for (int row = 0; row < 8; ++row) {
            for (int col = 0; col < 8; ++col) {
                if (result[row] == col)
                    System.out.print("Q ");
                else
                    System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Cal8Queens c8q = new Cal8Queens();
        c8q.cal8queens(0);
        System.out.println(Arrays.toString(c8q.result));
    }
}
