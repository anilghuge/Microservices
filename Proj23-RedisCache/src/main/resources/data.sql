-- Create table if it does not exist
CREATE TABLE IF NOT EXISTS tbl_mst_cache_product (
    pid INT AUTO_INCREMENT PRIMARY KEY,
    pname VARCHAR(255),
    price DECIMAL(10,2),
    qty DECIMAL(10,2)
);

INSERT INTO tbl_mst_cache_product (pname, price, qty) VALUES ('Apple iPhone 13', 999.99, 50);
INSERT INTO tbl_mst_cache_product (pname, price, qty) VALUES ('Samsung Galaxy S21', 799.99, 60);
INSERT INTO tbl_mst_cache_product (pname, price, qty) VALUES ('Sony WH-1000XM4 Headphones', 349.99, 120);
INSERT INTO tbl_mst_cache_product (pname, price, qty) VALUES ('Dell XPS 13 Laptop', 1299.99, 30);
INSERT INTO tbl_mst_cache_product (pname, price, qty) VALUES ('HP Envy 15', 1099.99, 40);
INSERT INTO tbl_mst_cache_product (pname, price, qty) VALUES ('Samsung 55" QLED TV', 799.99, 25);
INSERT INTO tbl_mst_cache_product (pname, price, qty) VALUES ('Bose QuietComfort 35 II', 299.99, 70);
INSERT INTO tbl_mst_cache_product (pname, price, qty) VALUES ('Apple AirPods Pro', 249.99, 150);
INSERT INTO tbl_mst_cache_product (pname, price, qty) VALUES ('Google Pixel 6', 599.99, 80);
INSERT INTO tbl_mst_cache_product (pname, price, qty) VALUES ('OnePlus 9 Pro', 969.99, 100);
INSERT INTO tbl_mst_cache_product (pname, price, qty) VALUES ('Sony PlayStation 5', 499.99, 10);
INSERT INTO tbl_mst_cache_product (pname, price, qty) VALUES ('Microsoft Xbox Series X', 499.99, 15);
INSERT INTO tbl_mst_cache_product (pname, price, qty) VALUES ('Nvidia GeForce RTX 3080', 699.99, 30);
INSERT INTO tbl_mst_cache_product (pname, price, qty) VALUES ('Corsair Vengeance LPX 16GB RAM', 69.99, 200);
INSERT INTO tbl_mst_cache_product (pname, price, qty) VALUES ('Samsung 1TB SSD', 129.99, 250);
INSERT INTO tbl_mst_cache_product (pname, price, qty) VALUES ('Apple MacBook Pro 16"', 2399.99, 20);
INSERT INTO tbl_mst_cache_product (pname, price, qty) VALUES ('Kindle Paperwhite', 129.99, 180);
INSERT INTO tbl_mst_cache_product (pname, price, qty) VALUES ('Garmin Forerunner 945', 599.99, 50);
INSERT INTO tbl_mst_cache_product (pname, price, qty) VALUES ('Fitbit Charge 5', 179.99, 150);
INSERT INTO tbl_mst_cache_product (pname, price, qty) VALUES ('GoPro HERO 10 Black', 499.99, 40);