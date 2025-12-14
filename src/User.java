public abstract class User {
    protected int id;          // maps to DB primary key
    protected String name;
    protected String number;
    protected String email;

    public User(int id, String name, String number, String email) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.email = email;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getNumber() { return number; }
    public String getEmail() { return email; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setNumber(String number) { this.number = number; }
    public void setEmail(String email) { this.email = email; }

    public void displayInfo() {
        System.out.println("User: " + id + " | " + name + " | " + number + " | " + email);
    }
}