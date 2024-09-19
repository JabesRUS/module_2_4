package org.javaacademy.homework.homework3.ex2;

public class Human {
    private String name;
    private Integer age;
    private Integer height;

    public Human(String name, Integer age, Integer height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getHeight() {
        return height;
    }
}
