import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Cart {
    private List<CartItem> items = new ArrayList<>();
    private Customer customer;
    private Function<Double, Double> discountStrategy = amount -> amount; // default: no discount

    public Cart(Customer customer) {
        this.customer = customer;
    }

    public void addItem(Product product, int quantity) {
        items.add(new CartItem(product, quantity));
    }

    public List<CartItem> getItems() {
        return items;
    }

    // ✅ Total before discount
    public double getTotalBeforeDiscount() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getProduct().getPrice() * item.getQuantity();
        }
        return total;
    }

    // ✅ Apply discount strategy
    public double getTotalAfterDiscount() {
        return discountStrategy.apply(getTotalBeforeDiscount());
    }

    // ✅ Allow Main.java to set discount strategy
    public void setDiscountStrategy(Function<Double, Double> strategy) {
        this.discountStrategy = strategy;
    }

    // ✅ Checkout with DAOs passed in
    public boolean checkout(CustomerDAO customerDAO, ProductDAO productDAO) {
        double total = getTotalAfterDiscount();
        boolean paid = customer.debit(total);

        if (paid) {
            try {
                customerDAO.updateCustomerWallet(customer.getId(), customer.getWalletBalance());
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }

            for (CartItem item : items) {
                Product p = item.getProduct();
                int newQty = p.getQuantity() - item.getQuantity();
                try {
                    productDAO.updateProductStock(p.getId(), newQty);
                } catch (SQLException e) {
                    e.printStackTrace();
                    return false;
                }
            }

            System.out.println("✅ Checkout successful! Total paid: " + total);
            return true;
        } else {
            System.out.println("❌ Insufficient wallet balance. Checkout failed.");
            return false;
        }
    }
}