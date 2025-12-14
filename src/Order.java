import java.util.Date;

public class Order {
    private int id;
    private int customerId;
    private double total;
    private Date createdAt;

    public Order(int id, int customerId, double total, Date createdAt) {
        this.id = id;
        this.customerId = customerId;
        this.total = total;
        this.createdAt = createdAt;
    }

    // Getters & Setters
    public int getId() { return id; }
    public int getCustomerId() { return customerId; }
    public double getTotal() { return total; }
    public Date getCreatedAt() { return createdAt; }

    public void setId(int id) { this.id = id; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }
    public void setTotal(double total) { this.total = total; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }
}