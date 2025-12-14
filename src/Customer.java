public class Customer extends User {
    private double wallet;

    public Customer(int id, String name, String number, String email, double wallet) {
        super(id, name, number, email);
        this.wallet = wallet;
    }

    public double getWallet() { return wallet; }
    public void setWallet(double wallet) { this.wallet = wallet; }

    // ✅ Added methods for Cart & Main
    public boolean debit(double amount) {
        if (wallet >= amount) {
            wallet -= amount;
            return true;
        }
        return false;
    }

    public double getWalletBalance() {
        return wallet;
    }
}