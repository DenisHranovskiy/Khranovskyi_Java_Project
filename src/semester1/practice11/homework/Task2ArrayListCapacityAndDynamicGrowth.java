package semester1.practice11.homework;

// Завдання 2
public class Task2ArrayListCapacityAndDynamicGrowth {

    public static void main(String[] args) {
        System.out.println("================ ЕМУЛЯТОР ВНУТРІШНЬОЇ БУДОВИ ARRAYLIST (ПІД КАПОТОМ) ================");

        // var бачить тип праворуч: CustomArrayCapacityEmulator<String>
        var emulator = new CustomArrayCapacityEmulator<String>();
        // Небезпечно: var raw = new ArrayList<>(); - тип виведеться як ArrayList<Object>,
        // і в такий список можна додати що завгодно
        System.out.println("[ІНІЦІАЛІЗАЦІЯ]: Створено CustomArrayCapacityEmulator<String> | size = "
                + emulator.size() + " | capacity = " + emulator.getCapacity());

        System.out.println();
        System.out.println("--- Додавання 35 елементів у список ---");
        for (int i = 1; i <= 35; i++) {
            int oldCapacity = emulator.getCapacity();
            int oldSize = emulator.size();
            emulator.add("Block-" + i);
            if (emulator.getCapacity() > oldCapacity) {
                System.out.println("  ⚡ [GROW #" + emulator.getResizeCount() + "] Переповнення при додаванні "
                        + i + "-го елемента! Ємність: " + oldCapacity + " -> " + emulator.getCapacity()
                        + " (System.arraycopy скопіював " + oldSize + " ел.)");
            }
        }
        System.out.println("Стан після додавання 35 елементів: size = " + emulator.size()
                + " | capacity = " + emulator.getCapacity()
                + " (Вільний резерв: " + (emulator.getCapacity() - emulator.size()) + " комірок null)");

        System.out.println();
        System.out.println("--- Тестування вставки add(0, 'HEADER') та видалення remove(5) ---");
        int shiftedRight = emulator.size();
        emulator.add(0, "HEADER");
        System.out.println("  -> Вставлено 'HEADER' на індекс 0 (зсунуто праворуч " + shiftedRight
                + " елементів через System.arraycopy)");
        int shiftedLeft = emulator.size() - 5 - 1;
        String removed = emulator.remove(5);
        System.out.println("  -> Видалено елемент '" + removed + "' з індексу 5 (зсунуто ліворуч "
                + shiftedLeft + " елементів, хвіст занулено для GC)");
        System.out.println("  Поточний стан: size = " + emulator.size() + " | capacity = " + emulator.getCapacity()
                + " | Перший: '" + emulator.get(0) + "' | Останній: '" + emulator.get(emulator.size() - 1) + "'");

        System.out.println();
        System.out.println("--- Оптимізація пам'яті trimToSize() ---");
        int before = emulator.getCapacity();
        emulator.trimToSize();
        System.out.println("  -> Викликано trimToSize(): буфер Object[" + before + "] стиснуто рівно до Object["
                + emulator.getCapacity() + "]!");
        System.out.println("  Фінальна телеметрія: size = " + emulator.size() + " | capacity = "
                + emulator.getCapacity() + " | Кількість розширень: " + emulator.getResizeCount()
                + " | Скопійовано при розширеннях: " + emulator.getTotalElementsCopied());
        System.out.println("=====================================================================================");
    }
}

class CustomArrayCapacityEmulator<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elementData;
    private int size = 0;
    private int resizeCount = 0;
    private int totalElementsCopied = 0;

    public CustomArrayCapacityEmulator() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    private void ensureCapacityInternal() {
        if (size == elementData.length) {
            int oldCapacity = elementData.length;
            // ріст у 1.5 раза; Math.max потрібен після trimToSize() для малих масивів (0 або 1)
            int newCapacity = Math.max(oldCapacity + (oldCapacity >> 1), size + 1);
            Object[] newBuffer = new Object[newCapacity];
            System.arraycopy(elementData, 0, newBuffer, 0, size);
            elementData = newBuffer;
            resizeCount++;
            totalElementsCopied += size;
        }
    }

    public void add(E element) {
        ensureCapacityInternal();
        elementData[size++] = element;
    }

    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Невірний індекс: " + index);
        }
        ensureCapacityInternal();
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = element;
        size++;
    }

    public E remove(int index) {
        E old = get(index);
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        elementData[--size] = null;
        return old;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        checkIndex(index);
        return (E) elementData[index];
    }

    public E set(int index, E element) {
        E old = get(index);
        elementData[index] = element;
        return old;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Невірний індекс: " + index);
        }
    }

    public int size() {
        return size;
    }

    public int getCapacity() {
        return elementData.length;
    }

    public int getResizeCount() {
        return resizeCount;
    }

    public int getTotalElementsCopied() {
        return totalElementsCopied;
    }

    public void trimToSize() {
        if (size < elementData.length) {
            Object[] trimmed = new Object[size];
            System.arraycopy(elementData, 0, trimmed, 0, size);
            elementData = trimmed;
        }
    }
}
