package semester1.practice05.homework;

import java.util.Locale;
import java.util.Scanner;

// Завдання 2
public class Task2WarehouseInventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // паралельні масиви: з однаковим індексом - дані одного товару
        String[] items = {"Ноутбук", "Смартфон", "Бездротові навушники", "Механічна клавіатура", "Монітор 27\""};
        int[] quantities = {8, 3, 25, 4, 12};
        double[] prices = {28500.0, 19200.0, 1850.0, 3100.0, 9400.0};

        // вартість залишку кожного товару
        double[] totalValues = new double[items.length];
        for (int i = 0; i < items.length; i++) {
            totalValues[i] = quantities[i] * prices[i];
        }

        System.out.println("=================== ЗВІТ СКЛАДУ ЕЛЕКТРОНІКИ ===================");
        System.out.println("№ | Назва товару            | К-сть | Ціна (грн) | Загальна вартість");
        System.out.println("----------------------------------------------------------------");
        double warehouseTotal = 0;
        int maxIndex = 0;
        for (int i = 0; i < items.length; i++) {
            System.out.printf(Locale.US, "%d | %-24s| %-6s| %-11s| %.2f грн%n",
                    i + 1, items[i], quantities[i] + " шт.", String.format(Locale.US, "%.2f", prices[i]), totalValues[i]);
            warehouseTotal += totalValues[i];
            // шукаємо позицію з найбільшою сумою
            if (totalValues[i] > totalValues[maxIndex]) {
                maxIndex = i;
            }
        }
        System.out.println("----------------------------------------------------------------");
        System.out.printf(Locale.US, "Загальна вартість складу: %.2f грн%n", warehouseTotal);
        System.out.printf(Locale.US, "Найбільший капітал у товарі: %s (%.2f грн)%n", items[maxIndex], totalValues[maxIndex]);

        System.out.println();
        System.out.println("🚨 ДЕФІЦИТНІ ПОЗИЦІЇ (менше 5 шт.):");
        boolean hasDeficit = false;
        for (int i = 0; i < items.length; i++) {
            if (quantities[i] < 5) {
                System.out.println("- " + items[i] + " (залишилось: " + quantities[i] + " шт.) -> ⚠️ Терміново дозамовити!");
                hasDeficit = true;
            }
        }
        if (!hasDeficit) {
            System.out.println("Дефіцитних позицій немає");
        }
        System.out.println("================================================================");

        scanner.close();
    }
}
