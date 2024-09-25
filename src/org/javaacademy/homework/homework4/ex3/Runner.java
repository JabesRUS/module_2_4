package org.javaacademy.homework.homework4.ex3;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    private static final Integer FIRST_THREE_SKYSCRAPPERS = 3;
    private static final Integer ONE_KILLOMETER = 1000;

    public static void main(String[] args) {
        List<Skyscraper> towerList = new ArrayList<>(List.of(
                new Skyscraper("Всемирный торговый центр", 541),
                new Skyscraper("Шанхайская башня", 632),
                new Skyscraper("Бурдж-Халифа", 828),
                new Skyscraper("Международный финансовый центр Пинань", 599),
                new Skyscraper("Абрадж аль-Бейт", 601),
                new Skyscraper("Бурдж-Халифа", 828),
                new Skyscraper("Всемирный центр Лотте", 555)
        ));
        //4.1 Убрать дубликаты и сохранить в новый лист (далее работаем с этим листом).
        List<Skyscraper> towerList2 = towerList.stream()
                .distinct()
                .toList();

        //4.2. Вывести только первые три небоскреба.
        towerList2.stream().limit(FIRST_THREE_SKYSCRAPPERS).forEach(System.out::println);
        System.out.println("------------------------");

        //4.3. Вывести самый высокий небоскреб.
        towerList2.stream()
                .max((tower1, tower2) -> tower1.getHeight().compareTo(tower2.getHeight()))
                .ifPresent(System.out::println);
        System.out.println("------------------------");

        //4.4. Вывести те небоскребы, которые выше километра.
        System.out.println("------------------------");
        towerList2.stream().filter(tower -> tower.getHeight() > ONE_KILLOMETER)
                .forEach(System.out::println);
        //Если выше километра нет, то вывести на экран: небоскреба выше километра - нет.
    }
}
