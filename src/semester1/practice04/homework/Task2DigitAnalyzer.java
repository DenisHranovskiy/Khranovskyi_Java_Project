package semester1.practice04.homework;

import java.util.Scanner;

// Завдання 2
public class Task2DigitAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== АНАЛІЗАТОР РОЗРЯДІВ ЧИСЛА ===");
        int number;
        do {
            System.out.print("Введіть додатне ціле число: ");
            number = scanner.nextInt();
            if (number <= 0) {
                System.out.println("Число має бути додатним!");
            }
        } while (number <= 0);

        // число змінюємо в циклі, тому початкове зберігаємо окремо
        int originalNumber = number;
        int temp = number;
        int digitCount = 0;
        int digitSum = 0;
        int maxDigit = 0;
        long reversedNumber = 0; // long, бо реверс великого числа може не влізти в int

        while (temp > 0) {
            int digit = temp % 10; // остання цифра
            digitCount++;
            digitSum += digit;
            if (digit > maxDigit) {
                maxDigit = digit;
            }
            reversedNumber = reversedNumber * 10 + digit;
            temp /= 10;
        }

        System.out.println();
        System.out.println("--- СТАТИСТИКА ЧИСЛА ---");
        System.out.println("Початкове число:     " + originalNumber);
        System.out.println("Кількість цифр:      " + digitCount);
        System.out.println("Сума цифр:           " + digitSum);
        System.out.println("Найбільша цифра:     " + maxDigit);
        System.out.println("Перевернуте число:   " + reversedNumber);

        if (originalNumber == reversedNumber) {
            System.out.println("Результат:           ✨ Це число є ПАЛІНДРОМОМ!");
        } else {
            System.out.println("Результат:           Це звичайне число (не паліндром).");
        }
        System.out.println("================================");

        scanner.close();
    }
}
