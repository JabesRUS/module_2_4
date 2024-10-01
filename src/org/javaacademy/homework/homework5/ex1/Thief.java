package org.javaacademy.homework.homework5.ex1;

import java.lang.reflect.Field;
import java.math.BigDecimal;

/**
 * Вор
 */
public class Thief {
    private BigDecimal money;

    private Thief() {
        this.money = BigDecimal.ZERO;
    }

    private void stealMoney(Bank bank) throws NoSuchFieldException, IllegalAccessException {
        //??
        Class<? extends Bank> bankClass = bank.getClass();
        Field fieldMoney = bankClass.getDeclaredField("money");
        fieldMoney.setAccessible(true);
        this.money = ((BigDecimal) fieldMoney.get(bank));

        fieldMoney.set(bank, BigDecimal.ZERO);
    }

    @Override
    public String toString() {
        return "Thief{" +
               "money=" + money +
               '}';
    }
}
