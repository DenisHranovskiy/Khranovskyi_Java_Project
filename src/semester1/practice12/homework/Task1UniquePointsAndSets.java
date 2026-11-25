package semester1.practice12.homework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

// Завдання 1
public class Task1UniquePointsAndSets {

    public static void main(String[] args) {
        System.out.println("================ 📡 ГЕОДЕЗИЧНИЙ РАДАР: HASHSET ТА ITERATOR 📡 ================");

        ArrayList<Point2D> rawA = new ArrayList<>(List.of(
                new Point2D(0, 0), new Point2D(3, 4), new Point2D(1, 2), new Point2D(3, 4),
                new Point2D(6, 8), new Point2D(5, 0), new Point2D(1, 2)));
        ArrayList<Point2D> rawB = new ArrayList<>(List.of(
                new Point2D(3, 4), new Point2D(5, 0), new Point2D(2, 2), new Point2D(8, 6),
                new Point2D(2, 2), new Point2D(0, 10)));

        HashSet<Point2D> setA = new HashSet<>(rawA);
        HashSet<Point2D> setB = new HashSet<>(rawB);
        System.out.println("Сенсор A: отримано " + rawA.size() + " точок -> унікальних (HashSet): "
                + setA.size() + " " + setA);
        System.out.println("Сенсор B: отримано " + rawB.size() + " точок -> унікальних (HashSet): "
                + setB.size() + " " + setB);

        System.out.println();
        System.out.println("--- Операції над множинами (HashSet) ---");
        HashSet<Point2D> all = PointSetUtils.union(setA, setB);
        HashSet<Point2D> common = PointSetUtils.intersection(setA, setB);
        HashSet<Point2D> onlyA = PointSetUtils.difference(setA, setB);
        System.out.println("Об'єднання (A U B) [" + all.size() + "]:  " + all);
        System.out.println("Перетин (A ∩ B) [" + common.size() + "]:     " + common);
        System.out.println("Різниця (A \\ B) [" + onlyA.size() + "]:     " + onlyA);

        System.out.println();
        System.out.println("--- Фільтрація через Iterator (R_max = 7.0) ---");
        int removed = PointSetUtils.removeFarPoints(all, 7.0);
        System.out.println("Видалено точок поза радіусом: " + removed);
        System.out.println("Залишилось у зоні [" + all.size() + "]:   " + all);
        System.out.println("==============================================================================");
    }
}

class Point2D {
    private final int x;
    private final int y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double distanceFromOrigin() {
        return Math.sqrt(x * x + y * y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Point2D other)) {
            return false;
        }
        return x == other.x && y == other.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "(" + x + "; " + y + ")";
    }
}

class PointSetUtils {

    // кожна операція працює з копією, вхідні множини не змінюються
    public static HashSet<Point2D> union(HashSet<Point2D> a, HashSet<Point2D> b) {
        HashSet<Point2D> result = new HashSet<>(a);
        result.addAll(b);
        return result;
    }

    public static HashSet<Point2D> intersection(HashSet<Point2D> a, HashSet<Point2D> b) {
        HashSet<Point2D> result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }

    public static HashSet<Point2D> difference(HashSet<Point2D> a, HashSet<Point2D> b) {
        HashSet<Point2D> result = new HashSet<>(a);
        result.removeAll(b);
        return result;
    }

    public static int removeFarPoints(HashSet<Point2D> points, double maxRadius) {
        int removed = 0;
        Iterator<Point2D> it = points.iterator();
        while (it.hasNext()) {
            if (it.next().distanceFromOrigin() > maxRadius) {
                it.remove();
                removed++;
            }
        }
        return removed;
    }
}
