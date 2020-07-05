DROP DATABASE bank_database;
CREATE DATABASE bank_database;
USE bank_database;
-- --------------------------------------------------
CREATE TABLE Bank(
	id int NOT NULL,
    name varchar(30) NOT NULL,
    PRIMARY KEY (id)
);
-- --------------------------------------------------
CREATE TABLE Patron(
	id int NOT NULL,
    name varchar(30) NOT NULL,
    image blob NULL,
    PRIMARY KEY (id)
);
-- --------------------------------------------------
CREATE TABLE Account(
	id int NOT NULL,
    bank_id int NOT NULL,
    patron_id int NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (bank_id) REFERENCES Bank(id),
    FOREIGN KEY (patron_id) REFERENCES Patron(id)
);
-- --------------------------------------------------
CREATE TABLE Transaction(
	id int NOT NULL,
    account_id int NOT NULL,
    amount double NOT NULL,
    type varchar(10) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (account_id) REFERENCES Account(id)
);
-- --------------------------------------------------
CREATE TABLE Address(
	id int NOT NULL,
    street1 varchar(30) NOT NULL,
    street2 varchar(30) Null,
    city varchar(20) NOT NULL,
    state varchar(20) NOT NULL,
    zip varchar(10) NOT NULL,
    country varchar(20) NOT NULL,
    PRIMARY KEY (id)
);
-- --------------------------------------------------
CREATE TABLE address_bank_relationship(
	id int NOT NULL,
    bank_id int NOT NULL,
    address_id int NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (bank_id) REFERENCES Bank(id),
    FOREIGN KEY (address_id) REFERENCES Address(id)
);
-- --------------------------------------------------
CREATE TABLE address_patron_relationship(
	id int NOT NULL,
    patron_id int NOT NULL,
    address_id int NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (patron_id) REFERENCES Patron(id),
    FOREIGN KEY (address_id) REFERENCES Address(id)
);
-- --------------------------------------------------
INSERT INTO Bank VALUES (1,"chase-frisco");
INSERT INTO Bank VALUES (2,"bofa-plano");
INSERT INTO Bank VALUES (3, "chase-frisco");
-- --------------------------------------------------
INSERT INTO Patron VALUES (1,"george","george.png");
INSERT INTO Patron VALUES (2,"ravi","ravi.png");
INSERT INTO Patron VALUES (3,"suraj","suraj.png");
-- --------------------------------------------------
INSERT INTO Account VALUES (1,1,1);
INSERT INTO Account VALUES (2,2,2);
-- --------------------------------------------------
INSERT INTO Transaction VALUES (1,1,100,"debit");
INSERT INTO Transaction VALUES (2,1,200,"credit");
INSERT INTO Transaction VALUES (3,2,300,"debit");
-- --------------------------------------------------
INSERT INTO Address(id,street1,city,state,zip,country) VALUES (1,"789 walnut street","los angeles","ca","87654","US");
INSERT INTO Address(id,street1,city,state,zip,country) VALUES (2,"22 forest creek","asgburn","va","45678","US");
INSERT INTO Address(id,street1,city,state,zip,country) VALUES (3,"5677 elm street","frisco","tx","21842","US");
-- ---------------------------------------------------------------------------------------------------------------------
INSERT INTO address_bank_relationship VALUES (1,1,1);
INSERT INTO address_bank_relationship VALUES (2,2,2);
INSERT INTO address_bank_relationship VALUES (3,3,3);
-- --------------------------------------------------
INSERT INTO address_patron_relationship VALUES (1,1,1);
INSERT INTO address_patron_relationship VALUES (2,2,2);
INSERT INTO address_patron_relationship VALUES (3,3,3);
-- --------------------------------------------------