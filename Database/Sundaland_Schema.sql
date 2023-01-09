DROP DATABASE  IF EXISTS sundaland;
CREATE DATABASE sundaland;

USE sundaland;

CREATE TABLE location (
	location_id INT NOT NULL PRIMARY KEY,
	street_address VARCHAR(60) NOT NULL,
	city VARCHAR(40) NOT NULL,
	state CHAR(2) NOT NULL,
	postal_code INT NOT NULL
);

CREATE TABLE company (
    company_id INT NOT NULL PRIMARY KEY,
    company_name VARCHAR(40) NOT NULL,
   	location_id INT NOT NULL,
    FOREIGN KEY (location_id) REFERENCES location(location_id)

);

CREATE TABLE warehouse (
    warehouse_id INT NOT NULL PRIMARY KEY,
    warehouse_name VARCHAR(40) NOT NULL,
    location_id INT NOT NULL,
    item_capacity INT NOT NULL,
    company_id INT NOT NULL,
    FOREIGN KEY (company_id)
        REFERENCES company(company_id),
    FOREIGN KEY (location_id)
        REFERENCES location(location_id)
);

CREATE TABLE item (
	item_id INT NOT NULL PRIMARY KEY,
	item_name VARCHAR(40) NOT NULL,
	item_discription TINYTEXT NOT NULL,
	item_size TINYINT NOT NULL
);

CREATE TABLE warehouse_inventory (
	item_id INT NOT NULL,
	warehouse_id INT NOT NULL,
	item_count INT NOT NULL,
    FOREIGN KEY (item_id) REFERENCES item(item_id),
	FOREIGN KEY (warehouse_id) REFERENCES warehouse(warehouse_id)

);

CREATE TABLE employee (
    employee_id INT PRIMARY KEY NOT NULL,
    first_name VARCHAR(20) NOT NULL,
    Last_name VARCHAR(40) NOT NULL,
    warehouse_id INT NOT NULL,
    email VARCHAR(50) NOT NULL,
    password VARCHAR(30) NOT NULL,
    user_role VARCHAR(20) NOT NULL,
    FOREIGN KEY (warehouse_id)
        REFERENCES warehouse (warehouse_id)
);



