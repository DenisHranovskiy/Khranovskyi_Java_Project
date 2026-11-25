package semester1.practice10.homework;

import java.util.Locale;

// Завдання 2
public class Task2SmartPaymentAndAuditGateway {

    public static void audit(AbstractPaymentTransaction[] ledger) {
        double turnover = 0;
        double fees = 0;
        double cashbackTotal = 0;

        System.out.println("[1. ПРОВЕДЕННЯ ПАКЕТУ ТРАНЗАКЦІЙ (final process())]:");
        for (AbstractPaymentTransaction tx : ledger) {
            if (tx.process()) {
                turnover += tx.getBaseAmountUah();
                fees += tx.calculateFee();
                System.out.printf(Locale.US, "  ✅ [%s | %s] Сума: %.2f грн | Комісія: %.2f грн | Всього: %.2f грн%n",
                        tx.getTxId(), tx.getPaymentChannel(), tx.getBaseAmountUah(),
                        tx.calculateFee(), tx.getTotalCharged());
            } else {
                System.out.println("  ❌ [" + tx.getTxId() + "] транзакцію відхилено");
            }
        }

        System.out.println();
        System.out.println("[2. АВТОМАТИЧНИЙ АУДИТ МОЖЛИВОСТЕЙ (Pattern Matching instanceof)]:");
        boolean refundTested = false;
        for (AbstractPaymentTransaction tx : ledger) {
            if (!tx.isProcessed()) {
                continue;
            }
            if (tx instanceof CashbackCapable c) {
                double raw = tx.getBaseAmountUah() * c.getCashbackRate();
                double cashback = c.calculateCashback(tx.getBaseAmountUah());
                cashbackTotal += cashback;
                String note = raw > CashbackCapable.MAX_CASHBACK_UAH ? " (Ліміт MAX_CASHBACK_UAH!)" : "";
                System.out.printf(Locale.US,
                        "  💰 [CashbackCapable] %s: розрахунковий %.0f%% = %.2f грн -> нараховано %.2f грн%s%n",
                        tx.getTxId(), c.getCashbackRate() * 100, raw, cashback, note);
            }
            if (tx instanceof BlockchainVerifiable b) {
                System.out.println("  ⛓️ [BlockchainVerifiable] " + tx.getTxId() + ": Hash=" + b.getTxHash()
                        + ", Підтверджень=" + b.getConfirmations() + " (Finalized: " + b.isFinalized() + ")");
            }
            // тестове повернення робимо один раз - для першої транзакції, що це підтримує
            if (!refundTested && tx instanceof Refundable r) {
                String reason = "Подвійне списання";
                String result = r.requestRefund(reason) ? "УСПІШНО ПОВЕРНЕНО!" : "ВІДМОВА";
                System.out.println("  🔄 [Refundable] Спроба повернення " + tx.getTxId()
                        + " ('" + reason + "'): " + result);
                refundTested = true;
            }
        }

        System.out.println();
        System.out.println("[ПІДСУМКОВИЙ ЗВІТ ШЛЮЗУ]:");
        System.out.printf(Locale.US, "  Сумарний базовий оборот:    %.2f грн%n", turnover);
        System.out.printf(Locale.US, "  Сумарна комісія шлюзу:      %.2f грн%n", fees);
        System.out.printf(Locale.US, "  Сумарний виплачений кешбек: %.2f грн%n", cashbackTotal);
    }

    public static void main(String[] args) {
        System.out.println("================ ПРОЦЕСИНГОВИЙ ЦЕНТР FINTECH (POLYMORPHISM & INTERFACES) ================");
        AbstractPaymentTransaction[] ledger = {
                new PremiumCardPayment("TX-101", 20000.0, "**** 4412"),
                new CryptoUsdtPayment("TX-102", 8500.0, "0x9f8a...c4", 18),
                new TaxTreasuryPayment("TX-103", 5000.0, "UA-TAX-11010")
        };
        audit(ledger);
        System.out.println("=========================================================================================");
    }
}

interface CashbackCapable {
    double MAX_CASHBACK_UAH = 500.0;

    double getCashbackRate();

    default double calculateCashback(double baseAmount) {
        return Math.min(MAX_CASHBACK_UAH, baseAmount * getCashbackRate());
    }
}

interface Refundable {
    boolean requestRefund(String reason);

    boolean isRefunded();
}

interface BlockchainVerifiable {
    String getTxHash();

    int getConfirmations();

    default boolean isFinalized() {
        return getConfirmations() >= 12;
    }
}

abstract class AbstractPaymentTransaction {
    private final String txId;
    private final double baseAmountUah;
    private boolean processed;

    public AbstractPaymentTransaction(String txId, double baseAmountUah) {
        this.txId = txId;
        this.baseAmountUah = baseAmountUah;
    }

    public String getTxId() {
        return txId;
    }

    public double getBaseAmountUah() {
        return baseAmountUah;
    }

    public boolean isProcessed() {
        return processed;
    }

    public abstract double calculateFee();

    public abstract String getPaymentChannel();

    // шаблонний метод: порядок перевірок незмінний
    public final boolean process() {
        if (baseAmountUah <= 0 || processed) {
            return false;
        }
        processed = true;
        return true;
    }

    public final double getTotalCharged() {
        return baseAmountUah + calculateFee();
    }
}

class PremiumCardPayment extends AbstractPaymentTransaction implements CashbackCapable, Refundable {
    private final String maskedPan;
    private boolean refunded;

    public PremiumCardPayment(String txId, double amount, String maskedPan) {
        super(txId, amount);
        this.maskedPan = maskedPan;
    }

    public String getMaskedPan() {
        return maskedPan;
    }

    @Override
    public double calculateFee() {
        return getBaseAmountUah() * 0.01;
    }

    @Override
    public String getPaymentChannel() {
        return "Visa Infinite";
    }

    @Override
    public double getCashbackRate() {
        return 0.03;
    }

    @Override
    public boolean requestRefund(String reason) {
        if (isProcessed() && !refunded) {
            refunded = true;
            return true;
        }
        return false;
    }

    @Override
    public boolean isRefunded() {
        return refunded;
    }
}

class CryptoUsdtPayment extends AbstractPaymentTransaction implements CashbackCapable, BlockchainVerifiable {
    private final String txHash;
    private final int confirmations;

    public CryptoUsdtPayment(String txId, double amount, String txHash, int confirmations) {
        super(txId, amount);
        this.txHash = txHash;
        this.confirmations = confirmations;
    }

    @Override
    public double calculateFee() {
        return 40.0;
    }

    @Override
    public String getPaymentChannel() {
        return "USDT TRC-20";
    }

    @Override
    public double getCashbackRate() {
        return 0.01;
    }

    @Override
    public String getTxHash() {
        return txHash;
    }

    @Override
    public int getConfirmations() {
        return confirmations;
    }
}

final class TaxTreasuryPayment extends AbstractPaymentTransaction implements Refundable {
    private final String taxCode;
    private boolean refunded;

    public TaxTreasuryPayment(String txId, double amount, String taxCode) {
        super(txId, amount);
        this.taxCode = taxCode;
    }

    public String getTaxCode() {
        return taxCode;
    }

    @Override
    public double calculateFee() {
        return 0.0;
    }

    @Override
    public String getPaymentChannel() {
        return "ДержКазначейство";
    }

    @Override
    public boolean requestRefund(String reason) {
        if (isProcessed() && !refunded) {
            refunded = true;
            return true;
        }
        return false;
    }

    @Override
    public boolean isRefunded() {
        return refunded;
    }
}
