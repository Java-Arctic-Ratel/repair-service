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