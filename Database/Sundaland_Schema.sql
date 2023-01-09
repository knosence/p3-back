DROP DATABASE  IF EXISTS sundaland;
CREATE DATABASE sundaland;

USE sundaland;

-- DROP TABLE IF EXISTS company;
CREATE TABLE company (
    company_id INT NOT NULL PRIMARY KEY,
    company_name VARCHAR(40) NOT NULL,
    location_id INT NOT NULL REFERENCES location(location_id)
);

-- DROP TABLE IF EXISTS warehouse;
CREATE TABLE warehouse (
	warehouse_id INT NOT NULL PRIMARY KEY, 
	warehouse_name VARCHAR(40) NOT NULL,
	location_id INT NOT NULL REFERENCES location(location_id),
	item_capacity INT NOT NULL,
    company_id INT REFERENCES company(company_id)
);

-- DROP TABLE IF EXISTS location;
CREATE TABLE location (
	location_id INT NOT NULL PRIMARY KEY,
	street_address VARCHAR(60) NOT NULL,
	city VARCHAR(40) NOT NULL,
	state CHAR(2) NOT NULL,
	postal_code INT NOT NULL
);

-- DROP TABLE IF EXISTS item;
CREATE TABLE item (
	item_id INT NOT NULL PRIMARY KEY,
	item_name VARCHAR(40) NOT NULL,
	item_discription TINYTEXT NOT NULL,
	item_size TINYINT NOT NULL
);

-- DROP TABLE IF EXISTS warehouse_inventory;
CREATE TABLE warehouse_inventory (
	item_id INT NOT NULL REFERENCES item(item_id),
	warehouse_id INT NOT NULL REFERENCES warehouse(warehouse_id),
	item_count INT NOT NULL
);

-- DROP TABLE IF EXISTS employee;
CREATE TABLE employee (
	employee_id INT PRIMARY KEY NOT NULL,
	first_name VARCHAR(20) NOT NULL,
	Last_name VARCHAR(40) NOT NULL,
	warehouse_id INT NOT NULL REFERENCES warehouse(warehouse_id),
	email VARCHAR(50) NOT NULL,
	password VARCHAR(30) NOT NULL,
	role INT NOT NULL REFERENCES role(role_id)
);

-- DROP TABLE IF EXISTS role;
CREATE TABLE role (
	role_id INT NOT NULL PRIMARY KEY,
	role_name VARCHAR(10) NOT NULL
);
