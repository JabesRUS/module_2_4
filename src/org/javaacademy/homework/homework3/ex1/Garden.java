package org.javaacademy.homework.homework3.ex1;

import org.javaacademy.homework.homework3.ex1.fruit.Fruit;

@FunctionalInterface
public interface Garden<T extends Fruit> {
    T growUp();
}
