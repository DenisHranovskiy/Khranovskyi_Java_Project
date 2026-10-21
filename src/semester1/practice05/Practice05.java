package semester1.practice05;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Practice05 {
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
        int[] numbers = new int[5];

        // Спочатку всі елементи нулі
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        numbers[0] = 10;
        numbers[2] = 30;
        numbers[numbers.length - 1] = 50;

        System.out.println(Arrays.toString(numbers));
    }

    // Завдання 2
    static void task2() {
        System.out.println("=== Завдання 2 ===");
        String[] days = {"Понеділок", "Вівторок", "Середа", "Четвер", "П'ятниця", "Субота", "Неділя"};

        System.out.println("Кількість днів: " + days.length);
        System.out.println("Перший день: " + days[0]);
        System.out.println("Останній день: " + days[days.length - 1]);

        // Субота має індекс 5, неділя - 6
        days[5] = "Вихідний (Сб)";
        days[6] = "Вихідний (Нд)";

        System.out.println(Arrays.toString(days));
    }

    // Завдання 3
    static void task3() {
        System.out.println("=== Завдання 3 ===");
        double[] prices = {120.50, 45.00, 890.99, 15.30, 420.00};

        System.out.println("Початкові ціни: " + Arrays.toString(prices));

        // Знижка 20% на найдорожчий товар
        prices[2] = prices[2] * 0.8;

        System.out.println("Ціни після знижки: " + Arrays.toString(prices));
    }

    // Завдання 4
    static void task4() {
        System.out.println("=== Завдання 4 ===");
        System.out.print("Введіть N (N > 0): ");
        int n = scanner.nextInt();
        scanner.nextLine();

        if (n <= 0) {
            System.out.println("N має бути більше нуля");
            return;
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        System.out.println(Arrays.toString(arr));
    }

    // Завдання 5
    static void task5() {
        System.out.println("=== Завдання 5 ===");
        int[] arr = {4, 8, 15, 16, 23, 42};

        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i]);
            if (i > 0) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    // Завдання 6
    static void task6() {
        System.out.println("=== Завдання 6 ===");
        int[] powers = new int[10];

        powers[0] = 1;
        for (int i = 1; i < powers.length; i++) {
            powers[i] = powers[i - 1] * 2;
        }

        System.out.println(Arrays.toString(powers));
    }

    // Завдання 7
    static void task7() {
        System.out.println("=== Завдання 7 ===");
        int[] original = {3, 7, 1, 9, 4};
        int[] copy = new int[original.length];

        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i];
        }

        copy[0] = 999;

        System.out.println("original: " + Arrays.toString(original));
        System.out.println("copy:     " + Arrays.toString(copy));
        System.out.println("Масиви незалежні: зміна copy не вплинула на original");
    }

    // Завдання 8
    static void task8() {
        System.out.println("=== Завдання 8 ===");
        int[] grades = {95, 84, 70, 99, 65, 88, 92};

        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }

        double average = (double) sum / grades.length;

        System.out.println("Сума: " + sum + ", Середній бал: " + average);
    }

    // Завдання 9
    static void task9() {
        System.out.println("=== Завдання 9 ===");
        int[] temps = {18, 21, 15, 24, 13, 27, 20};
        String[] days = {"Понеділок", "Вівторок", "Середа", "Четвер", "П'ятниця", "Субота", "Неділя"};

        int min = temps[0];
        int max = temps[0];
        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 1; i < temps.length; i++) {
            if (temps[i] < min) {
                min = temps[i];
                minIndex = i;
            }
            if (temps[i] > max) {
                max = temps[i];
                maxIndex = i;
            }
        }

        System.out.println("Мінімальна температура: " + min + " (індекс " + minIndex + ", " + days[minIndex] + ")");
        System.out.println("Максимальна температура: " + max + " (індекс " + maxIndex + ", " + days[maxIndex] + ")");
    }

    // Завдання 10
    static void task10() {
        System.out.println("=== Завдання 10 ===");
        int[] data = {12, -5, 0, 43, -19, 0, -2, 8, 0, 15};

        int positive = 0;
        int negative = 0;
        int zeros = 0;

        for (int value : data) {
            if (value > 0) {
                positive++;
            } else if (value < 0) {
                negative++;
            } else {
                zeros++;
            }
        }

        System.out.println("Додатних: " + positive);
        System.out.println("Від'ємних: " + negative);
        System.out.println("Нульових: " + zeros);
    }

    // Завдання 11
    static void task11() {
        System.out.println("=== Завдання 11 ===");
        int[] numbers = {7, 12, 3, 28, 15, 40, 9, 22, 11, 6};

        int evenCount = 0;
        int oddSum = 0;

        for (int number : numbers) {
            if (number % 2 == 0) {
                evenCount++;
            } else {
                oddSum += number;
            }
        }

        System.out.println("Масив: " + Arrays.toString(numbers));
        System.out.println("Кількість парних чисел: " + evenCount);
        System.out.println("Сума непарних чисел: " + oddSum);
    }

    // Завдання 12
    static void task12() {
        System.out.println("=== Завдання 12 ===");
        int[] students = {1042, 2031, 3055, 4018, 5099};

        System.out.print("Введіть номер залікової книжки: ");
        int target = scanner.nextInt();
        scanner.nextLine();

        int foundIndex = -1;
        for (int i = 0; i < students.length; i++) {
            if (students[i] == target) {
                foundIndex = i;
                break;
            }
        }

        if (foundIndex != -1) {
            System.out.println("Номер знайдено на позиції " + foundIndex);
        } else {
            System.out.println("Студента з таким номером не знайдено");
        }
    }

    // Завдання 13
    static void task13() {
        System.out.println("=== Завдання 13 ===");
        int[] rolls = {3, 6, 2, 6, 1, 4, 6, 5, 2, 6};

        System.out.print("Введіть число від 1 до 6: ");
        int number = scanner.nextInt();
        scanner.nextLine();

        int count = 0;
        for (int roll : rolls) {
            if (roll == number) {
                count++;
            }
        }

        System.out.println("Число " + number + " випало " + count + " раз(и)");
    }

    // Завдання 14
    static void task14() {
        System.out.println("=== Завдання 14 ===");
        int[] salaries = {18000, 25000, 32000, 15000, 41000, 29000};

        int sum = 0;
        for (int salary : salaries) {
            sum += salary;
        }
        double average = (double) sum / salaries.length;
        System.out.println("Середня зарплата: " + average);

        System.out.println("Зарплати вище середньої:");
        for (int salary : salaries) {
            if (salary > average) {
                System.out.println(salary);
            }
        }
    }

    // Завдання 15
    static void task15() {
        System.out.println("=== Завдання 15 ===");
        double[] prices = {42.5, 41.8, 44.1, 40.9, 43.6, 45.0};

        double min = prices[0];
        double max = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            if (prices[i] > max) {
                max = prices[i];
            }
        }

        double range = max - min;
        System.out.printf(java.util.Locale.US, "Розмах коливань цін: %.2f%n", range);
    }

    // Завдання 16
    static void task16() {
        System.out.println("=== Завдання 16 ===");
        String[] cities = {"Київ", "Львів", "Харків", "Одеса", "Дніпро"};

        for (String city : cities) {
            System.out.println("Ласкаво просимо до міста " + city + "!");
        }
    }

    // Завдання 17
    static void task17() {
        System.out.println("=== Завдання 17 ===");
        double[] salaries = {20000.0, 25000.0, 18000.0, 30000.0};

        for (int i = 0; i < salaries.length; i++) {
            salaries[i] *= 1.10;
        }

        System.out.println(Arrays.toString(salaries));
    }

    // Завдання 18
    static void task18() {
        System.out.println("=== Завдання 18 ===");
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println("До: " + Arrays.toString(arr));

        // Міняємо місцями елементи з обох кінців до середини
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }

        System.out.println("Після: " + Arrays.toString(arr));
    }

    // Завдання 19
    static void task19() {
        System.out.println("=== Завдання 19 ===");
        int[] base = {2, 4, 6, 8, 10};
        int[] squares = new int[base.length];

        for (int i = 0; i < base.length; i++) {
            squares[i] = base[i] * base[i];
        }

        System.out.println("base:    " + Arrays.toString(base));
        System.out.println("squares: " + Arrays.toString(squares));
    }

    // Завдання 20
    static void task20() {
        System.out.println("=== Завдання 20 ===");
        int[] arr = {2, 5, 5, 9, 14, 20};

        boolean isSorted = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                isSorted = false;
                break;
            }
        }

        System.out.println("Масив: " + Arrays.toString(arr));
        if (isSorted) {
            System.out.println("Масив відсортований за зростанням");
        } else {
            System.out.println("Масив НЕ відсортований за зростанням");
        }
    }

    // Завдання 21
    static void task21() {
        System.out.println("=== Завдання 21 ===");
        int[] a = {1, 2, 3};
        int[] b = {4, 5, 6, 7};
        int[] c = new int[a.length + b.length];

        for (int i = 0; i < a.length; i++) {
            c[i] = a[i];
        }
        // Елементи b йдуть після елементів a
        for (int i = 0; i < b.length; i++) {
            c[a.length + i] = b[i];
        }

        System.out.println(Arrays.toString(c));
    }

    // Завдання 22
    static void task22() {
        System.out.println("=== Завдання 22 ===");
        int[] test = {45, 12, 89, 3, 27};
        System.out.println("Початковий: " + Arrays.toString(test));

        Arrays.sort(test);
        System.out.println("Відсортований: " + Arrays.toString(test));

        Arrays.fill(test, -1);
        System.out.println("Після fill: " + Arrays.toString(test));
    }

    // Завдання 23
    static void task23() {
        System.out.println("=== Завдання 23 ===");
        int[][] table = new int[3][3];

        // Заповнюємо числами, кратними 5
        for (int row = 0; row < table.length; row++) {
            for (int col = 0; col < table[row].length; col++) {
                table[row][col] = (row * 3 + col + 1) * 5;
            }
        }

        for (int row = 0; row < table.length; row++) {
            for (int col = 0; col < table[row].length; col++) {
                System.out.print(table[row][col] + "\t");
            }
            System.out.println();
        }
    }

    // Завдання 24
    static void task24() {
        System.out.println("=== Завдання 24 ===");
        int[][] matrix = {
            {10, 20, 30, 40},
            {50, 60, 70, 80}
        };

        int rows = matrix.length;
        int cols = matrix[0].length;

        System.out.println("Кількість рядків: " + rows);
        System.out.println("Кількість стовпчиків: " + cols);
        System.out.println("Лівий верхній: " + matrix[0][0]);
        System.out.println("Правий верхній: " + matrix[0][cols - 1]);
        System.out.println("Лівий нижній: " + matrix[rows - 1][0]);
        System.out.println("Правий нижній: " + matrix[rows - 1][cols - 1]);
    }

    // Завдання 25
    static void task25() {
        System.out.println("=== Завдання 25 ===");
        int[][] grid = new int[3][4];
        int counter = 1;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                grid[row][col] = counter;
                counter++;
            }
        }

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                System.out.print(grid[row][col] + "\t");
            }
            System.out.println();
        }
    }

    // Завдання 26
    static void task26() {
        System.out.println("=== Завдання 26 ===");
        int[][] randomGrid = new int[4][3];

        for (int row = 0; row < randomGrid.length; row++) {
            for (int col = 0; col < randomGrid[row].length; col++) {
                randomGrid[row][col] = (int) (Math.random() * 90) + 10;
            }
        }

        System.out.println("Через deepToString:");
        System.out.println(Arrays.deepToString(randomGrid));

        System.out.println("Таблицею:");
        for (int row = 0; row < randomGrid.length; row++) {
            for (int col = 0; col < randomGrid[row].length; col++) {
                System.out.print(randomGrid[row][col] + "\t");
            }
            System.out.println();
        }
    }

    // Завдання 27
    static void task27() {
        System.out.println("=== Завдання 27 ===");
        int[][] multTable = new int[9][9];

        for (int i = 0; i < multTable.length; i++) {
            for (int j = 0; j < multTable[i].length; j++) {
                multTable[i][j] = (i + 1) * (j + 1);
            }
        }

        // Ширина 4 символи для рівних стовпчиків
        for (int i = 0; i < multTable.length; i++) {
            for (int j = 0; j < multTable[i].length; j++) {
                System.out.printf("%4d", multTable[i][j]);
            }
            System.out.println();
        }
    }

    // Завдання 28
    static void task28() {
        System.out.println("=== Завдання 28 ===");
        int[][] identity = new int[5][5];

        for (int row = 0; row < identity.length; row++) {
            for (int col = 0; col < identity[row].length; col++) {
                if (row == col) {
                    identity[row][col] = 1;
                } else {
                    identity[row][col] = 0;
                }
            }
        }

        for (int row = 0; row < identity.length; row++) {
            for (int col = 0; col < identity[row].length; col++) {
                System.out.print(identity[row][col] + " ");
            }
            System.out.println();
        }
    }

    // Завдання 29
    static void task29() {
        System.out.println("=== Завдання 29 ===");
        int[][] matrix = new int[4][4];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = 1;
            }
        }

        // Рядок з індексом 1 обнуляємо
        for (int col = 0; col < matrix[1].length; col++) {
            matrix[1][col] = 0;
        }
        // У стовпчик з індексом 2 записуємо 7
        for (int row = 0; row < matrix.length; row++) {
            matrix[row][2] = 7;
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    // Завдання 30
    static void task30() {
        System.out.println("=== Завдання 30 ===");
        int[][] matrix = {
            {4, 9, 2},
            {7, 1, 8},
            {5, 6, 3}
        };

        int sum = 0;
        int count = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                sum += matrix[row][col];
                count++;
            }
        }

        double average = (double) sum / count;

        System.out.println("Сума всіх елементів: " + sum);
        System.out.println("Кількість елементів: " + count);
        System.out.println("Середнє арифметичне: " + average);
    }

    // Завдання 31
    static void task31() {
        System.out.println("=== Завдання 31 ===");
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };
        int[] rowSums = new int[3];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                rowSums[row] += matrix[row][col];
            }
        }

        for (int row = 0; row < rowSums.length; row++) {
            System.out.print("Рядок " + row + ": сума = " + rowSums[row]);
            if (row < rowSums.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    // Завдання 32
    static void task32() {
        System.out.println("=== Завдання 32 ===");
        int[][] matrix = {
            {3, 8, 1},
            {4, 2, 9},
            {6, 5, 7}
        };
        int[] colSums = new int[matrix[0].length];

        // Зовнішній цикл - стовпчики, внутрішній - рядки
        for (int col = 0; col < colSums.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                colSums[col] += matrix[row][col];
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + "\t");
            }
            System.out.println();
        }
        System.out.println("---------------------");
        for (int col = 0; col < colSums.length; col++) {
            System.out.print(colSums[col] + "\t");
        }
        System.out.println();
    }

    // Завдання 33
    static void task33() {
        System.out.println("=== Завдання 33 ===");
        int[][] matrix = {
            {-7, 12, 3, -20},
            {45, -1, 8, 19},
            {0, 33, -15, 27}
        };

        int max = matrix[0][0];
        int maxRow = 0;
        int maxCol = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] > max) {
                    max = matrix[row][col];
                    maxRow = row;
                    maxCol = col;
                }
            }
        }

        System.out.println("Максимум: " + max + " у комірці [" + maxRow + ", " + maxCol + "]");
    }

    // Завдання 34
    static void task34() {
        System.out.println("=== Завдання 34 ===");
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        int mainSum = 0;
        int secondarySum = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (row == col) {
                    mainSum += matrix[row][col];
                }
                if (row + col == matrix.length - 1) {
                    secondarySum += matrix[row][col];
                }
            }
        }

        System.out.println("Сума головної діагоналі: " + mainSum);
        System.out.println("Сума побічної діагоналі: " + secondarySum);

        if (mainSum > secondarySum) {
            System.out.println("Сума головної діагоналі більша");
        } else if (mainSum < secondarySum) {
            System.out.println("Сума побічної діагоналі більша");
        } else {
            System.out.println("Суми діагоналей рівні");
        }
    }

    // Завдання 35
    static void task35() {
        System.out.println("=== Завдання 35 ===");
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int[][] transposed = new int[3][3];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }

        System.out.println("Початкова\tТранспонована");
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.print("\t\t");
            for (int col = 0; col < transposed[row].length; col++) {
                System.out.print(transposed[row][col] + " ");
            }
            System.out.println();
        }
    }

    // Завдання 36
    static void task36() {
        System.out.println("=== Завдання 36 ===");
        int[][] ladder = new int[4][];

        // Рядок i має i + 1 елемент
        for (int i = 0; i < ladder.length; i++) {
            ladder[i] = new int[i + 1];
            for (int j = 0; j < ladder[i].length; j++) {
                ladder[i][j] = i;
            }
        }

        for (int i = 0; i < ladder.length; i++) {
            for (int j = 0; j < ladder[i].length; j++) {
                System.out.print(ladder[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Завдання 37
    static void task37() {
        System.out.println("=== Завдання 37 ===");
        String[] dayNames = {"Понеділок", "Вівторок", "Середа", "Четвер", "П'ятниця"};
        String[][] weekSchedule = new String[5][];

        weekSchedule[0] = new String[]{"Вища математика", "Основи програмування", "Фізика"};
        weekSchedule[1] = new String[]{"Англійська мова", "Історія України"};
        weekSchedule[2] = new String[]{"Основи програмування", "Основи програмування", "Бази даних", "Фізвиховання"};
        weekSchedule[3] = new String[]{"Дискретна математика"};
        weekSchedule[4] = new String[]{"Філософія", "Основи алгоритмізації", "Практикум"};

        for (int i = 0; i < weekSchedule.length; i++) {
            System.out.println(dayNames[i] + " (пар: " + weekSchedule[i].length + "):");
            for (int j = 0; j < weekSchedule[i].length; j++) {
                System.out.println("  " + (j + 1) + ". " + weekSchedule[i][j]);
            }
        }
    }

    // Завдання 38
    static void task38() {
        System.out.println("=== Завдання 38 ===");
        int[][] pascal = new int[5][];

        for (int i = 0; i < pascal.length; i++) {
            pascal[i] = new int[i + 1];
            pascal[i][0] = 1;
            pascal[i][i] = 1;
            // Проміжні елементи - сума двох елементів над ним
            for (int j = 1; j < i; j++) {
                pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
            }
        }

        for (int i = 0; i < pascal.length; i++) {
            for (int j = 0; j < pascal[i].length; j++) {
                System.out.print(pascal[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Завдання 39
    static void task39() {
        System.out.println("=== Завдання 39 ===");
        int[][][] cube = new int[3][3][3];

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                for (int z = 0; z < 3; z++) {
                    cube[x][y][z] = x + y + z;
                }
            }
        }

        for (int x = 0; x < cube.length; x++) {
            System.out.println("--- Шар " + x + " ---");
            for (int y = 0; y < cube[x].length; y++) {
                for (int z = 0; z < cube[x][y].length; z++) {
                    System.out.print(cube[x][y][z] + " ");
                }
                System.out.println();
            }
        }
    }

    // Завдання 40
    static void task40() {
        System.out.println("=== Завдання 40 ===");
        String[] cities = {"Київ", "Львів", "Одеса"};
        // [місто][день][0 - день, 1 - ніч]
        double[][][] weather = {
            {{18.5, 9.0}, {19.0, 10.5}, {20.5, 11.0}, {17.0, 8.5}, {16.5, 7.0}, {21.0, 12.0}, {22.0, 13.5}},
            {{16.0, 7.5}, {15.5, 6.0}, {17.5, 8.0}, {14.0, 5.5}, {13.5, 4.0}, {18.0, 9.5}, {19.5, 10.0}},
            {{23.0, 15.0}, {24.5, 16.5}, {25.0, 17.0}, {22.5, 14.0}, {21.0, 13.0}, {26.0, 18.0}, {27.0, 19.5}}
        };

        System.out.println("Середня денна температура за тиждень:");
        for (int city = 0; city < weather.length; city++) {
            double sum = 0;
            for (int day = 0; day < weather[city].length; day++) {
                sum += weather[city][day][0];
            }
            double average = sum / weather[city].length;
            System.out.printf(java.util.Locale.US, "%s: %.1f°C%n", cities[city], average);
        }

        double coldest = weather[0][0][1];
        int coldCity = 0;
        int coldDay = 0;
        for (int city = 0; city < weather.length; city++) {
            for (int day = 0; day < weather[city].length; day++) {
                if (weather[city][day][1] < coldest) {
                    coldest = weather[city][day][1];
                    coldCity = city;
                    coldDay = day;
                }
            }
        }
        System.out.println("Найхолодніша ніч: " + coldest + "°C (" + cities[coldCity] + ", день " + (coldDay + 1) + ")");
    }
}
