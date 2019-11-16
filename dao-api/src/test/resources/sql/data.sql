INSERT INTO street (street_id, street_name)
VALUES (1, 'pereulok Brestskikh Diviziy'),
       (2, 'pereulok Vilenskiy 2nd');
ALTER SEQUENCE street_seq restart with 100;

INSERT INTO city (city_id, city_name)
VALUES (1, 'Brest'),
       (2, 'Minsk');
ALTER SEQUENCE city_seq restart with 100;

INSERT INTO address (address_id, city_id, street_id, address_number_house, address_number_apartment)
VALUES (1, 1, 1, '17', '41'),
       (2, 1, 2, '8', '0');
ALTER SEQUENCE address_seq restart with 100;

INSERT INTO client (client_id, client_phone_number, client_first_name, client_last_name, address_id)
VALUES (1, '+37533033120', 'First name 1', 'Last Name 1', 2),
       (2, '+375297232037', 'First name 2', 'Last Name 2', 1);
ALTER SEQUENCE client_seq restart with 100;

INSERT INTO employee_type (employee_type_id, employee_type_name)
VALUES (1, 'administrator'),
       (2, 'director');
ALTER SEQUENCE employee_type_seq restart with 100;

INSERT INTO employee (employee_id, employee_first_name, employee_last_name, employee_type_id)
VALUES (1, 'First name 1', 'Last Name 1', 1),
       (2, 'First name 2', 'Last Name 2', 2);
ALTER SEQUENCE employee_seq restart with 100;

INSERT INTO appearance (appearance_id, appearance_name)
VALUES (1, 'scratches'),
       (2, 'scuffed');
ALTER SEQUENCE appearance_seq restart with 100;

INSERT INTO complectation (complectation_id, complectation_name)
VALUES (1, 'SIM card'),
       (2, 'case');
ALTER SEQUENCE complectation_seq restart with 100;

INSERT INTO defect (defect_id, defect_name)
VALUES (1, 'not charging'),
       (2, 'does not catch the network');
ALTER SEQUENCE defect_seq restart with 100;

INSERT INTO type (type_id, type_name)
VALUES (1, 'smartphone'),
       (2, 'phone');
ALTER SEQUENCE type_seq restart with 100;

INSERT INTO brand (brand_id, brand_name)
VALUES (1, 'Huawei'),
       (2, 'Sony');
ALTER SEQUENCE brand_seq restart with 100;

INSERT INTO model (model_id, model_name)
VALUES (1, 'p-smart'),
       (2, 'xperia xz1');
ALTER SEQUENCE model_seq restart with 100;

INSERT INTO device (device_id, device_imei_or_sn, device_password, type_id, brand_id, model_id,
                    appearance_id, complectation_id, defect_id)
VALUES (1, '37533033120', '37533033120', 1, 1, 1, 1, 1, 1),
       (2, '375297232037', '375297232037', 1, 2, 2, 2, 2, 2);
ALTER SEQUENCE device_seq restart with 100;

INSERT INTO status (status_id, status_name)
VALUES (1, 'In work'),
       (2, 'Waiting for a spare part');
ALTER SEQUENCE status_seq restart with 100;

INSERT INTO spare_part (spare_part_id, spare_part_name, spare_part_cost)
VALUES (1, 'screen', 50),
       (2, 'glass', 20);
ALTER SEQUENCE spare_part_seq restart with 100;

INSERT INTO repair_order (repair_order_id, repair_order_start_date, repair_order_end_date, repair_order_issue_date,
                          repair_order_cost_estimated, spare_part_id, repair_order_cost_total, client_id, device_id,
                          employee_id, status_id)
VALUES (1, '2019-10-12', '2019-10-22', '2019-10-20', 100, 1, 150, 1, 1, 1, 1),
       (2, '2019-10-12', '2019-10-25', '2019-10-22', 110, 2, 160, 2, 2, 2, 2);
ALTER SEQUENCE repair_order_seq restart with 100;