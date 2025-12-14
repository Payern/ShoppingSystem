import java.sql.*;
import java.util.*;

public class OrderDAO {

    // ✅ Create order and return ID
    public int createOrder(int customerId, double total) throws SQLException {
        Connection conn = DBUtil.getConnection();
        String sql = "INSERT INTO orders (customer_id, total, created_at) VALUES (?, ?, NOW())";
        PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, customerId);
        ps.setDouble(2, total);
        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        int orderId = 0;
        if (rs.next()) {
            orderId = rs.getInt(1);
        }
        conn.close();
        return orderId;
    }

    // ✅ Insert order items
    public void insertOrderItems(int orderId, List<CartItem> items) throws SQLException {
        Connection conn = DBUtil.getConnection();
        String sql = "INSERT INTO order_items (order_id, product_id, quantity) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        for (CartItem item : items) {
            ps.setInt(1, orderId);
            ps.setInt(2, item.getProduct().getId());
            ps.setInt(3, item.getQuantity());
            ps.addBatch();
        }
        ps.executeBatch();
        conn.close();
    }

    // ✅ Read all orders
    public List<Order> getAllOrders() throws SQLException {
        List<Order> orders = new ArrayList<>();
        Connection conn = DBUtil.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM orders");

        while (rs.next()) {
            Order o = new Order(
                rs.getInt("id"),
                rs.getInt("customer_id"),
                rs.getDouble("total"),
                rs.getTimestamp("created_at")
            );
            orders.add(o);
        }
        conn.close();
        return orders;
    }
}