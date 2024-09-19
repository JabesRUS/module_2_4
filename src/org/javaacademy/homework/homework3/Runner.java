package org.javaacademy.homework.homework3;

import org.javaacademy.homework.homework3.ex1.Garden;
import org.javaacademy.homework.homework3.ex1.fruit.Apple;
import org.javaacademy.homework.homework3.ex1.fruit.Apricot;
import org.javaacademy.homework.homework3.ex2.Divination;
import org.javaacademy.homework.homework3.ex2.Human;
import org.javaacademy.homework.homework3.ex3.Uran;
import org.javaacademy.homework.homework3.ex3.Wood;
import org.javaacademy.homework.homework3.ex4.Animal;
import org.javaacademy.homework.homework3.ex4.Boat;
import org.javaacademy.homework.homework3.ex4.Ruler;
import org.javaacademy.homework.homework3.ex5.Review;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Consumer;

public class Runner {
    public static void main(String[] args) {
        ex1();
        ex2();
        ex3();
        ex4();
        ex5();
    }

    public static void ex1() {
        //Задание №1: Сад
        Garden<Apple> AppleFarm = () -> new Apple();
        Garden<Apricot> ApricotFarm = () -> new Apricot();

        Apple apple = AppleFarm.growUp();
        Apricot apricot = ApricotFarm.growUp();
    }

    public static void ex2() {
        //Задание №2: Поиск пары с помощью гадания
        Human human = new Human("Валентин", 12, 120);
        Divination<Human> chamomile = (anyHuman) -> anyHuman.getName().length() % 2 == 0;
        Divination<Human> fortuneTeller = (anyHuman) -> anyHuman.getAge() + anyHuman.getAge() > 210;
        System.out.println(chamomile.prediction(human));
        System.out.println(fortuneTeller.prediction(human));

    }
    public static void ex3() {
        //Задание №3: Гори ясно!
        Consumer<Uran> atomicReactor = (anyUran) -> System.out.println("зеленый свет вокруг!");
        Consumer<Wood> bonfire = (wood) -> System.out.println("желто-красный свет вокруг!");
        atomicReactor.accept(new Uran());
        bonfire.accept(new Wood());
    }

    public static void ex4() {
        //Задание №4: универсальная линейка
        Ruler<Boat> boatRuler = (boat) -> boat.getBoatLenght();
        Ruler<Animal> animalRuler = (animal) -> animal.getBodyLength() + animal.getTailLength();

        System.out.println("Длина лодки - " + boatRuler.ruler(new Boat(500)));
        System.out.println("Сумма длин животного - " + animalRuler.ruler(new Animal(80, 15)));
    }

    public static void ex5() {
        Review review1 = new Review(1,"отличный товар", 200,
                LocalDateTime.of(2024, 1, 25, 13, 37));
        Review review2 = new Review(2,"так себе товар", 100,
                LocalDateTime.of(2024, 1, 25, 16, 37));
        Review review3 = new Review(3,"отличный товар", 100,
                LocalDateTime.of(2024, 1, 25, 13, 37));
        Review review4 = new Review(4,"отличный товар", 100,
                LocalDateTime.of(2024, 1, 25, 13, 37));

        Comparator<Review> comparator = (rev1, rev2) -> {
            int result = rev1.getCountLikes().compareTo(rev2.getCountLikes());
            if (result == 0) {
                result = rev1.getDateTime().compareTo(rev2.getDateTime());
            }
            if (result == 0) {
                result = rev1.getId().compareTo(rev2.getId());
            }
            return result;
        };

        Set<Review> reviews = new TreeSet<>(comparator);
        reviews.add(review1);
        reviews.add(review2);
        reviews.add(review3);
        reviews.add(review4);

        System.out.println(reviews);
    }

}
