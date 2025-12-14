# ShoppingSystem

A Java + MySQL shopping system project with DAO pattern and database integration.

---

## 🗄️ Database Setup

1. Install MySQL on your system.
2. Create the database:
   ```sql
   CREATE DATABASE shoppingdb;

   ## 🚀 How to Run the Application

1. Open the project in **VS Code** or **NetBeans**.
2. Make sure the MySQL connector JAR is inside the `lib/` folder.
3. Compile and run `Main.java` from the `src/` folder.
4. The application will connect to the `shoppingdb` database and allow you to test the shopping flow.

5. ## 📦 How to Import Everything

Follow these steps to fully set up and run the ShoppingSystem project:

---

### 🗄️ 1. Import the Database

1. Install MySQL.
2. Open your MySQL terminal or GUI (like phpMyAdmin or MySQL Workbench).
3. Create the database:
   ```sql
   CREATE DATABASE shoppingdb;

   mysql -u root -p shoppingdb < shoppingdb.sql

   mysql -u root -p shoppingdb < reset_demo.sql
**Steps to Import and Run `ShoppingSystem*`*

*1. Clone the Repository*
- Open a terminal (or Git Bash).
- Run:
  ```bash
  git clone https://github.com/Payern/ShoppingSystem.git
  ```
- This will create a local folder `ShoppingSystem`.


*2. Open in IDE*
Option A: *VS Code*
- Open VS Code → `File > Open Folder` → select `ShoppingSystem`.
- Make sure you have the **Java Extension Pack** installed (provides Maven/Gradle, debugging, etc.).

*Option B: **NetBeans**
- Open NetBeans → `File > Open Project` → navigate to `ShoppingSystem`.
- NetBeans should detect it as a Java project (if you included `nbproject` or Maven/Gradle files).

 *3. Configure Database (MySQL)*
- Install MySQL (if not already).
- Create a database, e.g.:
  ```sql
  CREATE DATABASE shoppingdb;
  ```
- Import your SQL dump (if you’ve included one in the repo, e.g. `shoppingdb.sql`):
  ```bash
  mysql -u root -p shoppingdb < shoppingdb.sql
  ```
- Confirm tables exist (Products, Users, Orders, etc.).


 *4. Update Database Connection*
- In your project, locate the **DAO or DB utility class** (likely something like `DBConnection.java`).
- Update credentials:
  ```java
  String url = "jdbc:mysql://localhost:3306/shoppingdb";
  String user = "root";
  String password = "your_password";
  ```
- Ensure the **MySQL Connector/J** JAR is included:
  - VS Code: add it to `lib/` and reference in `.classpath` or Maven `pom.xml`.
  - NetBeans: `Project Properties > Libraries > Add JAR`.


 *5. Build the Project*
- If Maven/Gradle is used:
  ```bash
  mvn clean install
  ```
- If plain Java:
  - Compile:
    ```bash
    javac -cp .;lib/mysql-connector-java.jar src/**/*.java
    ```
  - Run:
    ```bash
    java -cp .;lib/mysql-connector-java.jar Main
    ```


*6. Test CRUD Functionality*
- Run the app and test:
  - **Create**: Add a new product.
  - **Read**: List products.
  - **Update**: Edit product details.
  - **Delete**: Remove a product.
- Verify database changes in MySQL:
  ```sql
  SELECT * FROM products;
  ```

7*. Share & Collaborate*

- Include:
  - Required JDK version (e.g., JDK 17).
  - MySQL setup instructions.
  - How to run in VS Code and NetBeans.
  - Example credentials for testing.


✅ With these steps, anyone can import my repo, configure MySQL, and run the ShoppingSystem smoothly.
