DROP DATABASE  IF EXISTS sundaland;
CREATE DATABASE sundaland;

USE sundaland;

CREATE TABLE location (
	location_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT ,
	street_address VARCHAR(60) NOT NULL,
	city VARCHAR(40) NOT NULL,
	state CHAR(2) NOT NULL,
	postal_code INT NOT NULL
);

CREATE TABLE company (
    company_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    company_name VARCHAR(40) NOT NULL,
   	location_id INT NOT NULL,
    CONSTRAINT FK_CompanyLocation FOREIGN KEY (location_id) REFERENCES location(location_id)

);

CREATE TABLE warehouse (
    warehouse_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    location_id INT NOT NULL,
    warehouse_capacity INT NOT NULL,
    company_id INT NOT NULL,
CONSTRAINT FK_CompanyWarehouse
    FOREIGN KEY (company_id)
        REFERENCES company(company_id),
CONSTRAINT FK_WarehouseLocation
    FOREIGN KEY (location_id)
        REFERENCES location(location_id),
);

CREATE TABLE item (
	item_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	item_name VARCHAR(40) NOT NULL,
	item_description VARCHAR(255) NOT NULL,
	item_size TINYINT NOT NULL
);

CREATE TABLE warehouse_inventory (
	item_id INT NOT NULL,
	inventory_id INT NOT NULL,
	warehouse_id INT NOT NULL,
	item_quantity INT NOT NULL,
CONSTRAINT FK_InventoryItem
	FOREIGN KEY (item_id) REFERENCES item(item_id),
CONSTRAINT FK_WarehouseInventory
	FOREIGN KEY (warehouse_id) REFERENCES warehouse(warehouse_id)

);

CREATE TABLE employee (
    employee_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(20) NOT NULL,
    Last_name VARCHAR(40) NOT NULL,
    warehouse_id INT NOT NULL,
    employee_email VARCHAR(50) NOT NULL,
    employee_password VARCHAR(30) NOT NULL,
    user_role VARCHAR(20) NOT NULL,
CONSTRAINT FK_WarehouseEmployee
    FOREIGN KEY (warehouse_id)
        REFERENCES warehouse (warehouse_id)
);



