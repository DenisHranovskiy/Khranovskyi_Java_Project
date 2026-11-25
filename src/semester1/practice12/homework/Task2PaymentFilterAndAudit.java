package semester1.practice12.homework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

// Завдання 2
public class Task2PaymentFilterAndAudit {

    public static void main(String[] args) {
        System.out.println("================ 🛡️ БАНКІВСЬКИЙ ПЛАТІЖНИЙ ФІЛЬТР 🛡️ ================");

        HashSet<String> blocked = new HashSet<>(List.of("ScamShop", "FakeStore"));
        double limit = 20000.0;
        PaymentProcessor processor = new PaymentProcessor(blocked, limit);

        processor.addPayment(new CardPayment("P-01", "Rozetka", 4000.0));
        processor.addPayment(new TransferPayment("P-02", "Comfy", 10000.0));
        processor.addPayment(new CardPayment("P-01", "Rozetka", 4000.0));
        processor.addPayment(new CardPayment("P-03", "ScamShop", 5000.0));
        processor.addPayment(new TransferPayment("P-04", "LuxWatch", 25000.0));
        processor.addPayment(new CardPayment("P-05", "Rozetka", 2000.0));
        processor.addPayment(new TransferPayment("P-06", "Allo", 5000.0));

        System.out.println("Чорний список магазинів [" + blocked.size() + "]: " + processor.getBlockedShopsCopy());
        System.out.printf(Locale.US, "Ліміт одного платежу: %.2f грн | Вхідних платежів: %d%n",
                limit, processor.getPaymentsCopy().size());

        System.out.println();
        System.out.println("--- Очищення черги через Iterator.remove() ---");
        int removed = processor.cleanPayments();

        ArrayList<Payment> approved = processor.getPaymentsCopy();
        System.out.println();
        System.out.println("--- Схвалені платежі (залишилось " + approved.size() + ") ---");
        for (Payment p : approved) {
            System.out.printf(Locale.US, "  ✅ %s | %-7s | Сума: %8.2f | Комісія: %6.2f | Нетто: %8.2f грн%n",
                    p.getId(), p.getShopName(), p.getAmount(), p.calculateFee(), p.getNetAmount());
        }

        System.out.println();
        System.out.println("--- Фінансовий підсумок ---");
        System.out.println("Видалено платежів: " + removed + " | Схвалено: " + approved.size());
        System.out.printf(Locale.US, "Загальна сума (брутто): %.2f грн%n", processor.getTotalGross());
        System.out.printf(Locale.US, "Загальна комісія:       %.2f грн%n", processor.getTotalFees());
        System.out.printf(Locale.US, "Чиста сума (нетто):     %.2f грн%n",
                processor.getTotalGross() - processor.getTotalFees());
        HashSet<String> shops = processor.getApprovedShops();
        System.out.println("Унікальні магазини [" + shops.size() + "]: " + shops);
        System.out.println("====================================================================");
    }
}

abstract class Payment {
    private final String id;
    private final String shopName;
    private final double amount;

    public Payment(String id, String shopName, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сума платежу має бути більшою за 0");
        }
        this.id = id;
        this.shopName = shopName;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public String getShopName() {
        return shopName;
    }

    public double getAmount() {
        return amount;
    }

    public abstract double calculateFee();

    public double getNetAmount() {
        return amount - calculateFee();
    }

    // платежі однакові, якщо збігається id
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Payment other)) {
            return false;
        }
        return Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

class CardPayment extends Payment {
    public CardPayment(String id, String shopName, double amount) {
        super(id, shopName, amount);
    }

    @Override
    public double calculateFee() {
        return getAmount() * 0.015;
    }
}

class TransferPayment extends Payment {
    public TransferPayment(String id, String shopName, double amount) {
        super(id, shopName, amount);
    }

    @Override
    public double calculateFee() {
        return getAmount() * 0.02 + 20.0;
    }
}

class PaymentProcessor {
    private ArrayList<Payment> payments = new ArrayList<>();
    private HashSet<String> blockedShops;
    private double maxLimit;

    public PaymentProcessor(HashSet<String> blockedShops, double maxLimit) {
        this.blockedShops = new HashSet<>(blockedShops);
        this.maxLimit = maxLimit;
    }

    public void addPayment(Payment p) {
        if (p != null) {
            payments.add(p);
        }
    }

    public HashSet<String> getBlockedShopsCopy() {
        return new HashSet<>(blockedShops);
    }

    public ArrayList<Payment> getPaymentsCopy() {
        return new ArrayList<>(payments);
    }

    public int cleanPayments() {
        HashSet<String> seenIds = new HashSet<>();
        int removed = 0;
        Iterator<Payment> it = payments.iterator();
        while (it.hasNext()) {
            Payment p = it.next();
            String reason = null;
            if (!seenIds.add(p.getId())) {
                reason = "[ДУБЛІКАТ]     ";
            } else if (blockedShops.contains(p.getShopName())) {
                reason = "[ЧОРНИЙ СПИСОК]";
            } else if (p.getAmount() > maxLimit) {
                reason = "[ПОНАД ЛІМІТ]  ";
            }
            if (reason != null) {
                System.out.printf(Locale.US, "  ❌ %s %s | %s (%.2f грн) — видалено!%n",
                        reason, p.getId(), p.getShopName(), p.getAmount());
                it.remove();
                removed++;
            }
        }
        return removed;
    }

    public double getTotalGross() {
        double sum = 0;
        for (Payment p : payments) {
            sum += p.getAmount();
        }
        return sum;
    }

    public double getTotalFees() {
        double sum = 0;
        for (Payment p : payments) {
            sum += p.calculateFee();
        }
        return sum;
    }

    public HashSet<String> getApprovedShops() {
        HashSet<String> shops = new HashSet<>();
        for (Payment p : payments) {
            shops.add(p.getShopName());
        }
        return shops;
    }
}
