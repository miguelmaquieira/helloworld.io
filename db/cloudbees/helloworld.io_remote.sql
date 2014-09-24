CREATE TABLE Users (
	token varchar(64) NOT NULL PRIMARY KEY,
	email varchar(64),
	password varchar(64),
	status int(11) DEFAULT 0
);

CREATE TABLE UserProfiles (
	userId varchar(64) NOT NULL PRIMARY KEY,
	name varchar(255),
	gender varchar(2),
	pictureURL varchar(255),
	fromLocation varchar(123),
	livingLocation varchar(123),
	shortDescription varchar(123),
	longDescription varchar(255),
	looking varchar(255),
	birthdate DATETIME,
	timezone varchar(255)
);
CREATE INDEX UserProfiles_name ON UserProfiles(name);