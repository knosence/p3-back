USE sundaland;

INSERT INTO location (location_id, street_address, city, state, postal_code) 
VALUES 
    (1, '541 Peachtree Road', 'Atlanta', 'GA', '30318'),
    (2, '03 Mosinee Plaza', 'Phoenix', 'AZ', '85005'),
    (3, '68044 Daystar Place', 'Columbus', 'GA', '31914'),
    (4, '46 Drewry Drive', 'Chicago', 'IL', '60646'),
    (5, '79215 Holy Cross Center', 'Boca Raton', 'FL', '33499'),
    (6, '28901 Columbus Point', 'Reno', 'NV', '89550');

INSERT INTO company (company_id, company_name, location_id)
VALUES 
    (1, 'Sundaland', 1);

INSERT INTO warehouse (warehouse_id, location_id, warehouse_capacity, company_id)
VALUES  
    (101, 1, 15, 1),
    (102, 2, 19, 1),
    (103, 3, 13, 1),
    (104, 4, 20, 1),
    (105, 5, 14, 1),
    (106, 6, 18, 1);

INSERT INTO employee (employee_id, first_name, Last_name, warehouse_id, employee_email, employee_password, user_role) 
VALUES 
    (1, 'Admin', 'Admin', 101, 'admin@Sundaland.com', 'admin', 'admin'),
    (2, 'Guest', 'Guest', 101, 'guest@Sundaland.com', 'guest', 'guest'),
    (3, 'Manager', 'Manager', 101, 'Manager@Sundaland.com', 'manager', 'manager'),
    (4, 'Employee', 'Employee', 101, 'Employee@Sundaland.com', 'employee', 'user');

INSERT INTO item (item_id, item_name, item_description, item_size) 
VALUES 
    (1, 'Oil - Grapeseed Oil', 'arcu libero rutrum ac lobortis vel dapibus', 17),
    (2, 'Compound - Passion Fruit', 'justo lacinia eget tincidunt eget tempus vel pede morbi', 13),
    (3, 'Tumeric', 'dui vel sem sed sagittis nam congue risus', 12),
    (4, 'Jam - Raspberry,jar', 'odio condimentum id luctus nec molestie sed', 14),
    (5, 'Wine - German Riesling', 'vestibulum sagittis sapien cum sociis natoque', 12),
    (6, 'Ecolab - Solid Fusion', 'posuere cubilia curae duis faucibus accumsan odio curabitur', 15),
    (7, 'Sloe Gin - Mcguinness', 'ligula vehicula consequat morbi a', 10),
    (8, 'Tea - Earl Grey', 'ante vivamus tortor duis mattis egestas metus aenean fermentum', 11),
    (9, 'Napkin - Beverge, White 2 - Ply', 'orci luctus et ultrices posuere', 18),
    (10, 'Steamers White', 'tincidunt in leo maecenas pulvinar lobortis est phasellus', 14),
    (11, 'Catfish - Fillets', 'vestibulum sit amet cursus id turpis integer aliquet massa', 18),
    (12, 'Jicama', 'vestibulum sed magna at nunc commodo placerat praesent blandit nam', 13),
    (13, 'Salt And Pepper Mix - Black', 'pretium iaculis justo in hac', 12),
    (14, 'Spring Roll Wrappers', 'potenti nullam porttitor lacus at', 12),
    (15, 'Onions Granulated', 'eros vestibulum ac est lacinia nisi venenatis tristique fusce congue', 18),
    (16, 'Wine - Riesling Dr. Pauly', 'nisl nunc nisl duis bibendum felis sed interdum venenatis turpis', 16),
    (17, 'Coffee Cup 16oz Foam', 'eget congue eget semper rutrum nulla nunc purus', 12),
    (18, 'Pea - Snow', 'a pede posuere nonummy integer non', 20),
    (19, 'Wine - White, Gewurtzraminer', 'sit amet nunc viverra dapibus nulla suscipit ligula', 12),
    (20, 'Wine - White, Schroder And Schyl', 'sapien iaculis congue vivamus metus arcu adipiscing molestie hendrerit', 14),
    (21, 'Artichokes - Jerusalem', 'purus eu magna vulputate luctus cum sociis', 19),
    (22, 'Chevere Logs', 'suscipit a feugiat et eros vestibulum', 18),
    (23, 'Bar - Granola Trail Mix Fruit Nut', 'nascetur ridiculus mus etiam vel augue vestibulum rutrum rutrum neque', 15),
    (24, 'Wine - Ice Wine', 'amet eros suspendisse accumsan tortor quis turpis sed', 13),
    (25, 'Milk - 2% 250 Ml', 'nulla integer pede justo lacinia eget', 16),
    (26, 'Tomato - Peeled Italian Canned', 'dolor sit amet consectetuer adipiscing elit proin risus praesent lectus', 16),
    (27, 'Oranges - Navel, 72', 'integer non velit donec diam neque vestibulum eget vulputate ut', 19),
    (28, 'Arizona - Plum Green Tea', 'lacinia nisi venenatis tristique fusce congue diam id ornare', 19),
    (29, 'Corn - Cream, Canned', 'vehicula condimentum curabitur in libero ut massa', 12),
    (30, 'Tomatoes - Yellow Hot House', 'nullam sit amet turpis elementum ligula vehicula consequat', 16),
    (31, 'Absolut Citron', 'odio consequat varius integer ac', 12),
    (32, 'Capon - Breast, Wing On', 'ut erat id mauris vulputate elementum nullam varius nulla facilisi', 20),
    (33, 'Port - 74 Brights', 'dis parturient montes nascetur ridiculus', 14),
    (34, 'Bread - Hot Dog Buns', 'aliquam augue quam sollicitudin vitae consectetuer', 17),
    (35, 'Nantuket Peach Orange', 'justo morbi ut odio cras mi pede malesuada in', 20),
    (36, 'Pepper - Green, Chili', 'rutrum ac lobortis vel dapibus at', 13),
    (37, 'Flower - Daisies', 'vehicula condimentum curabitur in libero ut massa', 20),
    (38, 'Muffin - Mix - Mango Sour Cherry', 'sapien non mi integer ac neque', 14),
    (39, 'Croissant, Raw - Mini', 'ante ipsum primis in faucibus orci', 18),
    (40, 'Papadam', 'in libero ut massa volutpat convallis morbi odio odio elementum', 19),
    (41, 'Soup - Beef, Base Mix', 'vel lectus in quam fringilla rhoncus mauris enim leo', 14),
    (42, 'Jack Daniels', 'erat fermentum justo nec condimentum', 10),
    (43, 'Rosemary - Primerba, Paste', 'ultrices mattis odio donec vitae nisi', 10),
    (44, 'Bread - Bistro White', 'id ligula suspendisse ornare consequat lectus', 15),
    (45, 'Sprouts - Onion', 'eu orci mauris lacinia sapien quis libero', 15),
    (46, 'Rice - Jasmine Sented', 'vestibulum ante ipsum primis in faucibus orci luctus', 16),
    (47, 'Pasta - Cappellini, Dry', 'curae duis faucibus accumsan odio curabitur convallis duis', 12),
    (48, 'Vinegar - Tarragon', 'nonummy maecenas tincidunt lacus at velit vivamus vel nulla', 12),
    (49, 'Creme De Cacao White', 'dis parturient montes nascetur ridiculus mus', 13),
    (50, 'Liners - Baking Cups', 'posuere cubilia curae mauris viverra diam vitae quam suspendisse potenti', 19);

