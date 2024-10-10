DROP TABLE IF EXISTS staff;
CREATE TABLE staff(
id VARCHAR(6) NOT NULL,
name VARCHAR(20) NOT NULL,
description VARCHAR(30),
authorityLevel INT(1),
note VARCHAR(40),
PRIMARY KEY (id)
);