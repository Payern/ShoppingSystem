import java.sql.*;
import java.util.*;

public class SellerDAO {

    // ✅ Create (Insert)
    public void addSeller(Seller seller) throws SQLException {
        Connection conn = DBUtil.getConnection();
        String sql = "INSERT INTO sellers (name, number, email, shopName) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, seller.getName());
        ps.setString(2, seller.getNumber());
        ps.setString(3, seller.getEmail());
        ps.setString(4, seller.getShopName());
        ps.executeUpdate();
        conn.close();
    }

    // ✅ Read (Select All)
    public List<Seller> getAllSellers() throws SQLException {
        List<Seller> sellers = new ArrayList<>();
        Connection conn = DBUtil.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM sellers");

        while (rs.next()) {
            Seller s = new Seller(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("number"),
                rs.getString("email"),
                rs.getString("shopName")
            );
            sellers.add(s);
        }
        conn.close();
        return sellers;
    }

    // ✅ Read (Find by ID)
    public Seller getSellerById(int id) throws SQLException {
        Connection conn = DBUtil.getConnection();
        String sql = "SELECT * FROM sellers WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        Seller s = null;
        if (rs.next()) {
            s = new Seller(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("number"),
                rs.getString("email"),
                rs.getString("shopName")
            );
        }
        conn.close();
        return s;
    }

    // ✅ Update
    public void updateSeller(Seller seller) throws SQLException {
        Connection conn = DBUtil.getConnection();
        String sql = "UPDATE sellers SET name=?, number=?, email=?, shopName=? WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, seller.getName());
        ps.setString(2, seller.getNumber());
        ps.setString(3, seller.getEmail());
        ps.setString(4, seller.getShopName());
        ps.setInt(5, seller.getId());
        ps.executeUpdate();
        conn.close();
    }

    // ✅ Delete
    public void deleteSeller(int id) throws SQLException {
        Connection conn = DBUtil.getConnection();
        String sql = "DELETE FROM sellers WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        conn.close();
    }
}