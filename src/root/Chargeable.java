public interface Chargeable {
    void addCharge(double amount, String reason);

    void processPayment(double amount);

    double getOutstandingBalance();
}
