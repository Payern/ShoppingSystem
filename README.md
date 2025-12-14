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
