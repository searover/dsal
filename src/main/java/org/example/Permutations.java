package org.example;

/**
 * @author luxz
 * @date 2024/10/29-13:37
 */
public class Permutations {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        print(a, 4, 4);
    }

    private static void print(int[] data, int n, int k) {
        if (k == 1) {
            for (int i = 0; i < n; ++i)
                System.out.print(data[i] + " ");
            System.out.println();
        }

        for (int i = 0; i < k; ++i) {
            System.out.println("swap " + data[i] + " & " + data[k-1]);
            int tmp = data[i];
            data[i] = data[k - 1];
            data[k - 1] = tmp;

            print(data, n, k - 1);

            tmp = data[i];
            data[i] = data[k - 1];
            data[k - 1] = tmp;
        }
    }
}
