package org.javaacademy.homework.homework4.ex1;

public class Car {
    private String numberCar;

    public Car(String number) {
        this.numberCar = number;
    }

    public String getNumberCar() {
        return numberCar;
    }

    @Override
    public String toString() {
        return "Car{" +
                "numberCar='" + numberCar + '\'' +
                '}';
    }
}
