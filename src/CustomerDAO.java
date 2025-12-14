import java.sql.*;

public class CustomerDAO {

    // ✅ Create
    public void addCustomer(Customer customer) throws SQLException {
        Connection conn = DBUtil.getConnection();
        String sql = "INSERT INTO customers (name, number, email, wallet) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, customer.getName());
        ps.setString(2, customer.getNumber());
        ps.setString(3, customer.getEmail());
        ps.setDouble(4, customer.getWalletBalance());
        ps.executeUpdate();
        conn.close();
    }

    // ✅ Read
    public Customer getCustomerById(int id) throws SQLException {
        Connection conn = DBUtil.getConnection();
        String sql = "SELECT * FROM customers WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        Customer c = null;
        if (rs.next()) {
            c = new Customer(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("number"),
                rs.getString("email"),
                rs.getDouble("wallet")
            );
        }
        conn.close();
        return c;
    }

    // ✅ Update wallet balance
    public void updateCustomerWallet(int id, double newBalance) throws SQLException {
        Connection conn = DBUtil.getConnection();
        String sql = "UPDATE customers SET wallet=? WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setDouble(1, newBalance);
        ps.setInt(2, id);
        ps.executeUpdate();
        conn.close();
    }

    // ✅ Delete
    public void deleteCustomer(int id) throws SQLException {
        Connection conn = DBUtil.getConnection();
        String sql = "DELETE FROM customers WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        conn.close();
    }
}