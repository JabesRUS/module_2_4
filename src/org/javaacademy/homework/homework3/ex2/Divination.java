package org.javaacademy.homework.homework3.ex2;

@FunctionalInterface
public interface Divination<T> {
    boolean prediction(T t);
}
