package org.book.exercise.chapter01;

import java.util.Comparator;

/**
 * @author luxz
 * @date 2024/11/10-14:22
 */
public class Generic {

    public static void main(String[] args) {
        Person[] arr = new Person.Employee[5];
        arr[0] = new Person.Employee();
        arr[1] = new Person.Employee();
        findMax(arr);



    }

    /**
     * 在一个数组中找出最大元素的泛型static方法，类型参数的限界
     * @param arr
     * @return
     * @param <T>
     */
    public static <T extends Comparable<? super T>> T findMax(T[] arr){
        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if(arr[maxIndex].compareTo(arr[i]) < 0){
                maxIndex = i;
            }
        }
        return arr[maxIndex];
    }

    public static <T> T findMax(T[] arr, Comparator<? super T> cmp){
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if(cmp.compare(arr[i],arr[maxIndex])>0){
                maxIndex = i;
            }
        }
        return arr[maxIndex];
    }
}

class CaseInsensitiveCompare implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        return o1.compareToIgnoreCase(o2);
    }
}

class TestProgram{
    public static void main(String[] args) {
        String[] arr = {"ZEBRA", "alligator", "crocodile"};
        System.out.println(Generic.findMax(arr,new CaseInsensitiveCompare()));
    }
}
