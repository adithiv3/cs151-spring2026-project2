public interface Chargeable {
    void addCharge(double amount, String purpose);

    void processPayment(double amount);

    double getOutstandingBalance();
}
