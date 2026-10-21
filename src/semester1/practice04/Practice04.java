package semester1.practice04;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Practice04 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        scanner.useLocale(Locale.US);
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
        task8();
        task9();
        task10();
        task11();
        task12();
        task13();
        task14();
        task15();
        task16();
        task17();
        task18();
        task19();
        task20();
        task21();
        task22();
        task23();
        task24();
        task25();
        task26();
        task27();
        task28();
        task29();
        task30();
        task31();
        task32();
        task33();
        task34();
        task35();
        task36();
        task37();
        task38();
        task39();
        task40();
        scanner.close();
    }

    // Завдання 1
    static void task1() {
        System.out.println("=== Завдання 1 ===");
        for (int i = 0; i < 7; i++) {
            System.out.println("Java - надійна та кросплатформна мова!");
        }
    }

    // Завдання 2
    static void task2() {
        System.out.println("=== Завдання 2 ===");
        System.out.print("Введіть рядок тексту: ");
        String text = scanner.nextLine();
        System.out.print("Скільки разів повторити (N >= 1): ");
        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("[" + i + "] " + text);
        }
    }

    // Завдання 3
    static void task3() {
        System.out.println("=== Завдання 3 ===");
        int balance = 0;

        // щомісяця просто додаємо 500, без множення
        for (int month = 1; month <= 12; month++) {
            balance += 500;
            System.out.println("Місяць " + month + ": " + balance + " грн");
        }
    }

    // Завдання 4
    static void task4() {
        System.out.println("=== Завдання 4 ===");
        System.out.print("Введіть курс євро до гривні: ");
        double rate = scanner.nextDouble();

        System.out.println("Євро | Гривні");
        for (int euro = 10; euro <= 100; euro += 10) {
            double uah = euro * rate;
            System.out.printf("%4d | %.2f грн%n", euro, uah);
        }
    }

    // Завдання 5
    static void task5() {
        System.out.println("=== Завдання 5 ===");
        System.out.print("Введіть ширину рамки W: ");
        int w = scanner.nextInt();

        for (int i = 0; i < w; i++) {
            System.out.print("=");
        }
        System.out.println();
    }

    // Завдання 6
    static void task6() {
        System.out.println("=== Завдання 6 ===");
        int count = 10;

        while (count >= 1) {
            System.out.println(count);
            count--;
        }

        System.out.println("Поїхали! Ракета запущена!");
    }

    // Завдання 7
    static void task7() {
        System.out.println("=== Завдання 7 ===");
        long sum = 0;

        System.out.println("Вводьте цілі числа (0 - кінець):");
        int number = scanner.nextInt();
        // нуль - сигнал зупинки
        while (number != 0) {
            sum += number;
            number = scanner.nextInt();
        }

        System.out.println("Сума введених чисел: " + sum);
    }

    // Завдання 8
    static void task8() {
        System.out.println("=== Завдання 8 ===");
        System.out.print("Введіть число M: ");
        long m = scanner.nextLong();

        System.out.println("Степені двійки, що не перевищують " + m + ":");
        long power = 1;
        while (power <= m) {
            System.out.print(power + " ");
            power *= 2;
        }
        System.out.println();
    }

    // Завдання 9
    static void task9() {
        System.out.println("=== Завдання 9 ===");
        System.out.print("Введіть додатне ціле число N: ");
        int n = scanner.nextInt();

        int temp = n;
        int digits = 0;
        int sum = 0;
        while (temp > 0) {
            sum += temp % 10; // остання цифра
            temp /= 10;       // відкидаємо її
            digits++;
        }

        System.out.println("Кількість цифр: " + digits);
        System.out.println("Сума цифр: " + sum);
    }

    // Завдання 10
    static void task10() {
        System.out.println("=== Завдання 10 ===");
        System.out.print("Введіть додатне число: ");
        int number = scanner.nextInt();

        int temp = number;
        long reversed = 0; // long, щоб великі числа не переповнились
        while (temp > 0) {
            reversed = reversed * 10 + temp % 10;
            temp /= 10;
        }

        System.out.println("Число у зворотному порядку: " + reversed);
    }

    // Завдання 11
    static void task11() {
        System.out.println("=== Завдання 11 ===");
        System.out.print("Введіть суму внеску S (грн): ");
        double start = scanner.nextDouble();
        System.out.print("Введіть відсоток річних P: ");
        double percent = scanner.nextDouble();

        double capital = start;
        int years = 0;
        // кожного року додаємо відсотки до капіталу
        while (capital < start * 2 && years < 100000) {
            capital += capital * percent / 100;
            years++;
        }

        if (capital >= start * 2) {
            System.out.printf("Сума подвоїться через %d р. (капітал: %.2f грн)%n", years, capital);
        } else {
            System.out.println("За такого відсотка сума не подвоїться.");
        }
    }

    // Завдання 12
    static void task12() {
        System.out.println("=== Завдання 12 ===");
        System.out.print("Введіть число N (N > 1): ");
        long n = scanner.nextLong();

        long divisor = 2;
        // шукаємо перше число, на яке N ділиться без остачі
        while (n % divisor != 0) {
            divisor++;
        }

        System.out.println("Найменший дільник числа " + n + " (крім 1): " + divisor);
    }

    // Завдання 13
    static void task13() {
        System.out.println("=== Завдання 13 ===");
        int secret = (int) (Math.random() * 100) + 1;
        int attempts = 0;
        int guess = 0;

        System.out.println("Я загадав число від 1 до 100. Спробуй вгадати!");
        while (guess != secret) {
            System.out.print("Ваша здогадка: ");
            guess = scanner.nextInt();
            attempts++;

            if (guess < secret) {
                System.out.println("Більше!");
            } else if (guess > secret) {
                System.out.println("Менше!");
            }
        }

        System.out.println("Вгадали! Кількість спроб: " + attempts);
    }

    // Завдання 14
    static void task14() {
        System.out.println("=== Завдання 14 ===");
        int choice;

        do {
            System.out.println();
            System.out.println("1. Розпочати нову гру");
            System.out.println("2. Завантажити збереження");
            System.out.println("3. Налаштування");
            System.out.println("0. Вихід");
            System.out.print("Ваш вибір: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Нова гра розпочата!");
                    break;
                case 2:
                    System.out.println("Збереження завантажено.");
                    break;
                case 3:
                    System.out.println("Відкриваємо налаштування...");
                    break;
                case 0:
                    System.out.println("До побачення!");
                    break;
                default:
                    System.out.println("Невірний пункт меню, спробуйте ще раз.");
            }
        } while (choice != 0);
    }

    // Завдання 15
    static void task15() {
        System.out.println("=== Завдання 15 ===");
        int age;

        do {
            System.out.print("Введіть ваш вік: ");
            age = scanner.nextInt();
            if (age < 1 || age > 120) {
                System.out.println("Некоректний вік! Допустимо від 1 до 120.");
            }
        } while (age < 1 || age > 120);

        System.out.println("Вік підтверджено: " + age);
    }

    // Завдання 16
    static void task16() {
        System.out.println("=== Завдання 16 ===");
        final int correctPin = 1234;
        int attempts = 0;
        boolean access = false;

        do {
            System.out.print("Введіть PIN-код: ");
            int pin = scanner.nextInt();
            attempts++;

            if (pin == correctPin) {
                access = true;
                System.out.println("Доступ надано");
            } else if (attempts < 3) {
                System.out.println("Невірний PIN. Залишилось спроб: " + (3 - attempts));
            }
        } while (!access && attempts < 3);

        if (!access) {
            System.out.println("Карту заблоковано!");
        }
    }

    // Завдання 17
    static void task17() {
        System.out.println("=== Завдання 17 ===");
        char answer;

        do {
            // просте обчислення - додавання двох чисел
            System.out.print("Введіть перше число: ");
            double a = scanner.nextDouble();
            System.out.print("Введіть друге число: ");
            double b = scanner.nextDouble();
            System.out.println("Сума: " + (a + b));

            System.out.println("Бажаєте продовжити? (y/n)");
            answer = scanner.next().charAt(0);
        } while (answer == 'y');

        System.out.println("Роботу завершено.");
    }

    // Завдання 18
    static void task18() {
        System.out.println("=== Завдання 18 ===");
        Random random = new Random();
        int attempts = 0;
        int dice1;
        int dice2;

        do {
            dice1 = random.nextInt(6) + 1;
            dice2 = random.nextInt(6) + 1;
            attempts++;
            System.out.println("Кидок " + attempts + ": " + dice1 + " і " + dice2);
        } while (dice1 != dice2);

        System.out.println("Випав дубль! Кількість кидків: " + attempts);
    }

    // Завдання 19
    static void task19() {
        System.out.println("=== Завдання 19 ===");
        System.out.print("Введіть чисельник: ");
        int numerator = scanner.nextInt();

        int denominator;
        do {
            System.out.print("Введіть знаменник (не нуль): ");
            denominator = scanner.nextInt();
            if (denominator == 0) {
                System.out.println("На нуль ділити не можна!");
            }
        } while (denominator == 0);

        // (double), щоб ділення не було цілочисельним
        double result = (double) numerator / denominator;
        System.out.println(numerator + " / " + denominator + " = " + result);
    }

    // Завдання 20
    static void task20() {
        System.out.println("=== Завдання 20 ===");
        int sum = 0;
        int count = 0;
        int score;

        System.out.println("Вводьте бали за тести (0-100), від'ємне число - кінець:");
        do {
            System.out.print("Бал: ");
            score = scanner.nextInt();

            if (score > 100) {
                System.out.println("Некоректний бал! Має бути від 0 до 100.");
                continue; // перепитуємо
            }
            if (score >= 0) {
                sum += score;
                count++;
            }
        } while (score >= 0);

        if (count > 0) {
            System.out.printf("Середній бал: %.2f%n", (double) sum / count);
        } else {
            System.out.println("Жодного балу не введено.");
        }
    }

    // Завдання 21
    static void task21() {
        System.out.println("=== Завдання 21 ===");
        System.out.print("Введіть A: ");
        int a = scanner.nextInt();
        System.out.print("Введіть B (B >= A): ");
        int b = scanner.nextInt();

        System.out.print("Парні числа від " + a + " до " + b + ": ");
        for (int i = a; i <= b; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    // Завдання 22
    static void task22() {
        System.out.println("=== Завдання 22 ===");
        System.out.print("Введіть N (0..20): ");
        int n = scanner.nextInt();

        long factorial = 1; // для N = 0 цикл не виконається, і буде 0! = 1
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }

        System.out.println(n + "! = " + factorial);
    }

    // Завдання 23
    static void task23() {
        System.out.println("=== Завдання 23 ===");
        System.out.printf("%-6s | %-8s | %-6s%n", "Число", "Квадрат", "Куб");
        System.out.println("-------+----------+-------");

        for (int i = 1; i <= 10; i++) {
            System.out.printf("%-6d | %-8d | %-6d%n", i, i * i, i * i * i);
        }
    }

    // Завдання 24
    static void task24() {
        System.out.println("=== Завдання 24 ===");
        System.out.println("Числа від 1 до 50, що не діляться ні на 3, ні на 5:");
        for (int i = 1; i <= 50; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                continue; // пропускаємо ці числа
            }
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // Завдання 25
    static void task25() {
        System.out.println("=== Завдання 25 ===");
        int found = -1;

        for (int i = 100; i <= 200; i++) {
            if (i % 13 == 0 && i % 7 == 0) {
                found = i;
                break; // перше знайдене - далі шукати не треба
            }
        }

        if (found != -1) {
            System.out.println("Перше число, що ділиться на 13 і на 7: " + found);
        } else {
            System.out.println("Такого числа в проміжку немає.");
        }
    }

    // Завдання 26
    static void task26() {
        System.out.println("=== Завдання 26 ===");
        for (char c = 'A'; c <= 'Z'; c++) {
            // (int) показує числовий код символу
            System.out.println(c + " - " + (int) c);
        }
    }

    // Завдання 27
    static void task27() {
        System.out.println("=== Завдання 27 ===");
        System.out.print("Введіть кількість елементів N: ");
        int n = scanner.nextInt();

        long sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                sum += i; // непарні додаємо
            } else {
                sum -= i; // парні віднімаємо
            }
        }

        System.out.println("S = " + sum);
    }

    // Завдання 28
    static void task28() {
        System.out.println("=== Завдання 28 ===");
        System.out.print("Введіть перший член a1: ");
        int a1 = scanner.nextInt();
        System.out.print("Введіть різницю d: ");
        int d = scanner.nextInt();
        System.out.print("Введіть кількість членів n: ");
        int n = scanner.nextInt();

        long sum = 0;
        int current = a1;
        System.out.print("Члени прогресії: ");
        for (int i = 1; i <= n; i++) {
            System.out.print(current + " ");
            sum += current;
            current += d;
        }
        System.out.println();
        System.out.println("Сума членів: " + sum);
    }

    // Завдання 29
    static void task29() {
        System.out.println("=== Завдання 29 ===");
        byte b = 125;

        for (int i = 1; i <= 6; i++) {
            b = (byte) (b + 1);
            System.out.println("Крок " + i + ": b = " + b);
        }

        // byte вміщує числа від -128 до 127. Після 127 додається 1, і виходить 128,
        // яке не влізає у 8 біт. У двійковому записі 10000000 старший біт - знак,
        // тому значення "перестрибує" на мінімальне -128 і далі йде вгору: -127, -126...
    }

    // Завдання 30
    static void task30() {
        System.out.println("=== Завдання 30 ===");
        System.out.print("Скільки чисел введете (N): ");
        int n = scanner.nextInt();

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            System.out.print("Число " + i + ": ");
            sum += scanner.nextInt();
        }

        if (n > 0) {
            double wrongAverage = sum / n;           // цілочисельне ділення, дріб губиться
            double rightAverage = (double) sum / n;  // точне середнє
            System.out.println("Сума: " + sum);
            System.out.println("Без приведення: " + wrongAverage);
            System.out.println("З приведенням (double): " + rightAverage);
        } else {
            System.out.println("Чисел немає.");
        }
    }

    // Завдання 31
    static void task31() {
        System.out.println("=== Завдання 31 ===");
        System.out.print("Введіть слово: ");
        String word = scanner.next();

        String encrypted = "";
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            encrypted += (char) (ch + 1); // зсув коду символу на 1
        }

        System.out.println("Зашифроване слово: " + encrypted);
    }

    // Завдання 32
    static void task32() {
        System.out.println("=== Завдання 32 ===");
        double[] prices = {19.99, 45.50, 12.10, 99.95, 3.40};

        int wholeSum = 0;
        double coinsSum = 0;
        for (int i = 0; i < prices.length; i++) {
            int whole = (int) prices[i];      // відкидаємо копійки
            wholeSum += whole;
            coinsSum += prices[i] - whole;    // те, що відкинули
        }

        System.out.println("Сума цілих гривень: " + wholeSum);
        System.out.printf("Сума відкинутих копійок: %.2f грн%n", coinsSum);
    }

    // Завдання 33
    static void task33() {
        System.out.println("=== Завдання 33 ===");
        for (int i = 1; i <= 50; i++) {
            int percent = (int) (((double) i / 50) * 100);
            System.out.println("Завантажено: " + percent + "%");
        }
    }

    // Завдання 34
    static void task34() {
        System.out.println("=== Завдання 34 ===");
        long bigNumber = 3_000_000_000L;
        int small = (int) bigNumber;

        System.out.println("long: " + bigNumber);
        System.out.println("int:  " + small);

        // максимум int - 2 147 483 647, а 3 000 000 000 більше за нього.
        // При приведенні відкидаються старші 32 біти, лишаються молодші,
        // а старший біт стає знаком мінус. Тому вийшло -1294967296 (число 3 000 000 000 - 2^32).
        // Початкове значення втрачено.
    }

    // Завдання 35
    static void task35() {
        System.out.println("=== Завдання 35 ===");
        System.out.println("Цикл з double-лічильником:");
        for (double d = 0.0; d <= 1.0; d += 0.1) {
            System.out.println(d);
        }
        // 0.1 не можна точно записати у двійковому форматі, похибка накопичується,
        // тому 1.0 не виводиться (виходить 0.9999999999999999, а потім вже більше за 1.0)

        System.out.println();
        System.out.println("Цикл з int-лічильником:");
        for (int i = 0; i <= 10; i++) {
            double val = i / 10.0;
            System.out.println(val);
        }
    }

    // Завдання 36
    static void task36() {
        System.out.println("=== Завдання 36 ===");
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.printf("%4d", i * j);
            }
            System.out.println();
        }
    }

    // Завдання 37
    static void task37() {
        System.out.println("=== Завдання 37 ===");
        System.out.print("Введіть висоту H: ");
        int h = scanner.nextInt();
        System.out.print("Введіть ширину W: ");
        int w = scanner.nextInt();

        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                // зірочка по краях, пробіл всередині
                if (i == 1 || i == h || j == 1 || j == w) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    // Завдання 38
    static void task38() {
        System.out.println("=== Завдання 38 ===");
        System.out.print("Введіть висоту N: ");
        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // Завдання 39
    static void task39() {
        System.out.println("=== Завдання 39 ===");
        System.out.print("Введіть N: ");
        int n = scanner.nextInt();

        System.out.print("Прості числа від 2 до " + n + ": ");
        for (int number = 2; number <= n; number++) {
            boolean isPrime = true;
            for (int d = 2; d * d <= number; d++) {
                if (number % d == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.print(number + " ");
            }
        }
        System.out.println();
    }

    // Завдання 40
    static void task40() {
        System.out.println("=== Завдання 40 ===");
        System.out.print("Введіть розмір дошки N: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // клітинки чергуються за сумою індексів
                if ((i + j) % 2 == 0) {
                    System.out.print("#");
                } else {
                    System.out.print("_");
                }
                if (j < n - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
