package semester1.practice09.homework;

import java.util.Arrays;
import java.util.Locale;

// Завдання 2
public class Task2WorkstationConfigurator {

    public static void main(String[] args) {
        System.out.println("================ КОНФІГУРАТОР РОБОЧОЇ СТАНЦІЇ (КОМПОЗИЦІЯ) ================");

        Motherboard board = new Motherboard("ASUS ROG B650", "AM5", 4);
        PowerSupplyUnit psu = new PowerSupplyUnit("Seasonics 750W Gold", 750, 0.90);
        WorkstationPC pc = new WorkstationPC("DeepLearning-Rig", board, psu);

        int[] samples = {7420, 7450, 7390};
        NvmeSsdDrive ssd = new NvmeSsdDrive("Samsung 990 Pro 2TB", 8400.0, 2000, 7450, samples);

        System.out.println("[ПЕРЕВІРКА СУМІСНОСТІ]:");
        pc.installComponent(new ProcessorUnit("Intel Core i9", 27000.0, "LGA1700", 24, 6.0, 253));
        pc.installComponent(new ProcessorUnit("AMD Ryzen 9 7950X", 26500.0, "AM5", 16, 5.7, 170));
        pc.installComponent(new GraphicsAccelerator("NVIDIA RTX 4080 Super", 44000.0, 16, 552, 320));
        pc.installComponent(ssd);
        // ця відеокарта вже не поміститься в ліміт блока живлення
        pc.installComponent(new GraphicsAccelerator("NVIDIA RTX 4090", 90000.0, 24, 512, 450));

        System.out.println();
        System.out.println(pc);

        System.out.println();
        System.out.println("[ЗАХИСНЕ КОПІЮВАННЯ NvmeSsdDrive]:");
        samples[0] = 0;
        int[] fromGetter = ssd.getSpeedSamples();
        fromGetter[1] = 0;
        System.out.println("  Зовнішній масив після змін: " + Arrays.toString(samples));
        System.out.println("  Копія з геттера після змін: " + Arrays.toString(fromGetter));
        System.out.println("  Дані всередині накопичувача: " + Arrays.toString(ssd.getSpeedSamples()));
        System.out.println("===========================================================================");
    }
}

class Motherboard {
    private final String model;
    private final String socketType;
    private final int maxExpansionSlots;

    public Motherboard(String model, String socketType, int maxExpansionSlots) {
        this.model = model;
        this.socketType = socketType;
        // кількість слотів у межах 1..8
        this.maxExpansionSlots = Math.max(1, Math.min(8, maxExpansionSlots));
    }

    public String getModel() {
        return model;
    }

    public String getSocketType() {
        return socketType;
    }

    public int getMaxExpansionSlots() {
        return maxExpansionSlots;
    }

    public boolean isSocketCompatible(String cpuSocket) {
        return socketType.equalsIgnoreCase(cpuSocket);
    }
}

class PowerSupplyUnit {
    private final String model;
    private final int maxOutputWatts;
    private final double efficiencyCoefficient;

    public PowerSupplyUnit(String model, int maxOutputWatts, double efficiencyCoefficient) {
        this.model = model;
        this.maxOutputWatts = Math.max(0, maxOutputWatts);
        // ККД у межах [0.80; 0.96]
        this.efficiencyCoefficient = Math.max(0.80, Math.min(0.96, efficiencyCoefficient));
    }

    public String getModel() {
        return model;
    }

    public double getEfficiencyCoefficient() {
        return efficiencyCoefficient;
    }

    public int getSafeContinuousWatts() {
        return (int) (maxOutputWatts * 0.85);
    }

    public double calculateWallPowerDraw(int internalLoadWatts) {
        return internalLoadWatts / efficiencyCoefficient;
    }
}

abstract class AbstractHardwareComponent {
    private final String modelName;
    private final double priceUah;

    public AbstractHardwareComponent(String modelName, double priceUah) {
        this.modelName = modelName;
        this.priceUah = priceUah >= 0 ? priceUah : 0.0;
    }

    public String getModelName() {
        return modelName;
    }

    public double getPriceUah() {
        return priceUah;
    }

    public abstract int getPowerWatts();

    public abstract double getBenchmarkScore();

    public abstract String getCategory();

    @Override
    public String toString() {
        return String.format(Locale.US, "[%s] %s (%d Вт | Score: %.1f)",
                getCategory(), modelName, getPowerWatts(), getBenchmarkScore());
    }
}

class ProcessorUnit extends AbstractHardwareComponent {
    private final String socket;
    private final int cores;
    private final double boostClockGhz;
    private final int tdpWatts;

    public ProcessorUnit(String modelName, double priceUah, String socket,
                         int cores, double boostClockGhz, int tdpWatts) {
        super(modelName, priceUah);
        this.socket = socket;
        this.cores = cores;
        this.boostClockGhz = boostClockGhz;
        this.tdpWatts = tdpWatts;
    }

    public String getSocket() {
        return socket;
    }

    @Override
    public int getPowerWatts() {
        return tdpWatts;
    }

    @Override
    public double getBenchmarkScore() {
        return cores * boostClockGhz * 120.0;
    }

    @Override
    public String getCategory() {
        return "CPU";
    }
}

class GraphicsAccelerator extends AbstractHardwareComponent {
    private final int vramGb;
    private final int tensorCores;
    private final int boardPowerWatts;

