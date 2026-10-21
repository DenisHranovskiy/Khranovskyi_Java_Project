package semester1.practice03.homework;

import java.util.Locale;
import java.util.Scanner;

// Завдання 1
public class Task1FuelCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // щоб дробові числа вводились через крапку
        scanner.useLocale(Locale.US);

        System.out.println("=== КАЛЬКУЛЯТОР ПОЇЗДКИ ТА ПАЛЬНОГО ===");
        System.out.print("Введіть відстань поїздки (км): ");
        double distance = scanner.nextDouble();
        System.out.print("Введіть середню витрату на 100 км (л): ");
        double fuelConsumption = scanner.nextDouble();
        System.out.print("Оберіть тип пального (1 - А-95, 2 - Дизель, 3 - Газ): ");
        int fuelType = scanner.nextInt();

        // перевірка вхідних даних
        if (distance <= 0 || fuelConsumption <= 0) {
            System.out.println("Помилка: відстань і витрата пального мають бути більшими за нуль!");
            scanner.close();
            return;
        }

        // ціна та назва пального залежно від типу
        double pricePerLiter;
        String fuelName;
        switch (fuelType) {
            case 1:
                pricePerLiter = 56.50;
                fuelName = "Бензин А-95";
                break;
            case 2:
                pricePerLiter = 52.80;
                fuelName = "Дизель";
                break;
            case 3:
                pricePerLiter = 29.40;
                fuelName = "Газ";
                break;
            default:
                System.out.println("Помилка: невідомий тип пального!");
                scanner.close();
                return;
        }

        double neededFuel = distance * fuelConsumption / 100.0;
        double baseCost = neededFuel * pricePerLiter;

        // знижка 5% якщо вартість від 2000 грн
        double finalCost = (baseCost >= 2000.0) ? baseCost * 0.95 : baseCost;
        double discount = baseCost - finalCost;
        String discountPercent = (baseCost >= 2000.0) ? "5%" : "0%";

        System.out.println();
        System.out.println("---------------- ЗВІТ ПОЇЗДКИ ----------------");
        System.out.printf(Locale.US, "Обране пальне:               %s (%.2f грн/л)%n", fuelName, pricePerLiter);
        System.out.printf(Locale.US, "Необхідно пального:          %.2f л%n", neededFuel);
        System.out.printf(Locale.US, "Базова вартість:             %.2f грн%n", baseCost);
        System.out.printf(Locale.US, "Знижка АЗС (%s):             %.2f грн%n", discountPercent, discount);
        System.out.println("----------------------------------------------");
        System.out.printf(Locale.US, "Підсумкова сума до сплати:   %.2f грн%n", finalCost);
        System.out.println("==============================================");

        scanner.close();
    }
}
