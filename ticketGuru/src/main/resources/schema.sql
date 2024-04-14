SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS appuser;
DROP TABLE IF EXISTS event;
DROP TABLE IF EXISTS ticket;
DROP TABLE IF EXISTS tickettype;
DROP TABLE IF EXISTS transaction;

DROP TABLE IF EXISTS appuser_seq;
DROP TABLE IF EXISTS event_seq;
DROP TABLE IF EXISTS ticket_seq;
DROP TABLE IF EXISTS tickettype_seq;
DROP TABLE IF EXISTS transaction_seq;

SET FOREIGN_KEY_CHECKS=1;

CREATE TABLE event (
event_id BIGINT NOT NULL AUTO_INCREMENT,
eventname VARCHAR(100) NOT NULL,
address VARCHAR(100) NOT NULL,
showtime DATETIME NOT NULL,
description VARCHAR(200) NOT NULL,
maxtickets INTEGER NOT NULL,
duration INTEGER NOT NULL,
PRIMARY KEY (event_id)
);

CREATE TABLE tickettype (
tickettype_id BIGINT NOT NULL AUTO_INCREMENT,
tickettypename VARCHAR(100) NOT NULL,
price DOUBLE NOT NULL,
event_id BIGINT,
PRIMARY KEY (tickettype_id),
FOREIGN KEY (event_id) REFERENCES event(event_id)
);

CREATE TABLE appuser (
appuser_id BIGINT NOT NULL AUTO_INCREMENT,
username VARCHAR(50) NOT NULL,
passwordhash VARCHAR(150) NOT NULL,
role VARCHAR(50) NOT NULL,
firstname VARCHAR(50) NOT NULL,
surname VARCHAR(100) NOT NULL,
address VARCHAR(100) NOT NULL,
phone VARCHAR(30) NOT NULL,
email VARCHAR(50) NOT NULL,
PRIMARY KEY (appuser_id)
);

CREATE TABLE transaction (
transaction_id BIGINT NOT NULL AUTO_INCREMENT,
transactiondate DATE NOT NULL,
ticketsum DOUBLE NOT NULL,
appuser_id BIGINT,
PRIMARY KEY (transaction_id),
FOREIGN KEY (appuser_id) REFERENCES appuser(appuser_id)
);

CREATE TABLE ticket (
    ticket_id BIGINT NOT NULL AUTO_INCREMENT,
    used DATETIME,
    transaction_id BIGINT,
    tickettype_id BIGINT,
    PRIMARY KEY (ticket_id),
    FOREIGN KEY (tickettype_id) REFERENCES tickettype(tickettype_id),
    FOREIGN KEY (transaction_id) REFERENCES transaction(transaction_id)
);

CREATE SEQUENCE event_seq START WITH 3 INCREMENT BY 1;

CREATE SEQUENCE tickettype_seq START WITH 5 INCREMENT BY 1;

CREATE SEQUENCE ticket_seq START WITH 3 INCREMENT BY 1;

CREATE SEQUENCE transaction_seq START WITH 2 INCREMENT BY 1;

CREATE SEQUENCE appuser_seq START WITH 3 INCREMENT BY 1;

INSERT INTO event (eventname, address, showtime, description, maxtickets, duration) VALUES
('Ankkarock', 'Lintukatu 1', '2024-03-11 18:11:00', 'upea tilaisuus', 111, 11),
('Ruisrock', 'Rokkikatu 1', '2024-10-11 18:11:00', 'upea juttu', 567, 123);

INSERT INTO tickettype (tickettypename, price, event_id) VALUES
('aikuisten lippu', 20.0, 1),
('lasten lippu', 10.0, 1),
('opiskelijalippu', 15.0, 2),
('eläkeläislippu', 15.0, 1);

INSERT INTO transaction (transactiondate, ticketsum, appuser_id) VALUES
('2024-03-08', 50.0, NULL);

INSERT INTO appuser (username, passwordHash, role, firstname, surname, address, phone, email) VALUES
('maija', '$2a$10$6KFw5bwNuXu1Mr80yXcglOCEI9cmSlQlSRJK.D6.XvKbaos5LC7By', 'USER', 'Maija', 'Meikäläinen', 
'Postiosoite 1A', '0441234567', 'maijameikalainen@gmail.com'), -- salasana user
('mikko', '$2a$10$/U9C/cQ7sudkeFkJS7OUwOfbIoWEzQPLeMd7cI8RgSfxChyKkNeVu', 'ADMIN', 'Mikko', 'Meikäläinen', 
'Postiosoite 1A', '0447654321', 'mikkomeikalainen@gmail.com'); -- salasana admin

INSERT INTO ticket (used, transaction_id, tickettype_id) VALUES
(NULL, 1, 1),
(NULL, 1, 2);