    public GraphicsAccelerator(String modelName, double priceUah, int vramGb,
                               int tensorCores, int boardPowerWatts) {
        super(modelName, priceUah);
        this.vramGb = vramGb;
        this.tensorCores = tensorCores;
        this.boardPowerWatts = boardPowerWatts;
    }

    @Override
    public int getPowerWatts() {
        return boardPowerWatts;
    }

    @Override
    public double getBenchmarkScore() {
        return vramGb * 250.0 + tensorCores * 1.5;
    }

    @Override
    public String getCategory() {
        return "GPU";
    }
}

class NvmeSsdDrive extends AbstractHardwareComponent {
    private final int capacityGb;
    private final int readSpeedMbSec;
    private final int[] speedSamples;

    public NvmeSsdDrive(String modelName, double priceUah, int capacityGb,
                        int readSpeedMbSec, int[] speedSamples) {
        super(modelName, priceUah);
        this.capacityGb = capacityGb;
        this.readSpeedMbSec = readSpeedMbSec;
        this.speedSamples = speedSamples == null ? new int[0] : Arrays.copyOf(speedSamples, speedSamples.length);
    }

    public int getCapacityGb() {
        return capacityGb;
    }

    public int[] getSpeedSamples() {
        return Arrays.copyOf(speedSamples, speedSamples.length);
    }

    @Override
    public int getPowerWatts() {
        return 12;
    }

    @Override
    public double getBenchmarkScore() {
        return readSpeedMbSec * 0.25;
    }

    @Override
    public String getCategory() {
        return "NVMe SSD";
    }
}

class WorkstationPC {
    private final String buildName;
    private final Motherboard motherboard;
    private final PowerSupplyUnit psu;
    private final AbstractHardwareComponent[] components;
    private int componentCount;

    public WorkstationPC(String buildName, Motherboard motherboard, PowerSupplyUnit psu) {
        this.buildName = buildName;
        this.motherboard = motherboard;
        this.psu = psu;
        this.components = new AbstractHardwareComponent[motherboard.getMaxExpansionSlots()];
    }

    public boolean installComponent(AbstractHardwareComponent comp) {
        if (comp == null) {
            return false;
        }
        if (componentCount >= motherboard.getMaxExpansionSlots()) {
            System.out.println("❌ Відмова: немає вільних слотів для " + comp.getModelName());
            return false;
        }
        if (comp.getCategory().equals("CPU")) {
            ProcessorUnit cpu = (ProcessorUnit) comp;
            if (!motherboard.isSocketCompatible(cpu.getSocket())) {
                System.out.println("❌ Відмова: Процесор " + cpu.getModelName() + " (" + cpu.getSocket()
                        + ") несумісний із платою " + motherboard.getModel()
                        + " (Сокет " + motherboard.getSocketType() + ")!");
                return false;
            }
        }
        int newLoad = getTotalPowerWatts() + comp.getPowerWatts();
        if (newLoad > psu.getSafeContinuousWatts()) {
            System.out.println("❌ Відмова: " + comp.getModelName() + " перевантажить БЖ ("
                    + newLoad + " Вт > " + psu.getSafeContinuousWatts() + " Вт)!");
            return false;
        }
        components[componentCount++] = comp;
        System.out.println("✅ Встановлено: " + comp);
        return true;
    }

    public int getTotalPowerWatts() {
        int sum = 0;
        for (int i = 0; i < componentCount; i++) {
            sum += components[i].getPowerWatts();
        }
        return sum;
    }

    public double getTotalSystemScore() {
        double sum = 0;
        for (int i = 0; i < componentCount; i++) {
            sum += components[i].getBenchmarkScore();
        }
        return sum;
    }

    public double getTotalBuildPrice() {
        double sum = 0;
        for (int i = 0; i < componentCount; i++) {
            sum += components[i].getPriceUah();
        }
        return sum;
    }

    @Override
    public String toString() {
        int load = getTotalPowerWatts();
        String status = load <= psu.getSafeContinuousWatts() ? "СТАБІЛЬНО!" : "ПЕРЕВАНТАЖЕННЯ!";
        String report = "[ПАСПОРТ ЗБІРКИ '" + buildName + "']:\n";
        report += String.format(Locale.US, "  Материнська плата: %s (Socket: %s, Слотів: %d/%d)%n",
                motherboard.getModel(), motherboard.getSocketType(), componentCount,
                motherboard.getMaxExpansionSlots());
        report += String.format(Locale.US, "  Блок живлення:     %s (Безпечний ліміт 85%%: %d Вт, ККД: %.0f%%)%n",
                psu.getModel(), psu.getSafeContinuousWatts(), psu.getEfficiencyCoefficient() * 100);
        for (int i = 0; i < componentCount; i++) {
            report += "    " + (i + 1) + ") " + components[i] + "\n";
        }
        report += String.format(Locale.US,
                "  Внутрішнє споживання: %d Вт (З розетки з урахуванням ККД: %.2f Вт) -> %s%n",
                load, psu.calculateWallPowerDraw(load), status);
        report += String.format(Locale.US, "  Сумарний індекс продуктивності: %.2f балів%n", getTotalSystemScore());
        report += String.format(Locale.US, "  Загальна вартість конфігурації: %.2f грн", getTotalBuildPrice());
        return report;
    }
}
