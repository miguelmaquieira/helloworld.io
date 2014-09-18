CREATE TABLE Users (
	token varchar(64) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	email varchar(64),
	name varchar(255),
	password varchar(64),
	status int(11) DEFAULT 0,
	gender varchar(2)
);
CREATE INDEX Users_name ON Users(name);