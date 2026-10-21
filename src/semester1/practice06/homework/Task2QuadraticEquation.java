package semester1.practice06.homework;

// Завдання 2
public class Task2QuadraticEquation {

    public static void main(String[] args) {
        System.out.println("=== РОЗВ'ЯЗУВАЧ КВАДРАТНИХ РІВНЯНЬ ===");

        // два корені
        System.out.println("Тест 1:");
        QuadraticEquation eq1 = new QuadraticEquation();
        eq1.setCoefficients(1, -5, 6);
        eq1.printSolution();
        System.out.println("--------------------------------------");

        // один корінь
        System.out.println("Тест 2:");
        QuadraticEquation eq2 = new QuadraticEquation();
        eq2.setCoefficients(1, -4, 4);
        eq2.printSolution();
        System.out.println("--------------------------------------");

        // коренів немає
        System.out.println("Тест 3:");
        QuadraticEquation eq3 = new QuadraticEquation();
        eq3.setCoefficients(1, 2, 5);
        eq3.printSolution();
        System.out.println("--------------------------------------");

        // перевірка валідації коефіцієнта a
        System.out.println("Тест 4 (a = 0):");
        QuadraticEquation eq4 = new QuadraticEquation();
        eq4.setCoefficients(0, 3, -2);
        eq4.printSolution();
        System.out.println("======================================");
    }
}

class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public void setCoefficients(double a, double b, double c) {
        if (a == 0) {
            System.out.println("Увага: коефіцієнт 'a' не може дорівнювати 0 (це лінійне рівняння)!");
            a = 1.0;
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getDiscriminant() {
        return b * b - 4 * a * c;
    }

    public boolean hasRealRoots() {
        return getDiscriminant() >= 0;
    }

    public double getRoot1() {
        double d = getDiscriminant();
        if (d < 0) {
            return Double.NaN;
        }
        return (-b + Math.sqrt(d)) / (2 * a);
    }

    public double getRoot2() {
        double d = getDiscriminant();
        if (d < 0) {
            return Double.NaN;
        }
        return (-b - Math.sqrt(d)) / (2 * a);
    }

    public void printSolution() {
        // від'ємні коефіцієнти беремо в дужки
        String bText = b < 0 ? "(" + b + ")" : "" + b;
        String cText = c < 0 ? "(" + c + ")" : "" + c;
        System.out.println("Рівняння: " + a + "*x^2 + " + bText + "*x + " + cText + " = 0");

        double d = getDiscriminant();
        System.out.printf(java.util.Locale.US, "Дискримінант D = %.2f%n", d);

        if (d > 0) {
            System.out.println("Рівняння має 2 дійсні корені:");
            System.out.printf(java.util.Locale.US, "  x1 = %.2f%n", getRoot1());
            System.out.printf(java.util.Locale.US, "  x2 = %.2f%n", getRoot2());
        } else if (d == 0) {
            System.out.println("Рівняння має один дійсний корінь:");
            // + 0.0 щоб не друкувався -0.00
            System.out.printf(java.util.Locale.US, "  x = %.2f%n", -b / (2 * a) + 0.0);
        } else {
            System.out.println("Рівняння не має дійсних коренів (D < 0)");
        }
    }
}
