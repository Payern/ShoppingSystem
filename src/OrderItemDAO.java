import java.sql.*;
import java.util.*;

public class OrderItemDAO {

    // ✅ Create (Insert)
    public void addOrderItem(OrderItem orderItem) throws SQLException {
        Connection conn = DBUtil.getConnection();
        String sql = "INSERT INTO order_items (order_id, product_id, quantity) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, orderItem.getOrderId());
        ps.setInt(2, orderItem.getProductId());
        ps.setInt(3, orderItem.getQuantity());
        ps.executeUpdate();
        conn.close();
    }

    // ✅ Read (Select All)
    public List<OrderItem> getAllOrderItems() throws SQLException {
        List<OrderItem> items = new ArrayList<>();
        Connection conn = DBUtil.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM order_items");

        while (rs.next()) {
            OrderItem item = new OrderItem(
                rs.getInt("id"),
                rs.getInt("order_id"),
                rs.getInt("product_id"),
                rs.getInt("quantity")
            );
            items.add(item);
        }
        conn.close();
        return items;
    }

    // ✅ Read (Find by Order ID)
    public List<OrderItem> getItemsByOrderId(int orderId) throws SQLException {
        List<OrderItem> items = new ArrayList<>();
        Connection conn = DBUtil.getConnection();
        String sql = "SELECT * FROM order_items WHERE order_id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, orderId);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            OrderItem item = new OrderItem(
                rs.getInt("id"),
                rs.getInt("order_id"),
                rs.getInt("product_id"),
                rs.getInt("quantity")
            );
            items.add(item);
        }
        conn.close();
        return items;
    }

    // ✅ Update
    public void updateOrderItem(OrderItem orderItem) throws SQLException {
        Connection conn = DBUtil.getConnection();
        String sql = "UPDATE order_items SET order_id=?, product_id=?, quantity=? WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, orderItem.getOrderId());
        ps.setInt(2, orderItem.getProductId());
        ps.setInt(3, orderItem.getQuantity());
        ps.setInt(4, orderItem.getId());
        ps.executeUpdate();
        conn.close();
    }

    // ✅ Delete
    public void deleteOrderItem(int id) throws SQLException {
        Connection conn = DBUtil.getConnection();
        String sql = "DELETE FROM order_items WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        conn.close();
    }
}