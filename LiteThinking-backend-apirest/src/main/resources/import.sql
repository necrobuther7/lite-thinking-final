INSERT INTO categories (id, name) VALUES (1, 'Drinks');
INSERT INTO categories (id, name) VALUES (2, 'Bikes');
INSERT INTO categories (id, name) VALUES (3, 'Pets');
INSERT INTO categories (id, name) VALUES (4, 'Home');
INSERT INTO categories (id, name) VALUES (5, 'Market');
INSERT INTO categories (id, name) VALUES (6, 'Fashion');
INSERT INTO categories (id, name) VALUES (7, 'Beauty');
INSERT INTO categories (id, name) VALUES (8, 'Electronics');

INSERT INTO customers (name, lastname, email, password) VALUES('Dario', 'Ospina', 'gospina@gmail.com', '123456');
INSERT INTO customers (name, lastname, email, password) VALUES('Camila', 'Fonseca', 'cfonseca@gmail.com', '123456');
INSERT INTO customers (name, lastname, email, password) VALUES('Valentina', 'Sanchez', 'vsanchez@gmail.com', '123456');
INSERT INTO customers (name, lastname, email, password) VALUES('Carlos', 'Espitia', 'cespitia@gmail.com', '123456');
INSERT INTO customers (name, lastname, email, password) VALUES('Erick', 'Garcia', 'erich.gamma@gmail.com', '123456');
INSERT INTO customers (name, lastname, email, password) VALUES('Ricardo', 'Vargas', 'richard.helm@gmail.com', '123456');
INSERT INTO customers (name, lastname, email, password) VALUES('Hector', 'Orjuela', 'ralph.johnson@gmail.com', '123456');

INSERT INTO products (category_id, name, price, stock) VALUES(8,'panasonic screen LCD', 259990, 10);
INSERT INTO products (category_id, name, price, stock) VALUES(8,'sony digital camera DSC-W320B', 123490, 1);
INSERT INTO products (category_id, name, price, stock) VALUES(8,'Apple iPod shuffle', 1499990, 2);
INSERT INTO products (category_id, name, price, stock) VALUES(8,'Sony Notebook Z110', 37990, 7);
INSERT INTO products (category_id, name, price, stock) VALUES(8,'Hewlett Packard F2280', 69990, 10);
INSERT INTO products (category_id, name, price, stock) VALUES(2,'Bianchi Bicycle 26', 69990, 6);
INSERT INTO products (category_id, name, price, stock) VALUES(4,'Chest of 5 Drawers', 299990, 5);

INSERT INTO orders (description, observation, customer_id) VALUES('Invoice office equipment', null, 1);

INSERT INTO orders_items (amount, order_id, product_id) VALUES(1, 1, 1);
INSERT INTO orders_items (amount, order_id, product_id) VALUES(2, 1, 4);
INSERT INTO orders_items (amount, order_id, product_id) VALUES(1, 1, 5);
INSERT INTO orders_items (amount, order_id, product_id) VALUES(1, 1, 2);

INSERT INTO orders (description, observation, customer_id) VALUES('Bicycle Invoice', 'some important note!', 2);
INSERT INTO orders_items (amount, order_id, product_id) VALUES(1, 2, 6);

