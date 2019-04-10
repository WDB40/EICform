DROP TABLE sessions;
DROP TABLE sessionitems;
DROP DATABASE eicform;

CREATE DATABASE eicform;
USE eicform;

CREATE TABLE sessions(
	session_id INT AUTO_INCREMENT PRIMARY KEY,
    prompting_event VARCHAR(50),
    event_date DATETIME);
    
CREATE TABLE sessionitems(
	item_id INT AUTO_INCREMENT PRIMARY KEY,
    session_id INT,
    item_type VARCHAR(25),
    item_desc VARCHAR(100),
    intensity_level INT,
		CONSTRAINT sessionitems_sessionid_fk FOREIGN KEY (session_id)
			REFERENCES sessions (session_id));