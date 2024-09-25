package org.javaacademy.homework.homework1;

import org.javaacademy.homework.homework1.ex1.Zoo;
import org.javaacademy.homework.homework1.ex1.animal.Bird;
import org.javaacademy.homework.homework1.ex1.animal.Dog;
import org.javaacademy.homework.homework1.ex1.animal.Tiger;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static final String TEMPERATURE_OF_JANUARY = "0,-1,-1,-2,-5,-6,-7,-8,-9,-10,-5,-5,-2,-7,-3,-1,-8,-9,-8,-8,-18,-20,-23,-24,-25,-9,-8,-7,-6,-5,-1";
    public static final String TEMPERATURE_OF_FEBRUARY = "-8,-10,-12,-13,-15,-16,-12,-7,-8,-10,-10,-9,-8,-8,-8,-9,-10,-9,-5,-6,-8,-7,-8,-9,-6,-5,-3,-1";
    public static final String SEPARATOR = ",";

    public static void main(String[] args) {
        ex1();
        ex2();
        ex3();
        //Задание №1 Зоопарк
        //1. Создать три вида животных: Тигр - умеетFebruary рычать, Собака - умеет лаять, Птица - умеет летать.
        //Общий родитель - животное (никаких атрибутов и методов в нем нет).
        //2. Создать зоопарк, который может хранить в себе 3 животных любого типа.
        //Т.е. могут быть следующие зоопарки:
        // Зоопарк в котором Тигр, Тигр, Птица
        // Зоопарк в котором Собака, Собака, Собака
        // Зоопарк в котором Птица, Птица, Тигр.
            //3. Сделать геттеры на всех животных.
        //Сделать так, чтобы при получении животного, мы могли воспользоваться специфичным для него действием.
        //Т.е. создали зоопарк Тигр, Собака, Птица (положили в этот зоопарк животных  при создании).
        //Получили первое животное (тигра) - вызвали у него рык
        //Получили второе животное (собака) - вызвали у него лай
        //Получили первое животное (птица) - вызвали у него полет
        //Запрещено пользоваться instanceOf.


        //Задание №2 Гидрометцентр
        //Создать две структуры данных, в которых будет статистика по дням (среднесуточная температура воздуха)
        //Январь: 0,-1,-1,-2,-5,-6,-7,-8,-9,-10,-5,-5,-2,-7,-3,-1,-8,-9,-8,-8,-18,-20,-23,-24,-25,-9,-8,-7,-6,-5,-1
        //Февраль: -8,-10,-12,-13,-15,-16,-12,-7,-8,-10,-10,-9,-8,-8,-8,-9,-10,-9,-5,-6,-8,-7,-8,-9,-6,-5,-3,-1
        //Объединить данные за январь и февраль, посчитать среднесуточную температуру воздуха за 2 месяца.
        //Запрещено использовать массивы.
        //Задание №3 Ресторанный гуру
        //Николай Петрович ходит по ресторанам. За 5 дней он был во множестве ресторанов.
        //Он обратился к вам, чтобы узнать в каком ресторане(ах) он был каждый день
        // (т.е. найти ресторан(ы) в которых он был и в понедельник, и во вторник, и в среду и тд).

    }

    public static void ex1() {
        Zoo<Tiger, Dog, Bird> zoo = new Zoo<>(new Tiger(), new Dog(), new Bird());

        Tiger tiger = zoo.getAnimal1();
        tiger.growl();

        Dog dog = zoo.getAnimal2();
        dog.bark();

        Bird bird = zoo.getAnimal3();
        bird.fly();

    }

    public static void ex2() {
        String[] temperaturesOfJanuary = TEMPERATURE_OF_JANUARY.split(SEPARATOR);
        String[] temperaturesOfFebruary = TEMPERATURE_OF_FEBRUARY.split(SEPARATOR);
        ArrayList<BigDecimal> januaryTemperature = new ArrayList<>();
        ArrayList<BigDecimal> februaryTemperature = new ArrayList<>();

        for (int i = 0; i < temperaturesOfJanuary.length; i++) {
            januaryTemperature.add(new BigDecimal(temperaturesOfJanuary[i]));
            if (i < temperaturesOfFebruary.length) {
                februaryTemperature.add(new BigDecimal(temperaturesOfFebruary[i]));
            }
        }

        ArrayList<BigDecimal> combineTemperature = new ArrayList<>(januaryTemperature);
        combineTemperature.addAll(februaryTemperature);

        BigDecimal averageTemperature = BigDecimal.ZERO;

        for (BigDecimal temperatureOfDay : combineTemperature) {
            averageTemperature = averageTemperature.add(temperatureOfDay);
        }

        averageTemperature = averageTemperature.divide(new BigDecimal(combineTemperature.size()), 1, RoundingMode.HALF_UP);

        System.out.printf("среднесуточная температура воздуха за 2 месяца: %s\n", averageTemperature);

    }public static void ex3() {
        ArrayList<String> monday = new ArrayList<>(List.of("Чебуречная №1", "Реберная", "Андерсон", "Ниппон", "Фо бо"));
        ArrayList<String> tuesday = new ArrayList<>(List.of("Вареничная №1", "Пушкин", "Чебуречная №1", "Ниппон", "Реберная"));
        ArrayList<String> wednesday = new ArrayList<>(List.of("Реберная", "Арарат", "Майя", "Ниппон", "Таксим"));
        ArrayList<String> thursday = new ArrayList<>(List.of("Грех", "Ваниль", "Реберная", "Пянсе", "Фо бо"));
        ArrayList<String> friday = new ArrayList<>(List.of("Бёрдс", "Реберная", "Андерсон", "Ниппон", "Чифанька"));

        ArrayList<String> intersectionOfRestaurants = new ArrayList<>(monday);
        intersectionOfRestaurants.retainAll(tuesday);
        intersectionOfRestaurants.retainAll(wednesday);
        intersectionOfRestaurants.retainAll(thursday);
        intersectionOfRestaurants.retainAll(friday);

        if (!intersectionOfRestaurants.isEmpty()) {
            System.out.printf("ресторан(ы) в которых Николай Петрович был во все дни - %s\n",
                    intersectionOfRestaurants);
        } else {
            System.out.println("Нет ресторанов в которых Николай Петрович был во все дни");
        }

    }
}
