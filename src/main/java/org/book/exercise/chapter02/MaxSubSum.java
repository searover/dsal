package org.book.exercise.chapter02;

/**
 * @author luxz
 * @date 2024/11/11-22:50
 */
public class MaxSubSum {

    public static void main(String[] args) {
//        int a[] = {-2, 11, -4, 13, -5, -2};
        int a[] = {4, -3, 5, -2, -1, 2, 6, -2};
        int maxSubSum = maxSubSum1(a);
        System.out.println("Max sub sum: " + maxSubSum);
        maxSubSum = maxSubSum2(a);
        System.out.println("Max sub sum2: " + maxSubSum);
        maxSubSum = maxSubSum3(a);
        System.out.println("Max sub sum3: " + maxSubSum);
    }

    public static int maxSubSum1(int[] a) {
        int maxSum = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                int thisSum = 0;
                for (int k = i; k <= j; k++) {
                    thisSum += a[k];
                    if (thisSum > maxSum) {
                        maxSum = thisSum;
                    }
                }
            }
        }
        return maxSum;
    }

    public static int maxSubSum2(int[] a) {
        int maxSum = 0;
        for (int i = 0; i < a.length; i++) {
            int thisSum = 0;
            for (int j = i; j < a.length; j++) {
                thisSum += a[j];
                if (thisSum > maxSum) {
                    maxSum = thisSum;
                }
            }
        }
        return maxSum;
    }

    private static int maxSumRec(int[] a, int left, int right) {
        if (left == right) {  // Base case
            if (a[left] > 0)
                return a[left];
            else
                return 0;
        }
        int center = (left + right) / 2;
        int maxLeftSum = maxSumRec(a, left, center);
        int maxRightSum = maxSumRec(a, center + 1, right);

        int maxLeftBorderSum = 0, leftBorderSum = 0;
        for (int i = center; i >= left; i--) {
            leftBorderSum += a[i];
            if (leftBorderSum > maxLeftBorderSum) {
                maxLeftBorderSum = leftBorderSum;
            }
        }

        int maxRightBorderSum = 0, rightBorderSum = 0;
        for (int i = center + 1; i <= right; i++) {
            rightBorderSum += a[i];
            if (rightBorderSum > maxRightBorderSum) {
                maxRightBorderSum = rightBorderSum;
            }
        }

        return max3(maxLeftSum, maxRightSum, maxLeftBorderSum + maxRightBorderSum);
    }

    private static int max3(int a, int b, int c) {
        int maxab = Integer.max(a, b);
        return Integer.max(maxab, c);
    }

    public static int maxSubSum3(int[] a) {
        return maxSumRec(a, 0, a.length - 1);
    }
}
