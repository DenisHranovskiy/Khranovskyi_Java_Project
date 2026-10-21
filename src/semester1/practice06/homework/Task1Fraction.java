package semester1.practice06.homework;

// Завдання 1
public class Task1Fraction {

    public static void main(String[] args) {
        System.out.println("=== КАЛЬКУЛЯТОР ЗВИЧАЙНИХ ДРОБІВ ===");

        Fraction f = new Fraction();
        f.setValues(8, 12);
        System.out.print("Дріб 1: ");
        f.printFraction();

        f.simplify();
        System.out.printf(java.util.Locale.US, "Після скорочення: %d/%d (десятковий вигляд: %.4f)%n",
                f.getNumerator(), f.getDenominator(), f.toDecimal());

        // запам'ятовуємо старі значення для виводу формули
        int a = f.getNumerator();
        int b = f.getDenominator();
        int c = 3;
        int d = 4;

        System.out.println();
        System.out.println("Додаємо дріб " + c + "/" + d + " до " + a + "/" + b + "...");
        f.add(c, d);
        System.out.println("Формула: " + a + "/" + b + " + " + c + "/" + d + " = (" + a + "*" + d
                + " + " + c + "*" + b + ") / (" + b + "*" + d + ") = " + f.getNumerator() + "/" + f.getDenominator());
        System.out.printf(java.util.Locale.US, "Результат додавання: %d/%d (десятковий вигляд: %.4f)%n",
                f.getNumerator(), f.getDenominator(), f.toDecimal());

        // ще кілька перевірок
        System.out.println();
        Fraction g = new Fraction();
        g.setValues(1, -2);
        System.out.print("Дріб 1/(-2) після виправлення знака: ");
        g.printFraction();

        g.add(1, 2);
        System.out.print("-1/2 + 1/2 = ");
        g.printFraction();

        Fraction h = new Fraction();
        h.setValues(5, 0);
        System.out.print("Дріб після помилки: ");
        h.printFraction();
        System.out.println("=====================================");
    }
}

class Fraction {
    private int numerator;
    private int denominator;

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setValues(int num, int den) {
        if (den == 0) {
            System.out.println("Помилка: знаменник не може дорівнювати 0!");
            numerator = num;
            denominator = 1;
        } else if (den < 0) {
            // мінус переносимо в чисельник
            numerator = -num;
            denominator = -den;
        } else {
            numerator = num;
            denominator = den;
        }
    }

    // НСД за алгоритмом Евкліда
    private int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public void simplify() {
        int g = gcd(numerator, denominator);
        if (g != 0) {
            numerator = numerator / g;
            denominator = denominator / g;
        }
    }

    public double toDecimal() {
        return (double) numerator / denominator;
    }

    public void add(int otherNum, int otherDen) {
        if (otherDen == 0) {
            System.out.println("Помилка: знаменник не може дорівнювати 0!");
            return;
        }
        if (otherDen < 0) {
            otherNum = -otherNum;
            otherDen = -otherDen;
        }
        numerator = numerator * otherDen + otherNum * denominator;
        denominator = denominator * otherDen;
        simplify();
    }

    public void printFraction() {
        if (denominator == 1) {
            System.out.println(numerator);
        } else {
            System.out.println(numerator + "/" + denominator);
        }
    }
}
