package org.book.exercise.chapter01;

/**
 * @author luxz
 * @date 2024/11/10-14:11
 */
public class Person implements Comparable{
    public static void main(String[] args) {
        Person[] arr = new Employee[5];
//        arr[0] = new Student(); // throw ArrayStoreException
        arr[0] = new Employee();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        boolean b = contains(arr, new Student());
        System.out.println(b);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    /**
     * @author luxz
     * @date 2024/11/10-14:11
     */
    public static class Employee extends Person {
    }

    /**
     * @author luxz
     * @date 2024/11/10-14:11
     */
    public static class Student extends Person {
    }

    public static <T> boolean contains(T[] arr, Student x) {
        for (T t : arr) {
            if (t != null && t.equals(x)) {
                return true;
            }
        }
        return false;
    }
}
