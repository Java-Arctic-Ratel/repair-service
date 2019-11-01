INSERT INTO street (street_id, street_name) VALUES
(1, 'pereulok Brestskikh Diviziy'),
(2, 'pereulok Vilenskiy 2nd');

INSERT INTO city (city_id, city_name) VALUES
(1, 'Brest'),
(2, 'Minsk'),
(3, 'Kobrin'),
(4, 'Pinsk'),
(5, 'Visokoe'),
(6, 'Ivanovo'),
(7, 'Stolin'),
(8, 'Bereza');

INSERT INTO address (address_id, city_id, street_id, address_number_house, address_number_apartment) VALUES
(1, 1, 1,'17','41'),
(2, 1, 2, '8','0');

INSERT INTO first_name (first_name_id, first_name) VALUES
(1, 'Aliaksandr'),
(2, 'Siarhei'),
(3, 'Aleksei'),
(4, 'Andrei'),
(5, 'Anna'),
(6, 'Artem'),
(7, 'Ihar'),
(8, 'Ivan'),
(9, 'Maxim'),
(10, 'Mikhail');

INSERT INTO last_name (last_name_id, last_name) VALUES
(1, 'Arkhutsik'),
(2, 'Ramaniuk'),
(3, 'Ivanov'),
(4, 'Petrov'),
(5, 'Sidorov');

INSERT INTO patronymic (patronymic_id, patronymic) VALUES
(1, 'Ivanavich'),
(2, 'Nikalaevich'),
(3, 'Ivanovich'),
(4, 'Petrovich'),
(5, 'Sidirovich');

INSERT INTO client (client_id, client_phone_number, first_name_id, last_name_id, patronymic_id, address_id) VALUES
(1, '+37533033120', 2,1,1,2),
(2, '+375297232037', 1,2,2,1);

INSERT INTO executor (executor_id, first_name_id, last_name_id, patronymic_id) VALUES
(1, 1, 2,2),
(2, 2, 1, 1);

INSERT INTO appearance (appearance_id, appearance_name) VALUES
(1, 'scratches'),
(2, 'scuffed'),
(3, 'chipped'),
(4, 'cracked glass'),
(5, 'missing button');

INSERT INTO complectation (complectation_id, complectation_name) VALUES
(1, 'SIM card'),
(2, 'case'),
(3, 'memory card'),
(4, 'stylus');

INSERT INTO defect (defect_id, defect_name) VALUES
(1, 'not charging'),
(2, 'does not catch the network'),
(3, 'does not turn on'),
(4, 'screen does not work'),
(5, 'the speaker does not work'),
(6, 'buttons do not work');

INSERT INTO device_condition (device_condition_id, appearance_id, complectation_id, defect_id) VALUES
(1, 1, 1, 1),
(2, 2, 2, 2);

INSERT INTO brand (brand_id, brand_name) VALUES
(1, 'Huawei'),
(2, 'Sony'),
(3, 'Samsung'),
(4, 'Xiaomi'),
(5, 'ASUS'),
(6, 'Apple'),
(7, 'Nokia');

INSERT INTO model (model_id, model_name) VALUES
(1, 'p-smart'),
(2, 'xperia xz1');

INSERT INTO device (device_id, device_imei_or_sn, device_password, client_id, device_condition_id, brand_id, model_id) VALUES
(1, '37533033120', '37533033120',1,1,1,1),
(2, '375297232037', '375297232037',2,2,2,2);

INSERT INTO status (status_id, status_name) VALUES
(1, 'in work'),
(2, 'ready'),
(3, 'given to client');

INSERT INTO spare_parts (spare_parts_id, spare_parts_name, spare_parts_cost) VALUES
(1, 'screen', 50),
(2, 'glass', 20);

INSERT INTO orders (orders_id, orders_start_date, orders_end_date, orders_issue_date, orders_cost_estimated, spare_parts_id,
                    orders_cost_total, client_id, device_id, executor_id, status_id) VALUES
(1, '2019-10-12', '2019-10-22','2019-10-20',100,1,150,1,1,1,1),
(2, '2019-10-12', '2019-10-25','2019-10-22',110,2,160,2,2,2,2);

