package semester1.practice11.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Завдання 1
public class Task1WrapperAndAutoboxingMemory {

    public static void inspectIntegerCache(int[] testValues) {
        for (int val : testValues) {
            Integer first = Integer.valueOf(val);
            Integer second = Integer.valueOf(val);
            // тут == навмисно, щоб порівняти саме посилання
            boolean sameReference = first == second;
            String source = sameReference ? "IntegerCache" : "Новий об'єкт у Heap!";
            System.out.printf("  Значення: %5d | (a == b): %-5b | a.equals(b): %b | Джерело: %s%n",
                    val, sameReference, first.equals(second), source);
        }
    }

    public static void demonstrateAutoboxingUnderTheHood() {
        Integer autoInt = 42;                       // autoboxing
        Integer manualInt = Integer.valueOf(42);    // те саме явно
        int unboxedInt = manualInt.intValue();
        System.out.println("  Явне пакування: Integer.valueOf(42) -> " + manualInt
                + " | Розпакування: .intValue() -> " + unboxedInt
                + " | неявне = явне: " + autoInt.equals(manualInt));

        Double autoDouble = 3.14;
        Double manualDouble = Double.valueOf(3.14);
        double unboxedDouble = manualDouble.doubleValue();
        System.out.println("  Double.valueOf(3.14) -> " + manualDouble + " | .doubleValue() -> " + unboxedDouble
                + " | неявне = явне: " + autoDouble.equals(manualDouble));

        Boolean autoBool = true;
        Boolean manualBool = Boolean.valueOf(true);
        boolean unboxedBool = manualBool.booleanValue();
        System.out.println("  Boolean.valueOf(true) -> " + manualBool + " | .booleanValue() -> " + unboxedBool
                + " | неявне = явне: " + autoBool.equals(manualBool));

        List<Integer> sensors = new ArrayList<>(Arrays.asList(45, null, -12, 88, null, 102));
        System.out.println("  Вхідний список із датчиків (з null): " + sensors);
        int sum = 0;
        for (int i = 0; i < sensors.size(); i++) {
            Integer value = sensors.get(i);
            if (value == null) {
                System.out.println("  ⚠️ Пропущено null-елемент на індексі " + i
                        + " (запобігання NullPointerException при intValue()!)");
                continue;
            }
            sum += value.intValue();
        }
        System.out.println("  Сума валідних розпакованих елементів: " + sum);
    }

    public static List<Integer> parseTelemetryStream(String[] rawPackets) {
        List<Integer> result = new ArrayList<>();
        for (String packet : rawPackets) {
            if (packet == null || packet.trim().isEmpty()) {
                System.out.println("  ❌ Порожній або null-пакет відхилено");
                continue;
            }
            try {
                result.add(Integer.parseInt(packet.trim()));
            } catch (NumberFormatException e) {
                System.out.println("  ❌ Пакет '" + packet + "' відхилено (NumberFormatException)");
            }
        }
        return result;
    }

    public static void printExtremesAndStats(List<Integer> validData) {
        if (validData.isEmpty()) {
            System.out.println("  Немає даних для аналізу");
            return;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        long sum = 0; // long, бо сума може вийти за межі int
        System.out.println("  Початкові межі пошуку: min = " + min + " (MAX_VALUE), max = " + max + " (MIN_VALUE)");
        for (int value : validData) {
            if (value < min) {
                min = value;
            }
            if (value > max) {
                max = value;
            }
            sum += value;
        }
        System.out.println("  Знайдений мінімум: " + min + " | Знайдений максимум: " + max + " | Сума: " + sum);

        // працюємо з копіями, щоб не змінювати вхідний список
        List<Integer> byValue = new ArrayList<>(validData);
        byValue.remove(Integer.valueOf(-30));
        System.out.println("  Після remove(Integer.valueOf(-30)) (за значенням): " + byValue);

        List<Integer> byIndex = new ArrayList<>(validData);
        byIndex.remove(0);
        System.out.println("  Після remove(0) (за індексом): " + byIndex);
    }

    public static void main(String[] args) {
        System.out.println("================ ДОСЛІДЖЕННЯ WRAPPER CLASSES ТА INTEGER CACHE ================");
        System.out.println("[1. ЕКСПЕРИМЕНТ: INTEGER CACHE [-128..127] (== проти .equals())]:");
        inspectIntegerCache(new int[]{-128, -50, 0, 127, 128, 500, 2026});

        System.out.println();
        System.out.println("[2. AUTOBOXING / UNBOXING ПІД КАПОТОМ ТА ЗАХИСТ ВІД NULL]:");
        demonstrateAutoboxingUnderTheHood();

        System.out.println();
        System.out.println("[3. ПАРСИНГ РЯДКІВ (Integer.parseInt) ТА ЕКСТРЕМУМИ (MAX_VALUE / MIN_VALUE)]:");
        String[] raw = {"  145 ", "-30", "ERR_404", "980", "", null, "2147483647", "-85"};
        List<Integer> parsed = parseTelemetryStream(raw);
        System.out.println("  Успішно розпізнаний список Integer: " + parsed);
        printExtremesAndStats(parsed);
        System.out.println("==============================================================================");
    }
}
