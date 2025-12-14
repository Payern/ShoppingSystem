public class Seller extends User {
    private String shopName;

    public Seller(int id, String name, String number, String email, String shopName) {
        super(id, name, number, email);
        this.shopName = shopName;
    }

    public String getShopName() { return shopName; }
    public void setShopName(String shopName) { this.shopName = shopName; }

    @Override
    public void displayInfo() {
        System.out.println("Seller: " + getId() + " | " + getName() + " | " + getNumber() + 
                           " | " + getEmail() + " | Shop: " + shopName);
    }
}