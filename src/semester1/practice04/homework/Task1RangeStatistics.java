package semester1.practice04.homework;

import java.util.Locale;
import java.util.Scanner;

// Завдання 1
public class Task1RangeStatistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== АНАЛІЗАТОР ДІАПАЗОНУ ЧИСЕЛ ===");

        // просимо N, доки не буде додатним
        int n;
        do {
            System.out.print("Введіть число N: ");
            n = scanner.nextInt();
            if (n <= 0) {
                System.out.println("Помилка: N має бути більшим за 0!");
            }
        } while (n <= 0);

        long totalSum = 0;
        long evenSum = 0;
        long oddSum = 0;
        int evenCount = 0;
        int oddCount = 0;

        for (int i = 1; i <= n; i++) {
            totalSum += i;
            if (i % 2 == 0) {
                evenSum += i;
                evenCount++;
            } else {
                oddSum += i;
                oddCount++;
            }
        }

        // (double), щоб не відкинути дробову частину
        double average = (double) totalSum / n;

        System.out.println();
        System.out.println("--- РЕЗУЛЬТАТИ ДЛЯ ДІАПАЗОНУ [1 .. " + n + "] ---");
        System.out.println("Загальна сума чисел:       " + totalSum);
        System.out.println("Сума парних чисел:         " + evenSum + " (кількість: " + evenCount + ")");
        System.out.println("Сума непарних чисел:       " + oddSum + " (кількість: " + oddCount + ")");
        System.out.printf(Locale.US, "Середнє арифметичне:       %.2f%n", average);
        System.out.println("=========================================");

        scanner.close();
    }
}
