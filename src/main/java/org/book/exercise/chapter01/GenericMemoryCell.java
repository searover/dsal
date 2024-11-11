package org.book.exercise.chapter01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luxz
 * @date 2024/11/10-15:27
 */
public class GenericMemoryCell<T> {
    private T val;

    public T read() {
        return val;
    }

    public void write(T v) {
        this.val = v;
    }

    public static void main(String[] args) {
        GenericMemoryCell<Integer> c1 = new GenericMemoryCell<>();
        c1.write(4);
        Object cell = c1;
//        GenericMemoryCell<String> c2 = (GenericMemoryCell<String>) c1;  // compile error
        GenericMemoryCell<String> c2 = (GenericMemoryCell<String>) cell; // 这里的转换是可以的
//        String s = c2.read(); // ClassCastException


//        GenericMemoryCell<String>[] arr1 = new GenericMemoryCell<String>[10]; // Java不允许创建泛型数组
        GenericMemoryCell<String>[] arr1 = new GenericMemoryCell[10];
        GenericMemoryCell<Double> c = new GenericMemoryCell<>();
        c.write(4.5);
        Object[] arr2 = arr1;
        arr2[0] = c;
//        String s = arr1[0].read(); // ClassCastException

        List<String> strList = new ArrayList<>();
        strList.add("Hello");

        List erasedList = strList;
        erasedList.add(10);

        String element = (String) erasedList.get(1);
        System.out.println(element);
    }
}
