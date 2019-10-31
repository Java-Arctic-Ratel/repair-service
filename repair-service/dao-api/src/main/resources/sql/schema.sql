DROP TABLE IF EXISTS city;
CREATE TABLE city (
                      city_id INT NOT NULL AUTO_INCREMENT,
                      city_name VARCHAR(40) NOT NULL,
                      PRIMARY KEY (city_id),
);

DROP TABLE IF EXISTS street;
CREATE TABLE street (
                        street_id INT NOT NULL AUTO_INCREMENT,
                        street_name VARCHAR(40) NOT NULL,
                        PRIMARY KEY (street_id),
);

DROP TABLE IF EXISTS address;
CREATE TABLE address (
                         address_id INT NOT NULL AUTO_INCREMENT,
                         city_id INT NOT NULL,
                         street_id INT NOT NULL,
                         address_number_house VARCHAR(40) NOT NULL,
                         address_number_apartment VARCHAR(40) NULL,
                         PRIMARY KEY (address_id),
                         FOREIGN KEY (city_id) REFERENCES city (city_id),
                         FOREIGN KEY (street_id) REFERENCES street (street_id)
);