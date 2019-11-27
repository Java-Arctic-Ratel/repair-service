INSERT INTO street (street_id, street_name)
VALUES (1, 'pereulok Brestskikh Diviziy'),
       (2, 'pereulok Vilenskiy 2nd');
SELECT setval('street_seq', (SELECT MAX(street_id) FROM street));

INSERT INTO city (city_id, city_name)
VALUES (1, 'Brest'),
       (2, 'Minsk'),
       (3, 'Kobrin'),
       (4, 'Pinsk'),
       (5, 'Visokoe'),
       (6, 'Ivanovo'),
       (7, 'Stolin'),
       (8, 'Bereza');
SELECT setval('city_seq', (SELECT MAX(city_id) FROM city));

INSERT INTO address (address_id, city_id, street_id, address_number_house, address_number_apartment)
VALUES (1, 1, 1, '17', '41'),
       (2, 1, 2, '8', '0');
SELECT setval('address_seq', (SELECT MAX(address_id) FROM address));

INSERT INTO client (client_id, client_phone_number, client_first_name, client_last_name, address_id)
VALUES (1, '+37533033120', 'First name 1', 'Last Name 1', 2),
       (2, '+375297232037', 'First name 2', 'Last Name 2', 1);
SELECT setval('client_seq', (SELECT MAX(client_id) FROM client));

INSERT INTO employee_type (employee_type_id, employee_type_name)
VALUES (1, 'administrator'),
       (2, 'director'),
       (3, 'accountant'),
       (4, 'master'),
       (5, 'manager');
SELECT setval('employee_type_seq', (SELECT MAX(employee_type_id) FROM employee_type));

INSERT INTO employee (employee_id, employee_first_name, employee_last_name, employee_type_id)
VALUES (1, 'First name 1', 'Last Name 1', 2),
       (2, 'First name 2', 'Last Name 2', 3);
SELECT setval('employee_seq', (SELECT MAX(employee_id) FROM employee));

INSERT INTO appearance (appearance_id, appearance_name)
VALUES (1, 'scratches'),
       (2, 'scuffed'),
       (3, 'chipped'),
       (4, 'cracked glass'),
       (5, 'missing button');
SELECT setval('appearance_seq', (SELECT MAX(appearance_id) FROM appearance));

INSERT INTO complectation (complectation_id, complectation_name)
VALUES (1, 'SIM card'),
       (2, 'case'),
       (3, 'memory card'),
       (4, 'stylus');
SELECT setval('complectation_seq', (SELECT MAX(complectation_id) FROM complectation));

INSERT INTO defect (defect_id, defect_name)
VALUES (1, 'not charging'),
       (2, 'does not catch the network'),
       (3, 'does not turn on'),
       (4, 'screen does not work'),
       (5, 'the speaker does not work'),
       (6, 'buttons do not work');
SELECT setval('defect_seq', (SELECT MAX(defect_id) FROM defect));

INSERT INTO type (type_id, type_name)
VALUES (1, 'smartphone'),
       (2, 'phone'),
       (3, 'laptop'),
       (4, 'printer'),
       (5, 'scanner'),
       (6, 'MFP'),
       (7, 'monitor'),
       (8, 'pager');
SELECT setval('type_seq', (SELECT MAX(type_id) FROM type));

INSERT INTO brand (brand_id, brand_name)
VALUES (1, 'Huawei'),
       (2, 'Sony'),
       (3, 'Samsung'),
       (4, 'Xiaomi'),
       (5, 'ASUS'),
       (6, 'Apple'),
       (7, 'Nokia');
SELECT setval('brand_seq', (SELECT MAX(brand_id) FROM brand));

INSERT INTO model (model_id, model_name)
VALUES (1, 'p-smart'),
       (2, 'xperia xz1');
SELECT setval('model_seq', (SELECT MAX(model_id) FROM model));

INSERT INTO device (device_id, device_imei_or_sn, device_password, type_id, brand_id, model_id, appearance_id,
                    complectation_id, defect_id)
VALUES (1, '37533033120', '37533033120', 1, 1, 1, 1, 1, 1),
       (2, '375297232037', '375297232037', 1, 2, 2, 2, 2, 2);
SELECT setval('device_seq', (SELECT MAX(device_id) FROM device));

INSERT INTO status (status_id, status_name)
VALUES (1, 'In work'),
       (2, 'Waiting for a spare part'),
       (3, 'Ready'),
       (4, 'Issued');
SELECT setval('status_seq', (SELECT MAX(status_id) FROM status));

INSERT INTO spare_part (spare_part_id, spare_part_name, spare_part_cost)
VALUES (1, 'screen', 50),
       (2, 'glass', 20);
SELECT setval('spare_part_seq', (SELECT MAX(spare_part_id) FROM spare_part));

INSERT INTO repair_order (repair_order_id, repair_order_start_date, repair_order_end_date, repair_order_issue_date,
                          repair_order_cost_estimated, spare_part_id, repair_order_cost_total, client_id, device_id,
                          employee_id, status_id)
VALUES (1, '2019-10-12', '2019-10-22', '2019-10-20', 100, 1, 150, 1, 1, 1, 1),
       (2, '2019-10-12', '2019-10-25', '2019-10-22', 110, 2, 160, 2, 2, 2, 2);
SELECT setval('repair_order_seq', (SELECT MAX(repair_order_id) FROM repair_order));