INSERT INTO warehouse_inventory (item_id ,inventory_id, warehouse_id, item_quantity) 
VALUES 
	(11,1,101,23),
(28,2,102,24),
(25,3,105,98),
(17,4,102,7),
(18,5,102,83),
(43,6,105,30),
(32,7,101,51),
(7,8,102,23),
(26,9,106,12),
(41,10,104,21),
(16,11,104,46),
(50,12,102,57),
(11,13,106,73),
(40,14,104,34),
(3,15,102,31),
(19,16,106,17),
(5,17,104,27),
(17,18,105,16),
(23,19,103,10),
(22,20,101,20),
(24,21,103,2),
(40,22,105,26),
(48,23,105,34),
(21,24,102,46),
(49,25,103,59),
(28,26,102,92),
(36,27,104,71),
(20,28,105,57),
(13,29,105,27),
(47,30,102,54),
(50,31,102,68),
(10,32,103,43),
(41,33,104,87),
(43,34,105,17),
(37,35,103,73),
(29,36,104,72),
(32,37,102,55),
(24,38,102,30),
(19,39,106,88),
(11,40,101,49),
(14,41,102,94),
(8,42,102,44),
(20,43,103,52),
(12,44,103,72),
(34,45,106,17),
(41,46,106,84),
(49,47,103,54),
(30,48,103,27),
(23,49,102,12),
(10,50,106,16),
(27,51,103,33),
(6,52,106,20),
(40,53,106,26),
(14,54,101,79),
(12,55,102,63),
(45,56,101,97),
(45,57,103,97),
(35,58,103,22),
(29,59,106,59),
(29,60,106,19),
(12,61,105,41),
(38,62,104,16),
(34,63,103,70),
(44,64,101,36),
(2,65,105,6),
(30,66,106,95),
(21,67,105,27),
(39,68,105,11),
(20,69,102,42),
(48,70,106,22),
(16,71,106,79),
(23,72,102,20),
(14,73,104,53),
(25,74,106,79),
(33,75,102,66),
(8,76,104,98),
(15,77,101,78),
(15,78,106,89),
(13,79,102,39),
(4,80,102,60),
(13,81,102,99),
(3,82,102,76),
(25,83,106,99),
(13,84,104,42),
(1,85,103,92),
(49,86,104,72),
(31,87,103,24),
(2,88,101,89),
(10,89,103,82),
(32,90,104,78),
(1,91,105,61),
(31,92,104,52),
(17,93,103,89),
(40,94,101,6),
(25,95,104,40),
(7,96,101,97),
(43,97,103,77),
(31,98,102,86),
(27,99,104,65),
(39,100,106,74);




































































































































































































































































































































































































































































































































































































































































































































































































































































































































