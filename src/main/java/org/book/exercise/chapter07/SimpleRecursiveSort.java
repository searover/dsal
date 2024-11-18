package org.book.exercise.chapter07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author luxz
 * @date 2024/11/17-18:54
 */
public class SimpleRecursiveSort {
    /**
     * 简单递归排序算法
     * @param items
     */
    public static void sort(List<Integer> items) {
        if (items.size() > 1) {
            List<Integer> smaller = new ArrayList<>();
            List<Integer> same = new ArrayList<>();
            List<Integer> larger = new ArrayList<>();

            Integer chosenItem = items.get(items.size() / 2);
            for (Integer item : items) {
                if (chosenItem > item)
                    smaller.add(item);
                else if (chosenItem == item)
                    same.add(item);
                else
                    larger.add(item);
            }

            sort(smaller);
            sort(larger);

            items.clear();
            items.addAll(smaller);
            items.addAll(same);
            items.addAll(larger);
        }
    }

    public static void main(String[] args) {
        Integer[] a = {81, 94, 11, 96, 12, 35, 17, 95, 28, 58, 41, 75, 15};
        List<Integer> items = new ArrayList<>(Arrays.asList(a));
        sort(items);
        System.out.println(items);
    }
}
