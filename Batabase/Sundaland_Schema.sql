Drop DATABASE  IF EXISTS Sundaland;
CREATE DATABASE Sundaland;

DROP TABLE IF EXISTS company;
CREATE TABLE company (
    company_id INT NOT NULL PRIMARY KEY,
    company_name VARCHAR(40) NOT NULL,
    location_id smallint NOT NULL REFERENCES location(location_id)
);

DROP TABLE IF EXISTS warehouse;
CREATE TABLE warehouse (
	warehouse_id INT NOT NULL PRIMARY KEY, 
	warehouse_name VARCHAR(40) NOT NULL,
	location_id SMALLINT NOT NULL REFERENCES location(location_id),
	item_capacity SMALLINT NOT NULL,
    company_id SMALLINT REFERENCES company(company_id)
);

DROP TABLE IF EXISTS location;
create table location (
	location_id SMALLINT NOT NULL PRIMARY KEY,
	street_address VARCHAR(60) NOT NULL,
	city VARCHAR(40) NOT NULL,
	state CHAR(2) NOT NULL,
	postal_code int NOT NULL
);

DROP TABLE IF EXISTS item;
create table item (
	item_id INT NOT NULL PRIMARY KEY,
	item_name VARCHAR(40) NOT NULL,
	item_discription TINYTEXT NOT NULL,
	item_size TINYINT NOT NULL
);

DROP TABLE IF EXISTS warehouse_inventory;
CREATE TABLE warehouse_inventory (
	item_id SMALLINT NOT NULL REFERENCES item(item_id),
	warehouse_id SMALLINT not NULL REFERENCES warehouse(warehouse_id),
	item_count SMALLINT NOT NULL
);

DROP TABLE IF EXISTS employee;
create table employee (
	employee_id SMALLINT PRIMARY KEY NOT NULL,
	first_name VARCHAR(20) NOT NULL,
	Last_name VARCHAR(40) NOT NULL,
	warehouse_id SMALLINT NOT NULL REFERENCES warehouse(warehouse_id),
	email VARCHAR(50) NOT NULL,
	password VARCHAR(30) NOT NULL,
	role SMALLINT NOT NULL REFERENCES role(role_id)
);

DROP TABLE IF EXISTS role;
create table role (
	role_id SMALLINT NOT NULL PRIMARY KEY,
	role_name VARCHAR(10) NOT NULL
);
