import java.sql.*;
import java.util.*;

public class ProductDAO {

    // ✅ Create
    public void addProduct(Product product) throws SQLException {
        Connection conn = DBUtil.getConnection();
        String sql = "INSERT INTO products (name, price, quantity, seller_id) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, product.getName());
        ps.setDouble(2, product.getPrice());
        ps.setInt(3, product.getQuantity());
        ps.setInt(4, product.getSellerId());
        ps.executeUpdate();
        conn.close();
    }

    // ✅ Read all
    public List<Product> getAllProducts() throws SQLException {
        List<Product> products = new ArrayList<>();
        Connection conn = DBUtil.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM products");

        while (rs.next()) {
            Product p = new Product(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getDouble("price"),
                rs.getInt("quantity"),
                rs.getInt("seller_id")
            );
            products.add(p);
        }
        conn.close();
        return products;
    }

    // ✅ Update stock
    public void updateProductStock(int id, int newQty) throws SQLException {
        Connection conn = DBUtil.getConnection();
        String sql = "UPDATE products SET quantity=? WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, newQty);
        ps.setInt(2, id);
        ps.executeUpdate();
        conn.close();
    }

    // ✅ Delete
    public void deleteProduct(int id) throws SQLException {
        Connection conn = DBUtil.getConnection();
        String sql = "DELETE FROM products WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        conn.close();
    }
}