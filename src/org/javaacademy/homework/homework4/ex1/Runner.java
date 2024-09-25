package org.javaacademy.homework.homework4.ex1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Runner {
    private static final Integer START_NUMBER = 0;
    private static final String FIRST_CONDITION = "04";
    private static final String SECOND_CONDITION = "00";

    public static void main(String[] args) {
        //ИСПОЛЬЗОВАНИЕ FOR, WHILE ЗАПРЕЩЕНО В ЭТОЙ ДЗ! Только СТРИМЫ.

        //Задание №1 - Список спец номеров
        //Нам необходимо распечатать список номеров, которые принадлежат чиновникам
        //1. Создать класс машина. У машины есть номер.
        //2. Создать 50 машин с номерами а0[01-50]ан799 (где [01-50] - это все значения от 01 до 50)
        //3. Создать 50 машин с номерами к0[01-50]се178 (где [01-50] - это все значения от 01 до 50)
        //4. Объединить машины в единый стрим
        //5. Оставить в объединенном стриме машины с номерами 04[0-9] - это номера, выдаваемые чиновникам
        //6. Получить из оставшихся машин номера.
        //7. Распечатать номера.
        //ожидаемый результат:
        // a040ан799
        // a041ан799
        // ...
        // k048се178
        // k049се178

        AtomicInteger number = new AtomicInteger(START_NUMBER);

        Stream<Car> numbersStream = Stream.generate(() -> new Car(String.format("а0%02dан799", number.addAndGet(1))))
                        .limit(50);
        Stream<Car> numbersStream2 = Stream.generate(() -> new Car(String.format("к0%02dсе178", number.addAndGet(1))))
                .limit(50);
        Stream<Car> numbersStream3 = Stream.generate(() -> new Car(String.format("к0%02dсе178", number.addAndGet(1))))
                .limit(50);

        Stream.concat(numbersStream, numbersStream2).map(numberCar -> numberCar.getNumberCar())
                .filter(numberCar -> (numberCar.contains("04") && !numberCar.contains("00")))
                .forEach(numberCar -> System.out.println(numberCar));

    }
}
