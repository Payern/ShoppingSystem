-- Reset customer wallets
UPDATE customers SET wallet = 5000;

-- Reset product stock
UPDATE products SET quantity = 100;

-- Clear past orders
DELETE FROM order_items;
DELETE FROM orders;

-- Show updated customers
SELECT id, name, email, wallet FROM customers;

-- Show updated products
SELECT id, name, price, quantity FROM products;

-- Show orders (should be empty)
SELECT * FROM orders;
SELECT * FROM order_items;