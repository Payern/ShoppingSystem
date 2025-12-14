import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CustomerDAO customerDAO = new CustomerDAO();
        ProductDAO productDAO = new ProductDAO();
        OrderDAO orderDAO = new OrderDAO();

        try {
            // ✅ Load customer and products
            Customer customer = customerDAO.getCustomerById(1); // Brian (id=1 in customers table)
            List<Product> products = productDAO.getAllProducts();

            // ✅ Create cart
            Cart cart = new Cart(customer);
            cart.setDiscountStrategy(amount -> amount * 0.90); // 10% discount
            cart.addItem(products.get(0), 2); // example: add 2 of first product

            System.out.println("\nTotal before discount: " + cart.getTotalBeforeDiscount());
            System.out.println("Total after discount: " + cart.getTotalAfterDiscount());

            // ✅ Checkout
            boolean success = cart.checkout(customerDAO, productDAO);

            if (success) {
                int orderId = orderDAO.createOrder(1, cart.getTotalAfterDiscount());
                orderDAO.insertOrderItems(orderId, cart.getItems());

                // ✅ Reload customer and products
                Customer refreshedCustomer = customerDAO.getCustomerById(1);
                List<Product> refreshedProducts = productDAO.getAllProducts();

                System.out.println("\nWallet after checkout: " + refreshedCustomer.getWalletBalance());
                System.out.println("Updated product stock:");
                for (Product p : refreshedProducts) {
                    System.out.println(p.getName() + " | Qty: " + p.getQuantity());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}