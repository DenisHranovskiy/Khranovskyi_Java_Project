package semester1.practice02.homework;

import java.util.Locale;

// Завдання 1
public class Task1CurrencyExchange {
    public static void main(String[] args) {
        double usdAmount = 250.0;
        final double EXCHANGE_RATE = 41.25;
        final double COMMISSION_PERCENT = 1.5; // 1.5%

        // сума в гривнях до комісії
        double totalUah = usdAmount * EXCHANGE_RATE;
        // комісія банку
        double commission = totalUah * COMMISSION_PERCENT / 100;
        // чиста сума
        double netAmount = totalUah - commission;
        // готівка без монет
        long cashAmount = Math.round(netAmount);

        Locale us = Locale.US; // щоб розділювач був крапкою
        System.out.println("================ КВИТАНЦІЯ ОБМІНУ ================");
        System.out.println(String.format(us, "%-28s%.2f USD", "Сума до обміну:", usdAmount));
        System.out.println(String.format(us, "%-28s%.2f UAH/USD", "Курс валют:", EXCHANGE_RATE));
        System.out.println(String.format(us, "%-28s%.2f UAH", "Нараховано до комісії:", totalUah));
        System.out.println(String.format(us, "%-28s%.2f UAH", "Комісія банку (" + COMMISSION_PERCENT + "%):", commission));
        System.out.println("--------------------------------------------------");
        System.out.println(String.format(us, "%-28s%.2f UAH", "Чиста сума до видачі:", netAmount));
        System.out.println(String.format(us, "%-28s%d UAH", "До видачі готівкою:", cashAmount));
        System.out.println("==================================================");
    }
}
