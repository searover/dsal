package org.book.exercise.chapter03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author luxz
 * @date 2024/11/12-22:41
 */
public class ListTest {
    public static void main(String[] args) {
        LinkedList<Integer> l1 = new LinkedList<>();
        for (int i = 0; i < 400000; i++) {
            l1.add(i);
        }
        ArrayList<Integer> a1 = new ArrayList<>();
        for (int i = 0; i < 400000; i++) {
            a1.add(i);
        }
        long start = System.currentTimeMillis();
        removeEvenVer3(l1);
        System.out.println(System.currentTimeMillis() - start);
        start = System.currentTimeMillis();
        removeEvenVer3(a1);
        System.out.println(System.currentTimeMillis() - start);
    }

    public static void removeEvenVer3(List<Integer> lst){
        Iterator<Integer> itr = lst.iterator();
        while (itr.hasNext()){
            if(itr.next() % 2 == 0)
                itr.remove();
        }
    }
}
