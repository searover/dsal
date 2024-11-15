package org.book.exercise.chapter05;

/**
 * @author luxz
 * @date 2024/11/15-22:08
 */
public class Employee {
    private String name;
    private double salary;
    private int seniority;

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
//        return this.hashCode() == name.hashCode();
        return obj instanceof Employee && name.equals(((Employee) obj).name);
    }
}
