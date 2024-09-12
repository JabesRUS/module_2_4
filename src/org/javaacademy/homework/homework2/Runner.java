package org.javaacademy.homework.homework2;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Runner {
    public static final String FILE_NAME = "luggage.csv";
    public static final Integer TAPE_CAPACITY = 10;
    public static final String SEPARATOR = ";";
    public static final Integer BAGGAGE_NUMBER_CELL = 0;
    public static final Integer BAGGAGE_WEIGHT_CELL = 1;

    public static void getLuggage(String fileName) throws IOException {
        try(InputStream resourceAsStream = Runner.class.getClassLoader().getResourceAsStream(fileName);
            Scanner scanner = new Scanner(resourceAsStream)) {
            Queue<String> baggageQueue = new LinkedList<String>();
            scanner.nextLine();

            while(scanner.hasNextLine()) {
                int count = 1;
                System.out.println("Начинается загрузка на ленту");
                while (baggageQueue.size() < TAPE_CAPACITY) {
                    baggageQueue.add(scanner.nextLine().split(SEPARATOR)[BAGGAGE_NUMBER_CELL]);
                    if(!scanner.hasNextLine()) {
                        break;
                    }
                }

                System.out.println("Лента загружена, начинается выдача багажа");

                while (!baggageQueue.isEmpty()){
                    System.out.printf("%d. Багаж №%s - выдан.\n",count, baggageQueue.poll());
                    count++;
                }
                System.out.println("Лента пустая, закончена выдача багажа");
            }
        }
    }


    public static Map<String, Integer> infoBaggage (String FILE_NAME) throws IOException {
        Map<String, Integer> customsStatistics = new HashMap<>(Map.of("Легкий", 0, "Средний", 0, "Тяжелый" , 0)){};
        int weigthOfBaggage = 0;

        try (InputStream resourceAsStream = Runner.class.getClassLoader().getResourceAsStream(FILE_NAME);
             Scanner scanner = new Scanner(resourceAsStream)) {
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                weigthOfBaggage = Integer.parseInt(scanner.nextLine().split(SEPARATOR)[BAGGAGE_WEIGHT_CELL]);
//                легкий (до 5 кг), средний (от 5 кг до 10кг), тяжелый (от 10 кг)
                if (weigthOfBaggage < 5) {
                    customsStatistics.put("Легкий", customsStatistics.get("Легкий") + weigthOfBaggage);
                } else if (weigthOfBaggage >= 5 && weigthOfBaggage < 10) {
                    customsStatistics.put("Средний", customsStatistics.get("Средний") + weigthOfBaggage);
                } else {
                    customsStatistics.put("Тяжелый", customsStatistics.get("Тяжелый") + weigthOfBaggage);
                }
            }
        }

        return customsStatistics;
    }


    public static void main(String[] args) throws IOException {
        getLuggage(FILE_NAME);
        System.out.println(infoBaggage(FILE_NAME));

    }
}
